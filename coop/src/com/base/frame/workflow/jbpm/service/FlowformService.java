package com.base.frame.workflow.jbpm.service;

import java.util.List;

import com.base.frame.model.FieldInput;
import com.base.frame.model.FieldItem;
import com.base.frame.model.FieldType;
import com.base.frame.model.FlowForm;
import com.base.frame.model.FormField;

/**
 * ��������
 * 
 * @author Lee
 */
public interface FlowformService
{

    // ��
    void addForm(FlowForm form, int workflowId);

    void delForm(int formId);

    FlowForm findForm(int workflowId);

    List<FlowForm> searchAllForms();

    // ����
    void addField(FormField field, int formId,String jsonData);

    void delField(int fieldId);

    FormField findFormField(int fieldId);

    List<FormField> searchAllFields(int formId);

    // ��������
    FieldType findFieldType(int typeId);

    List<FieldType> searchFieldTypes();

    // ���������
    FieldInput findFieldInput(int inputId);

    List<FieldInput> searchFieldInputs();

    void updateFieldItems(int fieldId,String pkey,String pvalue);

    String searchRoles(Object param, int offset, int pagesize,int workflowId);
}
