package com.base.frame.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.base.frame.common.BaseManager;
import com.base.frame.dao.WorkflowManager;
import com.base.frame.model.Workflow;
import com.base.frame.system.PagerModel;
import com.base.frame.workflow.jbpm.JbpmFacade;

/**
 * 
 * [ºÚ“™√Ë ˆ]:<br/>
 * [œÍœ∏√Ë ˆ]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Oct 26, 2011
 */
@Repository
public class WorkflowManagerImpl extends BaseManager implements WorkflowManager
{

    @Autowired
    private JbpmFacade jbpmFacade;

    public void addOrUpdateWorkflow(Workflow workflow,String path)
    {
        
        String workflowName = jbpmFacade.deployProcessDefinition(workflow.getProcessDefPath(),path);
        
        workflow.setRealName(workflowName);
        
        getHibernateTemplate().saveOrUpdate(workflow);
    }

    public void delWorkflow(int workflowId)
    {
        
        Workflow wf = findWorkflow(workflowId);
        
        jbpmFacade.delProcessDefinition(wf.getRealName());
        
        getHibernateTemplate().delete(wf);
    }

    public Workflow findWorkflow(int workflowId)
    {
        return (Workflow) getHibernateTemplate().load(Workflow.class, workflowId);
    }

    public List<Workflow> searchAllWorkflows()
    {
        return getHibernateTemplate().find("from Workflow");
    }

    public void setJbpmFacade(JbpmFacade jbpmFacade)
    {
        this.jbpmFacade = jbpmFacade;
    }

    @Override
    public PagerModel searchRoles(Object param, int offset, int pagesize) throws DataAccessException
    {
        if(null == param || param.equals("")) 
        {
            return searchPaginated("select m from Workflow m order by id desc", offset, pagesize);
        }
        else
        {
            return searchPaginated("select m from Workflow m where m.name like '%"+param+"%' order by id desc", offset, pagesize);
        }
      
    }

}
