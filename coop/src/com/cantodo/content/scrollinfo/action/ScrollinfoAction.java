package com.cantodo.content.scrollinfo.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.cantodo.content.dto.FileUpload;
import com.cantodo.content.dto.Scrollinfo;
import com.cantodo.content.scrollinfo.service.ScrollinfoService;
import com.cantodo.content.upload.service.UploadService;

/**
 * @author tdy
 */
@Controller("scrollinfoAction")
@Scope("prototype")
public class ScrollinfoAction extends BaseAction
{


    /**
     * [简要描述]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = -7001674431027239274L;

    /**
     * [简要描述]:
     * @author tangdingyi
     */

    private Log logger = LogFactory.getLog(ScrollinfoAction.class);

    @Autowired
    private ScrollinfoService scrollinfoServiceImpl;

    private Scrollinfo scrollinfo;

    
    @Autowired
    private UploadService uploadServiceImpl;


  
   



    public Scrollinfo getScrollinfo()
    {
        return scrollinfo;
    }

    public void setScrollinfo(Scrollinfo scrollinfo)
    {
        this.scrollinfo = scrollinfo;
    }

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

		String name = request.getParameter("name");
        name = StringUtils.isBlank(name) ? null : "%"+name+"%";
		String cctype = request.getParameter("cctype");

		Map conditionMap = new HashMap();
		conditionMap.put("cname", name);
		conditionMap.put("cctype", cctype);
		conditionMap.put("offset", offset);
		conditionMap.put("rows", rows);

		String jsonData = scrollinfoServiceImpl.getList(conditionMap,cctype);
		
  		
        logger.debug("exit getAjaxData");

		return toJsonData(jsonData);
    }

    public String loadEdit()
    {
    	logger.debug("enter loadEdit");

        response.setHeader("Cache-Control", "no-cache");
        String cctype = request.getParameter("cctype");
        request.setAttribute("opt", "add");
        String contcode = UUID.randomUUID().toString();
        scrollinfo = new Scrollinfo();
        scrollinfo.setContcode(contcode);
        scrollinfo.setCreateDate(new Date());
        scrollinfo.setCtype(cctype);
        
  		
        logger.debug("exit loadEdit");
        return SUCCESS;
    }

    public String saveOrUpdate()
    {
    	logger.debug("enter saveOrUpdate");

        String opt = request.getParameter("opt");

        if (opt.equals("add"))
        {
            
            scrollinfoServiceImpl.add(scrollinfo);
        }
        if (opt.equals("edit"))
        {
            scrollinfoServiceImpl.update(scrollinfo);
        }
        
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

            fileUpload.setContcode(scrollinfo.getContcode());

            list.add(fileUpload);
        }
        uploadServiceImpl.addPicture(path, list);
        
  		
        logger.debug("exit saveOrUpdate");

        return success();
    }

    @SuppressWarnings("unchecked")
    public String getInfoById()
    {
    	logger.debug("enter getInfoById");

        String id = request.getParameter("id");
        String cctype = request.getParameter("cctype");
        String opt = request.getParameter("opt");

        try
        {
            Map conditionMap = new HashMap();
            conditionMap.put("id", id);
            conditionMap.put("cctype", cctype);
            scrollinfo = scrollinfoServiceImpl.getInfoById(conditionMap);
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
    	logger.debug("enter delete");

        String idarr = request.getParameter("ids");

        scrollinfoServiceImpl.delete(idarr);
        
  		
        logger.debug("exit delete");

        return success();
    }




}
