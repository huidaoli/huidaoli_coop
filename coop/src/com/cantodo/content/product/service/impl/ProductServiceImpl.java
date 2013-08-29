package com.cantodo.content.product.service.impl;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.frame.business.Init;
import com.base.frame.dao.DictBussManager;
import com.base.frame.model.DictBuss;
import com.cantodo.content.JsonValueProcessorImpl;
import com.cantodo.content.dto.FileUpload;
import com.cantodo.content.dto.ProPic;
import com.cantodo.content.dto.Product;
import com.cantodo.content.dto.ProductShop;
import com.cantodo.content.front.tool.AverageImageScale;
import com.cantodo.content.front.tool.Constant;
import com.cantodo.content.persistence.ProductMapper;
import com.cantodo.content.product.service.ProductService;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService
{

    private Log logger = LogFactory.getLog(ProductServiceImpl.class);
    
    private String fromurl = Init.getMap().get("frompath");
    private String tourl = Init.getMap().get("topath");
    
    private String databaseurl = Init.getMap().get("databaseurl");
    private String databaseusername = Init.getMap().get("databaseusername"); 
    private String databasepassword = Init.getMap().get("databasepassword");

    @Autowired
    private DictBussManager dictBussManager;

    @Autowired
    private ProductMapper productMapper;

    private List<DictBuss> listDictBuss(int type)
    {
        return dictBussManager.listDictBuss(type);
    }

    @Override
    public List<Product> getAllProduct2(Map pata)
    {
        logger.debug("");
        List<Product> list = null;
        try
        {
            list = productMapper.getAllProduct(pata);
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getCounts2(Map param)
    {
        return productMapper.getCounts(param);
    }

    @Override
    public List<Product> getAllProduct(Map pata)
    {
        logger.debug("");
        List<Product> list = null;
        try
        {
            list = productMapper.getAllProduct(pata);
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getCounts(Map param)
    {
        return productMapper.getCounts(param);
    }

    @Transactional
    @Override
    public void add(Product product, String path, List<FileUpload> list)
    {
        product.setCode(UUID.randomUUID().toString());
        product.setCreateDate(new Date());
        // 商品待审核状态
        product.setState(Constant.PRODUCT_STATE_START_1);

        // 商品货架状态
        product.setState(Constant.ONLINE);

        List<String[]> uploadlist = null;
        try
        {
            uploadlist = upload(path, list);
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
        List<ProPic> list2 = new ArrayList<ProPic>();
        int i = 0;
        for (String[] s : uploadlist)
        {
            if (("typeimg").equals(s[0]))
            {
                product.setTypeimg(s[2]);
            }
            else
            {
                list2.add(new ProPic(product.getCode(), (i++), s[1], s[2], ""));
            }
        }

        try
        {
            productMapper.insert(product);
            productMapper.insertProPic(list2);
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }

    }

    @Transactional
    public void update(Product product, String path, List<FileUpload> list)
    {
        List<String[]> uploadlist = null;
        try
        {
            uploadlist = upload(path, list);
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
        List<ProPic> list2 = new ArrayList<ProPic>();
        int i = 0;
        for (String[] s : uploadlist)
        {
            if (("typeimg").equals(s[0]))
            {
                product.setTypeimg(s[2]);
            }
            else
            {
                list2.add(new ProPic(product.getCode(), (i++), s[1], s[2], ""));
            }
        }

        try
        {
            productMapper.update(product);
            String ids = product.getTempdeleids();
            if (StringUtils.isNotEmpty(ids))
            {
                String[] idsarr = ids.split("\\,");
                for (String id : idsarr)
                {
                    productMapper.deleteProPicById(NumberUtils.toInt(id, 0));
                }
            }

            if (null != list2 && list2.size() > 0)
            {
                // productMapper.deleteProPic(product.getCode());
                productMapper.insertProPic(list2);
            }

        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
            throw e;
        }

    }

    private List<String[]> upload(String path, List<FileUpload> list) throws Exception
    {
        logger.debug("enter add");
        File[] uploadFiles = null;
        String[] fileNames = null;
        String filename = null;
        String filename2 = null;

        File uploadFile = null;
        File file = null;
        File file2 = null;
        List<String[]> list2 = new ArrayList<String[]>();
        int width;
        int height;
        for (FileUpload fileUpload : list)
        {

            uploadFiles = fileUpload.getUploadFiles();
            fileNames = fileUpload.getFileNames();
            for (int i = 0; i < uploadFiles.length; i++)
            {

                uploadFile = uploadFiles[i];

                // 文件大小为0，不考虑
                if (!uploadFile.exists())
                {
                    continue;
                }

                if (!isImage(uploadFile))
                {
                    // 不是图片继续
                    continue;
                }

                // 如果文件夹不存在，创建文件夹,将文件保存到目录
                File dir = new File(path);
                if (!dir.exists())
                {
                    dir.mkdirs();
                }

                String ext = fileNames[i].substring(fileNames[i].indexOf("."), fileNames[i].length());// 获取文件扩展名

                ext = ext.toLowerCase();

                filename = UUID.randomUUID().toString() + ext;

                filename2 = UUID.randomUUID().toString() + ext;

                file = new File(path + File.separator + filename);

                file2 = new File(path + File.separator + filename2);

                if ("typeimg".equals(fileUpload.getControlName()))
                {
                    width = 210;
                    height = 140;

                }
                else
                {
                    width = 115;
                    height = 74;
                    AverageImageScale.resizeFix(uploadFile, file, 684, 394);
                }

                AverageImageScale.resizeFix(uploadFile, file2, width, height);

                list2.add(new String[] {fileUpload.getControlName(), filename, filename2});

            }
        }

        logger.debug("exit add");

        return list2;

    }

    private boolean isImage(File file)
    {

        Image src = null;
        try
        {
            src = javax.imageio.ImageIO.read(file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        if (null == src)
        {
            return false;
        }
        return true;

    }

    @SuppressWarnings("unchecked")
    public String getProductList(Map param)
    {
        logger.debug("enter getList");

        JsonConfig jsonConfig = new JsonConfig();
        // 处理属性为Date类型
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessorImpl());

        Map result = new HashMap();
        List<Product> list = null;
        int total = 0;
        try
        {
            list = productMapper.getAllProduct2(param);
            total = productMapper.getCounts2(param);
        }
        catch (RuntimeException e1)
        {
            logger.debug("", e1);
        }

        result.put("total", total);
        result.put("rows", list);

        String s = "";
        try
        {
            // s = JSONObject.fromObject(result, jsonConfig).toString();
            JSONObject json = JSONObject.fromObject(result, jsonConfig);
            s = json.toString();
        }
        catch (Exception e)
        {
            logger.error("JSONObject.fromObject(result,jsonConfig).toString()", e);
            e.printStackTrace();
        }

        logger.debug("exit getList");
        return s;

    }

    @Override
    public Product getInfoById(int id)
    {
        return productMapper.getInfoById(id);
    }

    @Override
    public List<ProPic> getProPicByCode(String code)
    {
        List<ProPic> list = null;
        try
        {
            list = productMapper.getProPicByCode(code);
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    @Transactional
    public void delete(String idarr)
    {

        JSONArray jsonArray = JSONArray.fromObject(idarr);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        Product p = null;

        for (int id : ids)
        {
            p = productMapper.getInfoById(id);
            if (null != p)
            {
                productMapper.deleteProPic(p.getCode());
            }
            productMapper.delete(id);

        }

    }

    @Override
    public void lineOpt(String idarr, int state)
    {
        JSONArray jsonArray = JSONArray.fromObject(idarr);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        Map cmap = new HashMap();
        // for 赋值给map时，无需new HashMap，因为map后覆盖前的
        for (int id : ids)
        {

            cmap.put("id", id);
            cmap.put("state", state);
            productMapper.lineOpt(cmap);

        }

    }

    /**
     * [简要描述]:<br/> [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param idarr
     * @param state
     * @exception
     * @see com.cantodo.content.product.service.ProductService#stateOpt(java.lang.String,
     *      int)
     */
    @Override
    public void stateOpt(String idarr, int state)
    {
        JSONArray jsonArray = JSONArray.fromObject(idarr);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        Map cmap = new HashMap();

        // for 赋值给map时，无需new HashMap，因为map后覆盖前的
        for (int id : ids)
        {

            cmap.put("id", id);
            cmap.put("state", state);
            productMapper.stateOpt(cmap);
        }

    }

    /**
     * [简要描述]:<br/> [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param memid
     * @return
     * @exception
     * @see com.cantodo.content.product.service.ProductService#getAllProductToPage(int)
     */
    @Override
    public List<Product> getAllProductToPage(int memid)
    {
        List<Product> rlist = null;

        try
        {
            rlist = productMapper.getAllProductToPage(memid);
            for (Product r : rlist)
            {
                r.setImglist(productMapper.getProPicByCode(r.getCode()));
            }

        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rlist;
    }

    @Override
    @Transactional
    public void syncDataToShop(Product pro)
    {

        List<ProPic> listpropic = productMapper.getProPicByCode(pro.getCode());
        pro.setImglist(listpropic);
        ProductShop productShop = adaptor(pro);

        int goodsid = exist(productShop);

        int returnGoodsId = 0;

        // 新增
        if (-1 == goodsid)
        {
            returnGoodsId = save(productShop);
        }
        // 修改
        else
        {
            returnGoodsId = update(productShop, goodsid);
        }
        Map cmap = new HashMap();
        cmap.put("id", pro.getId());
        cmap.put("mallurl", Init.getMap().get("mallurl") + "?id=" + returnGoodsId);
        productMapper.updateMallURL(cmap);
    }

    private String getCurrentMouth()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(new Date());
    }

    private void copyFile(String fromurl, String tourl, String filename)
    {
        try
        {
            tourl = File.separator + tourl + File.separator + getCurrentMouth();
            File file = new File(tourl);
            if (file.exists())
            {
                file.mkdirs();
            }
            FileUtils.copyFile(new File(fromurl + File.separator + filename), new File(tourl + File.separator
                    + filename));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * [简要描述]:<br/> [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param pro
     * @return
     */
    private int update(ProductShop pro, int goodsid)
    {

        String fromurl = Init.getMap().get("frompath");
        String tourl = Init.getMap().get("topath");

        String currMouth = getCurrentMouth();

        Connection conn = getConnection();
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        PreparedStatement pstmt5 = null;

        String sql = "UPDATE ecs_goods set goods_name=?,goods_thumb=?,goods_img=?,goods_weight=?,market_price=?,shop_price=? where goods_id=" + goodsid;

        String sql2 = "INSERT INTO ecs_goods_gallery(goods_id,img_url,img_desc,thumb_url,img_original)"
                + " VALUES (?,?,?,?,?)";

        try
        {
            conn.setAutoCommit(false);

            // ========执行sql==========
            pstmt3 = conn.prepareStatement(sql);
            pstmt3.setString(1, pro.getGoodsname());
            String goodsthumb = pro.getGoodsthumb();
            pstmt3.setString(2, "images/" + currMouth + "/" + goodsthumb);
            pstmt3.setString(3, "images/" + currMouth + "/" + pro.getGoodsimg());
            pstmt3.setString(4, pro.getGoodsweight());
            pstmt3.setString(5, pro.getMarketprice());
            pstmt3.setString(6, pro.getShopprice());
            pstmt3.executeUpdate();

            copyFile(fromurl, tourl, goodsthumb);

            pstmt2 = conn.prepareStatement("delete  from ecs_goods_gallery where goods_id=" + goodsid);
            pstmt2.executeUpdate();

            // ========执行sql2==========
            String path = "";
            String scaledpath = "";
            pstmt5 = conn.prepareStatement(sql2);
            for (ProPic propic : pro.getImglist())
            {
                pstmt5.setInt(1, goodsid);
                path = propic.getPath();
                scaledpath = propic.getScaledpath();
                pstmt5.setString(2, "images/" + currMouth + "/" + path);
                pstmt5.setString(3, "");
                pstmt5.setString(4, "images/" + currMouth + "/" + scaledpath);
                pstmt5.setString(5, "images/" + currMouth + "/" + path);
                pstmt5.addBatch();

                copyFile(fromurl, tourl, path);
                copyFile(fromurl, tourl, scaledpath);
            }

            pstmt5.executeBatch();

            conn.commit();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            try
            {
                conn.rollback();
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
                throw new RuntimeException(e);
            }
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                if (null != pstmt2)
                    pstmt2.close();
                if (null != pstmt3)
                    pstmt3.close();
                if (null != pstmt5)
                    pstmt5.close();
                if (null != conn)
                    conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }

        return goodsid;
    }

    /**
     * [简要描述]:<br/> [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param pro
     * @return
     */
    private int save(ProductShop pro)
    {
        String currMouth = getCurrentMouth();

        Connection conn = getConnection();
        PreparedStatement pstmt3 = null;
        PreparedStatement pstmt4 = null;
        PreparedStatement pstmt5 = null;
        ResultSet rs = null;
        int goods_id = 0;

        String sql = "INSERT INTO ecs_goods(cat_id,goods_sn,goods_name,brand_id,provider_name,goods_number,goods_weight,market_price,shop_price,goods_brief,goods_desc,goods_thumb,goods_img,original_img,goods_type,add_time)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String sql2 = "INSERT INTO ecs_goods_gallery(goods_id,img_url,img_desc,thumb_url,img_original)"
                + " VALUES (?,?,?,?,?)";

        try
        {
            conn.setAutoCommit(false);
            
            // ========执行sql==========
            pstmt3 = conn.prepareStatement(sql);
            pstmt3.setInt(1, pro.getCatid());
            pstmt3.setString(2, pro.getGoodssn());
            pstmt3.setString(3, pro.getGoodsname());
            pstmt3.setString(4, pro.getBrandid());
            pstmt3.setString(5, pro.getProvidername());
            pstmt3.setString(6, pro.getGoodsnumber());
            pstmt3.setString(7, pro.getGoodsweight());
            pstmt3.setString(8, pro.getMarketprice());
            pstmt3.setString(9, pro.getShopprice());
            pstmt3.setString(10, pro.getGoodsbrief());
            pstmt3.setString(11, pro.getGoodsdesc());
            String goodsthumb = pro.getGoodsthumb();
            pstmt3.setString(12, "images/" + currMouth + "/" + goodsthumb);
            pstmt3.setString(13, "images/" + currMouth + "/" + pro.getGoodsimg());
            pstmt3.setString(14, pro.getOriginalimg());
            pstmt3.setString(15, pro.getGoodstype());
            pstmt3.setString(16, pro.getAddtime());
            pstmt3.executeUpdate();

            copyFile(fromurl, tourl, goodsthumb);

            // ========执行sql1==========
            pstmt4 = conn.prepareStatement("select goods_id from ecs_goods where goods_sn='" + pro.getGoodssn() + "'");

            rs = pstmt4.executeQuery();
            if (rs.next())
            {
                goods_id = rs.getInt("goods_id");
            }

            // ========执行sql2==========
            String path = "";
            String scaledpath = "";
            pstmt5 = conn.prepareStatement(sql2);
            for (ProPic propic : pro.getImglist())
            {
                pstmt5.setInt(1, goods_id);
                path = propic.getPath();
                scaledpath = propic.getScaledpath();
                pstmt5.setString(2, "images/" + currMouth + "/" + path);
                pstmt5.setString(3, "");
                pstmt5.setString(4, "images/" + currMouth + "/" + scaledpath);
                pstmt5.setString(5, "images/" + currMouth + "/" + path);
                pstmt5.addBatch();

                copyFile(fromurl, tourl, path);
                copyFile(fromurl, tourl, scaledpath);
            }

            pstmt5.executeBatch();

            conn.commit();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            try
            {
                conn.rollback();
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
                throw new RuntimeException(e);
            }
            throw new RuntimeException(e);
        }
        finally
        {
            try
            {
                if (null != rs)
                    rs.close();
                if (null != pstmt3)
                    pstmt3.close();
                if (null != pstmt4)
                    pstmt4.close();
                if (null != pstmt5)
                    pstmt5.close();
                if (null != conn)
                    conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }
        return goods_id;
    }

    /**
     * 检查是否有数据
     * 
     * @param pro
     * @return
     */
    private int exist(ProductShop pro)
    {
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int id = -1;
        try
        {
            pstmt = conn.prepareStatement("select goods_id from ecs_goods where goods_sn='" + pro.getGoodssn() + "'");
            rs = pstmt.executeQuery();
            if (rs.next())
            {
                id = rs.getInt("goods_id");
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rs.close();
                pstmt.close();
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }

        }
        return id;
    }

    /**
     * [简要描述]:<br/> [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    private Connection getConnection()
    {

        Connection connection = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(databaseurl,databaseusername,databasepassword);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return connection;

    }

    /**
     * [简要描述]:<br/> [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param pro
     * @return
     */
    private ProductShop adaptor(Product pro)
    {
        ProductShop pshop = new ProductShop();
        pshop.setBrandid("0");
        pshop.setCatid(2);
        pshop.setGoodsbrief("");
        pshop.setGoodsdesc("");
        pshop.setGoodsimg(pro.getTypeimg());
        pshop.setGoodsname(pro.getName());
        pshop.setGoodsnumber("1");
        pshop.setGoodssn("MMPROPLAT" + pro.getId());
        pshop.setGoodsthumb(pro.getTypeimg());
        pshop.setGoodstype("5");
        pshop.setGoodsweight(String.valueOf(pro.getWeight()));
        pshop.setMarketprice(String.valueOf(pro.getMarkingprice()));
        pshop.setOriginalimg("");
        pshop.setProvidername("");
        pshop.setShopprice(String.valueOf(pro.getOurprice()));
        pshop.setImglist(pro.getImglist());
        pshop.setAddtime(String.valueOf(new Date().getTime() / 1000));

        return pshop;
    }

    @Override
    public void synctoshop(Map cmap)
    {
        productMapper.synctoshop(cmap);
        
    }

}
