package com.base.frame.model;

import java.util.List;


/**
 * [简要描述]:<br/> [详细描述]:<br/>
 * 表单域
 * @author tangdingyi
 * @version 1.0, Oct 27, 2011
 */
public class FormField
{

    private int id;

    private String fieldLabel;

    private String fieldName;

    private FieldInput fieldInput;

    private FieldType fieldType;

    private List<FieldItem> items;

    /**
     * 对应的表单
     * 
     * @hibernate.many-to-one column="flowFormId"
     */
    private FlowForm flowForm;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFieldLabel()
    {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel)
    {
        this.fieldLabel = fieldLabel;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public FieldInput getFieldInput()
    {
        return fieldInput;
    }

    public void setFieldInput(FieldInput fieldInput)
    {
        this.fieldInput = fieldInput;
    }

    public FieldType getFieldType()
    {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType)
    {
        this.fieldType = fieldType;
    }

    public List<FieldItem> getItems()
    {
        return items;
    }

    public void setItems(List<FieldItem> items)
    {
        this.items = items;
    }

    public FlowForm getFlowForm()
    {
        return flowForm;
    }

    public void setFlowForm(FlowForm flowForm)
    {
        this.flowForm = flowForm;
    }
}
