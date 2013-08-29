package com.cantodo.content.front.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.cantodo.content.dto.Atta;
import com.cantodo.content.dto.FileUpload;
import com.cantodo.content.upload.service.UploadService;

/**
 * @author tdy
 */
@Controller("resumeAction")
@Scope("prototype")
public class ResumeAction extends BaseAction
{

    /**
     * [简要描述]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = 7423970587172614461L;
    
    private Log logger = LogFactory.getLog(ResumeAction.class);

    @Autowired
    private UploadService uploadServiceImpl;

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
    public String toUploadResume()
    {
    	logger.debug("enter toUploadResume");
;
    	
        String contcode = request.getParameter("code");
        List<Atta> lists = uploadServiceImpl.getAttaById(contcode);
        request.setAttribute("code", contcode);
        
        if(null == lists || lists.isEmpty())
        {
      		
            logger.debug("exit toUploadResume");
        	
            return SUCCESS;
        }
        else
        {
        	
        	
            request.setAttribute("resutl", lists);
      		
            logger.debug("exit toUploadResume");
            
            return "hasresume";
            
        }

       
        

        
    }

    @SuppressWarnings("unchecked")
    public String uploadResume()
    {

        String contcode = request.getParameter("code");
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

        List<Atta> lists = uploadServiceImpl.getAttaById(contcode);

        request.setAttribute("resutl", lists);

        return SUCCESS;
    }
    
    public String downResume() {

        String fileName = request.getParameter("atta");
        String fileURL = ServletActionContext.getServletContext().getRealPath(
                "/");
        fileURL = fileURL + "attach"+File.separator+"file"+File.separator+ fileName;

        response.setHeader("Content-disposition", "attachment;filename="
                + fileName);

        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(fileURL));
            out = new BufferedOutputStream(response.getOutputStream());
            byte buffered[] = new byte[1024 * 1024];
            while (true) {
                int realLong = in.read(buffered);
                if (realLong == -1) {
                    break;
                }
                out.write(buffered, 0, realLong);
            }
            out.flush();
        } catch (Exception e) {
            //logger.debug("downLoadAtta()", e);
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
        return null;
    }
    
    
    public String downResumeTemplate()
    {
        String fileName = "resume.docx";
        String fileURL = ServletActionContext.getServletContext().getRealPath("/");
        fileURL = fileURL + "attach" + File.separator + "template" + File.separator + fileName;

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
            logger.debug("downLoadAtta()", e);
        }
        finally
        {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
        return null;
    }
    
    public String deleResume()
    {
        String id = request.getParameter("attid");
        
        uploadServiceImpl.deleAtta(id);
        
        return SUCCESS;
    }

}
