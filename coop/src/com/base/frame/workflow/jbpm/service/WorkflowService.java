package com.base.frame.workflow.jbpm.service;

import java.util.List;

import com.base.frame.model.Workflow;
import com.cantodo.content.dto.FileUpload;

public interface WorkflowService {
    
    void add(String path,List<FileUpload> list, Workflow workflow) throws Exception;

    String searchRoles(Object param,int offset, int pagesize);
    
    Workflow findWorkflow(int workflow);
    
    void delWorkflow(String ids);

}
