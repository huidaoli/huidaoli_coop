package com.base.frame.workflow.jbpm.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.FieldInput;
import com.base.frame.model.FieldType;
import com.base.frame.model.FlowForm;
import com.base.frame.model.FormField;
import com.base.frame.model.Workflow;
import com.base.frame.workflow.jbpm.service.FlowformService;
import com.base.frame.workflow.jbpm.service.WorkflowService;

@Controller("flowform")
@Scope("prototype")
public class FlowformAction extends BaseAction
{

    /**
     * [ºÚ“™√Ë ˆ]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = 2658725443947677296L;

    /**
     * 
     */

    private Log logger = LogFactory.getLog(FlowformAction.class);

    private Workflow workflow;

    private FlowForm flowForm;
    
    private FormField formField;

    private List<FieldType> listFieldType;

    private List<FieldInput> listFieldInput;

    @Autowired
    private WorkflowService workflowService;

    @Autowired
    private FlowformService flowformService;


    public FormField getFormField()
    {
        return formField;
    }

    public void setFormField(FormField formField)
    {
        this.formField = formField;
    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String toFlowform()
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
    public String addFormField()
    {
        //formField
        int formId = Integer.parseInt(request.getParameter("formId"));
        
        String jsonData = request.getParameter("jsondata");
        
        
        flowformService.addField(formField, formId, jsonData); 
        
        
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
    public String addFormInput()
    {
        String id = request.getParameter("id");

       // String opt = request.getParameter("opt");

        int workflowId = Integer.parseInt(id);

        workflow = workflowService.findWorkflow(workflowId);

        flowForm = flowformService.findForm(workflowId);

        request.setAttribute("opt", "edit");
        
        request.setAttribute("id",id);

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
    public String formFieldInput()
    {

        String formId = request.getParameter("formId");
        
        request.setAttribute("formId", formId);
        
        listFieldType = flowformService.searchFieldTypes();
        
        listFieldInput = flowformService.searchFieldInputs();
        
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
    public String deleteFlowform()
    {

        String fieldId = request.getParameter("did");
        
        flowformService.delField(Integer.parseInt(fieldId));
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
    public String savaKeyValue()
    {

        String  jsonData = request.getParameter("jsonData");
        
        //System.out.println(jsonData);
       
     
        //flowformService.updateFieldItems(fieldId, pkey, pvalue);
        
        
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
    public String keyValue()
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
    public String getFlowformAjaxData()
    {
        response.setHeader("Cache-Control", "no-cache");
        
        String id = request.getParameter("id");

        String strpage = request.getParameter("page");

        String strrows = request.getParameter("rows");

        int rows = Integer.parseInt(strrows);

        int offset = (Integer.parseInt(strpage) - 1) * rows;
        
        int workflowId = Integer.parseInt(id);
        
        String name = request.getParameter("name");
        
        String jsonData = flowformService.searchRoles(name,offset, rows ,workflowId);

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
    
   
    
    public Workflow getWorkflow()
    {
        return workflow;
    }

    public void setWorkflow(Workflow workflow)
    {
        this.workflow = workflow;
    }

    public FlowForm getFlowForm()
    {
        return flowForm;
    }

    public void setFlowForm(FlowForm flowForm)
    {
        this.flowForm = flowForm;
    }

    public List<FieldType> getListFieldType()
    {
        return listFieldType;
    }

    public void setListFieldType(List<FieldType> listFieldType)
    {
        this.listFieldType = listFieldType;
    }

    public List<FieldInput> getListFieldInput()
    {
        return listFieldInput;
    }

    public void setListFieldInput(List<FieldInput> listFieldInput)
    {
        this.listFieldInput = listFieldInput;
    }

}
