package com.base.frame.workflow.jbpm.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.Workflow;
import com.base.frame.workflow.jbpm.service.WorkflowService;
import com.cantodo.content.dto.FileUpload;

@Controller("workflowAction")
@Scope("prototype")
public class WorkflowAction extends BaseAction
{

    /**
     * 
     */
    private static final long serialVersionUID = -5949947052057011655L;
    
    private Log logger = LogFactory.getLog(WorkflowAction.class);

    private Workflow workflow;

    @Autowired
    private WorkflowService workflowService;

    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     * @throws Exception
     */
    public String save() throws Exception
    {
      
       
        // Œƒº˛±£¥Ê¬∑æ∂
        String path = ServletActionContext.getServletContext().getRealPath("/attach/jbpmfile");

        String[] fileNames = null;
        
        File[] uploadFiles = null;
        
        MultiPartRequestWrapper multiWrapper = (MultiPartRequestWrapper) request;
        
        Enumeration<String> enu = multiWrapper.getFileParameterNames();
        
        FileUpload fileUpload = null;
        
        List<FileUpload> list = new ArrayList<FileUpload>();
        
        while (enu.hasMoreElements())
        {
            fileUpload = new FileUpload();
            // ∂‘√ø“ª∏ˆŒƒº˛”ÚΩ¯––±È¿˙
            String controlName = (String) enu.nextElement();
            
            fileNames = multiWrapper.getFileNames(controlName);
            
            uploadFiles = multiWrapper.getFiles(controlName);
            
            fileUpload.setControlName(controlName);

            fileUpload.setFileNames(fileNames);
            
            fileUpload.setUploadFiles(uploadFiles);

            list.add(fileUpload);
        }
        workflowService.add(path, list, workflow);
        
        try
        {
            response.getWriter().println("{\"success\":true}");
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);

        }
        return null;
    }

    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String searchAllWorkflows()
    {

        return SUCCESS;
    }

    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String toAdd()
    {

        return SUCCESS;
    }

    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String toWorkflow()
    {

        return SUCCESS;
    }
    
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String getWorkflowAjaxData()
    {
        response.setHeader("Cache-Control", "no-cache");

        String strpage = request.getParameter("page");

        String strrows = request.getParameter("rows");

        int rows = Integer.parseInt(strrows);

        int offset = (Integer.parseInt(strpage) - 1) * rows;
        
        
        String name = request.getParameter("name");
        
        String jsonData = workflowService.searchRoles(name,offset, rows);

        try
        {
            response.getWriter().println(jsonData);
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);

        }

        return null;
    }
    
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String deleteWorkflow()
    {

        String idarr = request.getParameter("ids");
        
        workflowService.delWorkflow(idarr);       
        try
        {
            response.getWriter().println("{\"success\":true}");
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);

        }
        
        return null;
    }
    
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    @SuppressWarnings("unchecked")
    public String loadWorkflowById()
    {

        String id = request.getParameter("id");

        String opt = request.getParameter("opt");

        this.workflow = workflowService.findWorkflow(Integer.parseInt(id));
        
        request.setAttribute("opt", "edit");

        if (opt.equals("edit"))
        {
           
            return SUCCESS;
        }
        else
        {
           
            
            return "view";
        }

    }
    

    
    public Workflow getWorkflow()
    {
        return workflow;
    }

    public void setWorkflow(Workflow workflow)
    {
        this.workflow = workflow;
    }

}
