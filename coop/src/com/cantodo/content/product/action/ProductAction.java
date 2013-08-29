package com.cantodo.content.product.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;
import com.cantodo.content.dto.FileUpload;
import com.cantodo.content.dto.Member;
import com.cantodo.content.dto.ProPic;
import com.cantodo.content.dto.Product;
import com.cantodo.content.product.service.ProductService;

/**
 * @author tdy
 */
@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction
{

    /**
     * 
     */
    private static final long serialVersionUID = -6928972050105492749L;

    private Log logger = LogFactory.getLog(ProductAction.class);

    @Autowired
    private DictBussService dictBussImplService;

    @Autowired
    private ProductService productServiceImpl;

    private Product product;

    private List<DictBuss> prodcutsort;

    private List<DictBuss> hotword;

    public List<DictBuss> getProdcutsort()
    {
        return prodcutsort;
    }

    public void setProdcutsort(List<DictBuss> prodcutsort)
    {
        this.prodcutsort = prodcutsort;
    }

    public List<DictBuss> getHotword()
    {
        return hotword;
    }

    public void setHotword(List<DictBuss> hotword)
    {
        this.hotword = hotword;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public String toLoadList()
    {
        prodcutsort = dictBussImplService.listDictBuss(15);
        return SUCCESS;
    }
    
    
    public String selectproductlist()
    {
        prodcutsort = dictBussImplService.listDictBuss(15);
        String coopid = request.getParameter("coopid");
        request.setAttribute("memid", coopid);
        
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String getProductList()
    {
        response.setHeader("Cache-Control", "no-cache");

        String strpage = request.getParameter("page");

        String strrows = request.getParameter("rows");

        int rows = Integer.parseInt(strrows);

        int offset = (Integer.parseInt(strpage) - 1) * rows;

        String name = request.getParameter("name");
        String sort = request.getParameter("sort");
        String memid = request.getParameter("memid");
        
        String linestate = request.getParameter("linestate");
        String state = request.getParameter("state");
        String sync = request.getParameter("sync");

        name = StringUtils.isBlank(name) ? null : "%" + name + "%";
        sort = ("-1").equals(sort) ? null : sort;
        memid = StringUtils.isBlank(memid) ? null : memid;
        
        linestate = ("-1").equals(linestate) ? null : linestate;
        state = ("-1").equals(state) ? null : state;
        sync = ("-1").equals(sync) ? null : sync;

        Map conditionMap = new HashMap();
        conditionMap.put("name", name);
        conditionMap.put("sort", sort);
        conditionMap.put("memid", memid);
        conditionMap.put("linestate", linestate);
        conditionMap.put("state", state);
        conditionMap.put("sync", sync);
        conditionMap.put("offset", offset);
        conditionMap.put("rows", rows);

        String jsonData = productServiceImpl.getProductList(conditionMap);

        return toJsonData(jsonData);
    }

    /**
     * [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String loadProduct()
    {

        prodcutsort = dictBussImplService.listDictBuss(15);

        hotword = dictBussImplService.listDictBuss(17);

        String strmemid = request.getParameter("memid");

        String productid = request.getParameter("id");

        String opt = request.getParameter("opt");

        request.setAttribute("strmemid", strmemid);

        // int memid = NumberUtils.toInt(strmemid, 0);

        if (StringUtils.isEmpty(productid))
        {
            product = new Product();

            Member member = (Member) request.getSession().getAttribute("member");

            product.setProarea(member.getArea());
        }
        else
        {

            int inid = NumberUtils.toInt(productid, 0);

            product = productServiceImpl.getInfoById(inid);

            List<ProPic> pplist = productServiceImpl.getProPicByCode(product.getCode());

            request.setAttribute("pplist", pplist);

            if ("view".equals(opt))
            {
                return "viewproduct";
            }
        }

        return SUCCESS;
    }

    /**
     * [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String saveOrUpdateProduct()
    {
        // ÎÄ¼þ±£´æÂ·¾¶
        String path = ServletActionContext.getServletContext().getRealPath("/attach/productpic");

        String[] fileNames = null;

        File[] uploadFiles = null;

        MultiPartRequestWrapper multiWrapper = (MultiPartRequestWrapper) request;

        Enumeration<String> enu = multiWrapper.getFileParameterNames();

        FileUpload fileUpload = null;

        List<FileUpload> list = new ArrayList<FileUpload>();

        while (enu.hasMoreElements())
        {
            fileUpload = new FileUpload();
            // ¶ÔÃ¿Ò»¸öÎÄ¼þÓò½øÐÐ±éÀú
            String controlName = (String) enu.nextElement();

            fileNames = multiWrapper.getFileNames(controlName);

            uploadFiles = multiWrapper.getFiles(controlName);

            fileUpload.setControlName(controlName);

            fileUpload.setFileNames(fileNames);

            fileUpload.setUploadFiles(uploadFiles);

            list.add(fileUpload);
        }

        String opt = request.getParameter("opt");

        if (opt.equals("add"))
        {
            productServiceImpl.add(product, path, list);

        }
        if (opt.equals("edit"))
        {
            productServiceImpl.update(product, path, list);
        }

        return result(true);
    }

    /**
     * [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String deleteProduct()
    {

        String idarr = request.getParameter("ids");

        productServiceImpl.delete(idarr);

        return success();

    }

    /**
     * [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String stateOpt()
    {

        String idarr = request.getParameter("ids");

        String statestr = request.getParameter("state");

        int state = NumberUtils.toInt(statestr, 0);

        productServiceImpl.stateOpt(idarr, state);

        return success();

    }

    /**
     * [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String synctoshop()
    {

        String sid = request.getParameter("id");

        int id = NumberUtils.toInt(sid, 0);
        
        Product p = productServiceImpl.getInfoById(id);
        
        boolean flag = true;

        int state = 0;
        try
        {
            productServiceImpl.syncDataToShop(p);
            state = 1;
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            flag = false;
            state = 2;
        }
        
        Map cmap = new HashMap();
        cmap.put("id", id);
        cmap.put("state",state);
        productServiceImpl.synctoshop(cmap);

        return result(flag);
    }

}
