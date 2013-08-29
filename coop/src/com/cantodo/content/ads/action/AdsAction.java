package com.cantodo.content.ads.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.cantodo.content.ads.service.AdsService;
import com.cantodo.content.dto.Ads;
import com.cantodo.content.dto.FileUpload;
import com.cantodo.content.dto.Resource;

/**
 * @author tdy
 */
@Controller("adsAction")
@Scope("prototype")
public class AdsAction extends BaseAction
{


    /**
     * [简要描述]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = -6554581830311410572L;

    private Log logger = LogFactory.getLog(AdsAction.class);

    @Autowired
    private AdsService adsServiceImpl;


    private Ads ads;
    

    public String toLoadList()
    {
    	logger.debug("enter toLoadList");

        String type = request.getParameter("type");
        
        request.setAttribute("cctype", type);
        
  		
        logger.debug("exit toLoadList");
    	
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String getAjaxData()
    {
    	logger.debug("enter getAjaxData");

    	response.setHeader("Cache-Control", "no-cache");

		String strpage = request.getParameter("page");

		String strrows = request.getParameter("rows");

		int rows = Integer.parseInt(strrows);

		int offset = (Integer.parseInt(strpage) - 1) * rows;
		
		String cctype = request.getParameter("cctype");
		
		String name = request.getParameter("name");
		name = StringUtils.isBlank(name) ? null : "%"+name+"%";

		Map conditionMap = new HashMap();
		
		conditionMap.put("name", name);
		conditionMap.put("cctype", NumberUtils.toInt(cctype, 0));
		conditionMap.put("offset", offset);
		conditionMap.put("rows", rows);
		
		String jsonData = adsServiceImpl.getList(conditionMap);
  		
        logger.debug("exit getAjaxData");

		return toJsonData(jsonData);
    }

    public String loadEdit()
    {
    	
    	logger.debug("enter loadEdit");

        response.setHeader("Cache-Control", "no-cache");
        String cctype = request.getParameter("cctype");
        request.setAttribute("opt", "add");
        
        ads = new Ads();
        ads.setCreateDate(new Date());
        ads.setType(NumberUtils.toInt(cctype, 0));
  		
        logger.debug("exit loadEdit");
        return SUCCESS;
    }

    public String saveOrUpdate()
    {
    	logger.debug("enter saveOrUpdate");
    	
    	// 文件保存路径
        String path = ServletActionContext.getServletContext().getRealPath("/attach/file");

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
        	adsServiceImpl.add(ads,path,list);

        }
        if (opt.equals("edit"))
        {
        	adsServiceImpl.update(ads,path,list);
        }
        
        
        
  		
        logger.debug("exit saveOrUpdate");

        return success();
    }

    @SuppressWarnings("unchecked")
    public String getInfoById()
    {
    	logger.debug("enter getInfoById");

        String id = request.getParameter("id");
        String opt = request.getParameter("opt");
        

        try
        {
            ads = adsServiceImpl.getInfoById(NumberUtils.toInt(id,0));
        }
        catch (Exception e)
        {
            logger.debug("getInfoById()", e);

        }

        request.setAttribute("opt", "edit");

        if (opt.equals("edit"))
        {
      		
            logger.debug("exit getInfoById");
            return SUCCESS;
        }
        else
        {
      		
            logger.debug("exit getInfoById");
            return "view";
        }

    }
    
    

    public String delete()
    {

        String idarr = request.getParameter("ids");

        adsServiceImpl.delete(idarr);

        return success();
    }

	public Ads getAds() {
		return ads;
	}

	public void setAds(Ads ads) {
		this.ads = ads;
	}



}
