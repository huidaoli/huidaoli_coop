package com.cantodo.content.front.action;

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

@Controller("productManaAction")
@Scope("prototype")
public class ProductManaAction extends BaseAction
{

    /**
     * [简要描述]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = -3299136469210513840L;
    
    
    private Log logger = LogFactory.getLog(ProductManaAction.class);

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
    
    /**
     * 
     * @return
     */
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
		
		name = StringUtils.isBlank(name) ? null : "%"+name+"%";
		sort = ("-1").equals(sort) ? null : sort;
		memid = StringUtils.isBlank(memid) ? null : memid;

		Map conditionMap = new HashMap();
		conditionMap.put("name", name);
		conditionMap.put("sort", sort);
		conditionMap.put("memid", memid);
		conditionMap.put("offset", offset);
		conditionMap.put("rows", rows);

		String jsonData = productServiceImpl.getProductList(conditionMap);

		return toJsonData(jsonData);
    }


    public String loadProduct()
    {

        prodcutsort = dictBussImplService.listDictBuss(15);

        hotword = dictBussImplService.listDictBuss(17);

        String strmemid = request.getParameter("memid");
        
        String productid = request.getParameter("id");
        
        String opt = request.getParameter("opt");

        request.setAttribute("strmemid", strmemid);
        

        //int memid = NumberUtils.toInt(strmemid, 0);
        
        if(StringUtils.isEmpty(productid))
        {
        	product = new Product();
            
            Member member = (Member)request.getSession().getAttribute("member");
            
            product.setProarea(member.getArea());
        }
        else
        {
            
        	int inid = NumberUtils.toInt(productid, 0);
        	
        	product = productServiceImpl.getInfoById(inid);
        	
        	List<ProPic> pplist = productServiceImpl.getProPicByCode(product.getCode());
        	
        	request.setAttribute("pplist", pplist);
        	
        	 if("view".equals(opt))
             {
                 return "viewproduct";
             }
        }
        
        

        return SUCCESS;
    }

    public String saveOrUpdateProduct()
    {
        // 文件保存路径
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
            // 对每一个文件域进行遍历
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
    
    
    public String deleteProduct()
    {

        String idarr = request.getParameter("ids");

        productServiceImpl.delete(idarr);
        

        return success();
        
    }
    public String lineOpt()
    {

        String idarr = request.getParameter("ids");
        
        String statestr = request.getParameter("state");
        
        int state = NumberUtils.toInt(statestr, 0);

        productServiceImpl.lineOpt(idarr,state);
        
        return success();
        
    }
    
    public String toProductDetail()
    {
        logger.debug("enter product");
        
        response.setHeader("Cache-Control", "no-cache");

        String productId = request.getParameter("id");
        
        Product p = productServiceImpl.getInfoById(NumberUtils.toInt(productId, 0));
        
        List<ProPic> list = productServiceImpl.getProPicByCode(p.getCode());
        
        if(null != list && list.size()>0)
        {
        	request.setAttribute("currproduct", list.get(0));
        }

        request.setAttribute("p", p);
        
        request.setAttribute("list", list);

        logger.debug("exit toPartProjectNews");

        return SUCCESS;
    }
    
    
}
