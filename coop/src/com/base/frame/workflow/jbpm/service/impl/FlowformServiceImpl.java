package com.base.frame.workflow.jbpm.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.frame.dao.FormManager;
import com.base.frame.dto.FormFieldDTO;
import com.base.frame.model.FieldInput;
import com.base.frame.model.FieldItem;
import com.base.frame.model.FieldType;
import com.base.frame.model.FlowForm;
import com.base.frame.model.FormField;
import com.base.frame.workflow.jbpm.service.FlowformService;

@Service("flowformServiceImpl")
public class FlowformServiceImpl implements FlowformService
{

    private Log logger = LogFactory.getLog(FlowformServiceImpl.class);

    @Autowired
    private FormManager formManager;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public void addField(FormField field, int formId, String jsonData)
    {
        formManager.addField(field, formId);
        
        List<FieldItem> reList = null;

        if (StringUtils.isNotEmpty(jsonData))
        {
            JSONArray jsonArray = JSONArray.fromObject(jsonData);

            FieldItem[] fieldItems = (FieldItem[]) JSONArray.toArray(jsonArray, FieldItem.class);

            reList = Arrays.asList(fieldItems);
        }

        int fieldId = field.getId();

        formManager.updateFieldItems(fieldId, reList);

    }

    @Override
    public void addForm(FlowForm form, int workflowId)
    {
        formManager.addForm(form, workflowId);

    }

    @Override
    @Transactional
    public void delField(int fieldId)
    {
        formManager.delField(fieldId);

    }

    @Override
    @Transactional
    public void delForm(int formId)
    {
        formManager.delForm(formId);

    }

    @Override
    public FieldInput findFieldInput(int inputId)
    {
        // TODO Auto-generated method stub
        return formManager.findFieldInput(inputId);
    }

    @Override
    public FieldType findFieldType(int typeId)
    {
        // TODO Auto-generated method stub
        return formManager.findFieldType(typeId);
    }

    @Override
    public FlowForm findForm(int workflowId)
    {
        // TODO Auto-generated method stub
        return formManager.findForm(workflowId);
    }

    @Override
    public FormField findFormField(int fieldId)
    {
        // TODO Auto-generated method stub
        return formManager.findFormField(fieldId);
    }

    @Override
    public List<FormField> searchAllFields(int formId)
    {
        // TODO Auto-generated method stub
        return formManager.searchAllFields(formId);
    }

    @Override
    public List<FlowForm> searchAllForms()
    {
        // TODO Auto-generated method stub
        return formManager.searchAllForms();
    }

    @Override
    public List<FieldInput> searchFieldInputs()
    {
        // TODO Auto-generated method stub
        return formManager.searchFieldInputs();
    }

    @Override
    public List<FieldType> searchFieldTypes()
    {
        // TODO Auto-generated method stub
        return formManager.searchFieldTypes();
    }

    @Override
    @Transactional
    public void updateFieldItems(int fieldId, String pkey, String pvalue)
    {
        FieldItem fi = new FieldItem();
        fi.setLabel(pvalue);
        fi.setValue(pkey);

        List<FieldItem> items = new ArrayList<FieldItem>();
        items.add(fi);
        
        formManager.updateFieldItems(fieldId, items);

    }

    @Override
    @SuppressWarnings("unchecked")
    public String searchRoles(Object param, int offset, int pagesize, int workflowId)
    {
        FlowForm flowForm = this.findForm(workflowId);

        FormFieldDTO formFieldDTO = null;

        Set<FormFieldDTO> setFormFieldDTO = new LinkedHashSet<FormFieldDTO>();

        Map result = new HashMap();

        if (null == flowForm)
        {
            result.put("total", 0);
            result.put("rows", new HashSet().add(new FormField()));
        }
        else
        {
            for (FormField formField : flowForm.getFields())
            {
                formFieldDTO = new FormFieldDTO();
                formFieldDTO.setId(formField.getId());
                formFieldDTO.setFieldLabel(formField.getFieldLabel());
                formFieldDTO.setFieldName(formField.getFieldName());
                formFieldDTO.setFieldType(formField.getFieldType().getName());
                formFieldDTO.setFieldInput(formField.getFieldInput().getName());
                setFormFieldDTO.add(formFieldDTO);
            }
            result.put("total", setFormFieldDTO.size());
            result.put("rows", setFormFieldDTO);
        }

        String res = "";
        try
        {
            res = JSONObject.fromObject(result).toString();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return res;
    }

}
