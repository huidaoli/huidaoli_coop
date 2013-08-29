package com.base.frame.model;

import java.util.Set;

/**
 * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Oct 27, 2011
 */
public class FlowForm
{

    private int id;

    private Workflow workflow;

    private String template;

    private Set<FormField> fields;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Workflow getWorkflow()
    {
        return workflow;
    }

    public void setWorkflow(Workflow workflow)
    {
        this.workflow = workflow;
    }

    public String getTemplate()
    {
        return template;
    }

    public void setTemplate(String template)
    {
        this.template = template;
    }

    public Set<FormField> getFields()
    {
        return fields;
    }

    public void setFields(Set<FormField> fields)
    {
        this.fields = fields;
    }
}
