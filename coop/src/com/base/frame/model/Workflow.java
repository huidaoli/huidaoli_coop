package com.base.frame.model;

/**
 * 流程定义 [简要描述]:<br/> [详细描述]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Oct 26, 2011
 */
public class Workflow
{
    private int id;

    private String name;
    
    private String realName;

    private String processDefPath;

    private String processImagePath;

    private String processDefCord;
    
    private FlowForm flowForm;

    public FlowForm getFlowForm()
    {
        return flowForm;
    }

    public void setFlowForm(FlowForm flowForm)
    {
        this.flowForm = flowForm;
    }

    public String getProcessDefCord()
    {
        return processDefCord;
    }

    public void setProcessDefCord(String processDefCord)
    {
        this.processDefCord = processDefCord;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getProcessDefPath()
    {
        return processDefPath;
    }

    public void setProcessDefPath(String processDefPath)
    {
        this.processDefPath = processDefPath;
    }

    public String getProcessImagePath()
    {
        return processImagePath;
    }

    public void setProcessImagePath(String processImagePath)
    {
        this.processImagePath = processImagePath;
    }

    public String getRealName()
    {
        return realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

}
