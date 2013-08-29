package com.cantodo.content.trainingsys.action;

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
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;
import com.cantodo.content.dto.Divproper;
import com.cantodo.content.dto.FileUpload;
import com.cantodo.content.dto.TrainingSys;
import com.cantodo.content.trainingsys.service.Tool;
import com.cantodo.content.trainingsys.service.TrainingSysService;
import com.cantodo.content.upload.service.UploadService;

/**
 * @author tdy
 */
@Controller("trainingsysAction")
@Scope("prototype")
public class TrainingSysAction extends BaseAction
{

    /**
     * 
     */
    private static final long serialVersionUID = -6928972050105492749L;

    private Log logger = LogFactory.getLog(TrainingSysAction.class);

    @Autowired
    private TrainingSysService trainingSysServiceImpl;

    @Autowired
    private DictBussService dictBussImplService;

    private TrainingSys trainingSys;

    private Divproper divproper;

    private List<DictBuss> listDictBuss;

    @Autowired
    private UploadService uploadServiceImpl;

    public String toLoadList()
    {
    	logger.debug("enter toLoadList");

        listDictBuss = dictBussImplService.listDictBuss(10);
        
  		
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
        String type = request.getParameter("type");
        name = StringUtils.isBlank(name) ? null : "%" + name + "%";
        type = ("-1").equals(type) ? null : type;

        Map conditionMap = new HashMap();
        conditionMap.put("cname", name);
        conditionMap.put("ctype", type);
        conditionMap.put("offset", offset);
        conditionMap.put("rows", rows);

        String jsonData = trainingSysServiceImpl.getList(conditionMap);
        
  		
        logger.debug("exit getAjaxData");

        return toJsonData(jsonData);
    }

    public String loadEdit()
    {
    	logger.debug("enter loadEdit");

        response.setHeader("Cache-Control", "no-cache");
        request.setAttribute("opt", "add");
        String contcode = UUID.randomUUID().toString();
        trainingSys = new TrainingSys();
        trainingSys.setContcode(contcode);
        trainingSys.setCreateDate(new Date());
        listDictBuss = dictBussImplService.listDictBuss(10);
        
  		
        logger.debug("exit loadEdit");
        return SUCCESS;
    }

    public String saveOrUpdate()
    {
    	logger.debug("enter saveOrUpdate");

        String opt = request.getParameter("opt");

        if (opt.equals("add"))
        {
            trainingSysServiceImpl.add(trainingSys);

        }
        if (opt.equals("edit"))
        {
            trainingSysServiceImpl.update(trainingSys);
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
        listDictBuss = dictBussImplService.listDictBuss(10);

        try
        {
            trainingSys = trainingSysServiceImpl.getInfoById(Integer.parseInt(id));
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

    @SuppressWarnings("unchecked")
    public String getImgsById()
    {
    	logger.debug("enter getImgsById");

        String id = request.getParameter("id");
        List<Map> list = null;

        try
        {
            list = trainingSysServiceImpl.getImgsById(Integer.parseInt(id));

            // trainingSysServiceImpl.getAttaByImgId(imgid);

            if (!(null == list || list.size() == 0))
            {
                Map smap = list.get(0);

                String imgid = (String) smap.get("attaid");

                String imgName = (String) smap.get("newname");

                int width = (Integer) smap.get("width");

                int height = (Integer) smap.get("height");
                
                List divlist = trainingSysServiceImpl.getDivInfo(imgid);

                String div = Tool.createTable(imgName, new int[] {width, height},divlist,2);

                request.setAttribute("divs", div);
            }

        }
        catch (Exception e)
        {
            logger.debug("getInfoById()", e);

        }
        request.setAttribute("list", list);
        
  		
        logger.debug("exit getImgsById");

        return SUCCESS;

    }
    
    
    
   

    // ---------------------------------------------------------------------------------------------

    public String delete()
    {

        String idarr = request.getParameter("ids");

        trainingSysServiceImpl.delete(idarr);

        return success();
    }

    public String saveImgPro()
    {

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

            fileUpload.setContcode(divproper.getImgid());

            list.add(fileUpload);
        }

        String filename = uploadServiceImpl.add2(path, list);
        
        divproper.setAttaname(filename);
        
        trainingSysServiceImpl.insert(divproper);

        // List<Atta> lists = uploadServiceImpl.getAttaById(contcode);

        // request.setAttribute("resutl", lists);

        return result(true);
    }
    
    public String resImg()
    {
        String id = request.getParameter("id");
        
        trainingSysServiceImpl.deleteImg(id);
        
        return result(true);
    }

    public List<DictBuss> getListDictBuss()
    {
        return listDictBuss;
    }

    public void setListDictBuss(List<DictBuss> listDictBuss)
    {
        this.listDictBuss = listDictBuss;
    }

    public TrainingSys getTrainingSys()
    {
        return trainingSys;
    }

    public void setTrainingSys(TrainingSys trainingSys)
    {
        this.trainingSys = trainingSys;
    }

    public Divproper getDivproper()
    {
        return divproper;
    }

    public void setDivproper(Divproper divproper)
    {
        this.divproper = divproper;
    }

}
