package com.cantodo.content.upload.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import org.apache.commons.io.IOUtils;
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
import com.cantodo.content.upload.service.UploadService;

@Controller("uploadAction")
@Scope("prototype")
public class UploadAction extends BaseAction
{

    private static final long serialVersionUID = -4470920013849298828L;

    private Log logger = LogFactory.getLog(UploadAction.class);

    @Autowired
    private UploadService uploadServiceImpl;

    public String toUpload()
    {
    	logger.debug("enter toUpload");

        response.setHeader("Cache-Control", "no-cache");
  		
        logger.debug("exit toUpload");

        return SUCCESS;
    }

    /**
     * [简要描述]:<br/> [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @return
     * @throws Exception
     */
    public String savefile()
    {
    	logger.debug("enter savefile");

        String contcode = request.getParameter("contcode");
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

            fileUpload.setContcode(contcode);

            list.add(fileUpload);
        }

        uploadServiceImpl.add(path, list);
        
  		
        logger.debug("exit savefile");

        return success();
    }

    @SuppressWarnings("unchecked")
    public String getAttaById()
    {
    	logger.debug("enter getAttaById");

        response.setHeader("Cache-Control", "no-cache");
        
        String coop = request.getParameter("coop");
        
        request.setAttribute("coop", coop);
        
        String contcode = request.getParameter("contcode");
        contcode = StringUtils.isBlank(contcode)?null:contcode;
        String view = request.getParameter("view");
        List resutl = uploadServiceImpl.getAttaById(contcode);
        
        request.setAttribute("resutl", resutl);
        if (StringUtils.isNotBlank(view) && "view".equals(view))
        {
      		
            logger.debug("exit getAttaById");
            return "view";
        }
        // String []t =StringUtils.split(ids, ",");
  		
        logger.debug("exit getAttaById");

        return SUCCESS;
    }

    public String downLoadAtta()
    {
    	logger.debug("enter downLoadAtta");

        String fileName = request.getParameter("atta");
        String fileURL = ServletActionContext.getServletContext().getRealPath("/");
        fileURL = fileURL + "attach" + File.separator + "file" + File.separator + fileName;

        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try
        {
            in = new BufferedInputStream(new FileInputStream(fileURL));
            out = new BufferedOutputStream(response.getOutputStream());
            byte buffered[] = new byte[1024 * 1024];
            while (true)
            {
                int realLong = in.read(buffered);
                if (realLong == -1)
                {
                    break;
                }
                out.write(buffered, 0, realLong);
            }
            out.flush();
        }
        catch (Exception e)
        {
            //logger.debug("downLoadAtta()", e);
        }
        finally
        {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
        
  		
        logger.debug("exit downLoadAtta");
        return null;
    }

    public String deleAtta()
    {
    	logger.debug("enter deleAtta");

        response.setHeader("Cache-Control", "no-cache");
        String id = request.getParameter("id");
        uploadServiceImpl.deleAtta(id);
        
  		
        logger.debug("exit deleAtta");
        return success();
    }

}
