package com.base.frame.workflow.jbpm.service;

import java.util.List;

import com.base.frame.model.FieldInput;
import com.base.frame.model.FieldItem;
import com.base.frame.model.FieldType;
import com.base.frame.model.FlowForm;
import com.base.frame.model.FormField;

/**
 * 表单管理器
 * 
 * @author Lee
 */
public interface FlowformService
{

    // 表单
    void addForm(FlowForm form, int workflowId);

    void delForm(int formId);

    FlowForm findForm(int workflowId);

    List<FlowForm> searchAllForms();

    // 表单域
    void addField(FormField field, int formId,String jsonData);

    void delField(int fieldId);

    FormField findFormField(int fieldId);

    List<FormField> searchAllFields(int formId);

    // 表单域类型
    FieldType findFieldType(int typeId);

    List<FieldType> searchFieldTypes();

    // 表单域输入框
    FieldInput findFieldInput(int inputId);

    List<FieldInput> searchFieldInputs();

    void updateFieldItems(int fieldId,String pkey,String pvalue);

    String searchRoles(Object param, int offset, int pagesize,int workflowId);
}
