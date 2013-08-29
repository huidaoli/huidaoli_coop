package com.base.frame.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.base.frame.common.BaseManager;
import com.base.frame.dao.FormManager;
import com.base.frame.model.FieldInput;
import com.base.frame.model.FieldItem;
import com.base.frame.model.FieldType;
import com.base.frame.model.FlowForm;
import com.base.frame.model.FormField;
import com.base.frame.model.Workflow;
import com.base.frame.system.PagerModel;

@Repository("formManagerdao")
@SuppressWarnings("unchecked")
public class FormManagerImpl extends BaseManager implements FormManager
{

    public void addField(FormField field, int formId)
    {

        field.setFlowForm((FlowForm) getHibernateTemplate().load(FlowForm.class, formId));

        field.setFieldInput((FieldInput) getHibernateTemplate().load(FieldInput.class, field.getFieldInput().getId()));
        field.setFieldType((FieldType) getHibernateTemplate().load(FieldType.class, field.getFieldType().getId()));

        try
        {
            getHibernateTemplate().saveOrUpdate(field);
        }
        catch (Exception e)
        {
           System.err.println(e.getMessage());
        }
    }

    public FormField findFormField(int fieldId)
    {

        return (FormField) getHibernateTemplate().load(FormField.class, fieldId);
    }

    public void addForm(FlowForm form, int workflowId)
    {
        Workflow wf = (Workflow) getHibernateTemplate().load(Workflow.class, workflowId);
        form.setWorkflow(wf);
        getHibernateTemplate().saveOrUpdate(form);
    }

    public void updateFieldItems(int fieldId, List<FieldItem> items)
    {
        FormField field = findFormField(fieldId);
        try
        {
            field.setItems(items);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        getHibernateTemplate().update(field);
    }

    public void delField(int fieldId)
    {
        FormField ff = (FormField) getHibernateTemplate().load(FormField.class, fieldId);
        getHibernateTemplate().delete(ff);
    }

    public void delForm(int formId)
    {
        getHibernateTemplate().delete((FlowForm) getHibernateTemplate().load(FlowForm.class, formId));
    }

    public FlowForm findForm(int workflowId)
    {

        return (FlowForm) getSession().createQuery("select f from FlowForm f where f.workflow.id = ?").setParameter(0,
                workflowId).uniqueResult();
    }

    public List<FormField> searchAllFields(int formId)
    {

        return getHibernateTemplate().find("select ff from FormField ff where ff.flowForm.id = ?", formId);
    }

   
    public List<FlowForm> searchAllForms()
    {

        return getHibernateTemplate().find("from FlowForm");
    }

    public List<FieldInput> searchFieldInputs()
    {

        return getHibernateTemplate().find("select fi from FieldInput fi");
    }

    public List<FieldType> searchFieldTypes()
    {
        return getHibernateTemplate().find("select ft from FieldType ft");
    }

    public FieldInput findFieldInput(int inputId)
    {
        return (FieldInput) getHibernateTemplate().load(FieldInput.class, inputId);
    }

    public FieldType findFieldType(int typeId)
    {
        return (FieldType) getHibernateTemplate().load(FieldType.class, typeId);
    }


}
