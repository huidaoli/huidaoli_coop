package com.base.frame.dao;

import java.util.List;

import com.base.frame.model.Workflow;
import com.base.frame.system.PagerModel;

public interface WorkflowManager
{

    public void addOrUpdateWorkflow(Workflow workflow,String path);

    public void delWorkflow(int workflow);

    public Workflow findWorkflow(int workflow);

    public List searchAllWorkflows();

    PagerModel searchRoles(Object param,int offset, int pagesize);
}
