package com.base.frame.workflow.jbpm.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.def.Transition;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.base.frame.common.BaseManager;
import com.base.frame.common.CreateTransitionAction;
import com.base.frame.model.Leave;
import com.base.frame.workflow.jbpm.JbpmFacade;

/**
 * [��Ҫ����]:<br/> [��ϸ����]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Oct 26, 2011
 */
@SuppressWarnings("unchecked")
@Repository
public class JbpmFacadeImpl extends BaseManager implements JbpmFacade
{

    //@Autowired
    private JbpmConfiguration jbpmConfiguration;

    public long addProcessInstance(String processName, Leave leave)
    {

        JbpmContext context = getJbpmContext();

        ProcessDefinition def = context.getGraphSession().findLatestProcessDefinition(processName);

        ProcessInstance instance = new ProcessInstance(def);

        instance.getContextInstance().setVariable("leave", leave.getId());

        // �����ı���Ҳ�ύ������ʵ�������У��Ա���E-Mail���ܹ���ʾ������ĵ�����
        instance.getContextInstance().setVariable("leaveTitle", leave.getTitle());

        // �����ĵ�����������ý�������ʵ������
        // Map props = leave.getProperties();
        // if(props != null){
        // Set entries = props.entrySet();
        // for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
        // Map.Entry entry = (Map.Entry) iterator.next();
        // String propertyName = (String)entry.getKey();
        // Object obj = leave.getProperty(propertyName);
        // //��������������ʵ������
        // instance.getContextInstance().setVariable(propertyName, obj);
        // }
        // }

        instance.setKey(UUID.randomUUID().toString());

        context.save(instance);

        return instance.getId();
    }

    /**
     * 
     * [��Ҫ����]:<br/>
     * [��ϸ����]:<br/>
     * 
     * @author tangdingyi
     * @param processName
     * @exception 
     * @see com.base.frame.workflow.jbpm.JbpmFacade#delProcessDefinition(java.lang.String)
     */
    public void delProcessDefinition(String processName)
    {
        JbpmContext context = getJbpmContext();
        List defs = context.getGraphSession().findAllProcessDefinitionVersions(processName);
        for (Iterator iterator = defs.iterator(); iterator.hasNext();)
        {
            ProcessDefinition def = (ProcessDefinition) iterator.next();
            context.getGraphSession().deleteProcessDefinition(def);
        }
    }

    /**
     * 
     * [��Ҫ����]:<br/>
     * [��ϸ����]:<br/>
     * 
     * @author tangdingyi
     * @param processInstanceId
     * @exception 
     * @see com.base.frame.workflow.jbpm.JbpmFacade#delProcessInstance(long)
     */
    public void delProcessInstance(long processInstanceId)
    {
        JbpmContext context = getJbpmContext();
        context.getGraphSession().deleteProcessInstance(processInstanceId);
    }

    
    /**
     * 
     * [��Ҫ����]:<br/>
     * [��ϸ����]:<br/>
     * 
     * @author tangdingyi
     * @param newName
     * @param path
     * @return
     * @exception 
     * @see com.base.frame.workflow.jbpm.JbpmFacade#deployProcessDefinition(java.lang.String, java.lang.String)
     */
    public String deployProcessDefinition(String newName, String path)
    {

        JbpmContext context = getJbpmContext();

        ProcessDefinition def = null;
        try
        {
            def = ProcessDefinition.parseXmlInputStream(new FileInputStream(path + File.separator + newName));
            
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }

        context.deployProcessDefinition(def);

        return def.getName();
    }

    
    /**
     * 
     * [��Ҫ����]:<br/>
     * [��ϸ����]:<br/>
     * 
     * @author tangdingyi
     * @param processInstanceId
     * @param actorId
     * @param transitionName
     * @return
     * @exception 
     * @see com.base.frame.workflow.jbpm.JbpmFacade#nextStep(long, java.lang.String, java.lang.String)
     */
    public String nextStep(long processInstanceId, String actorId, String transitionName)
    {

        JbpmContext context = getJbpmContext();
        ProcessInstance instance = context.getProcessInstance(processInstanceId);

        // ��ǰ�ڵ�
        String currentNodeName = instance.getRootToken().getNode().getName();

        // ��������
        String startNodeName = instance.getProcessDefinition().getStartState().getName();

        // ����������
        if (startNodeName.equals(currentNodeName))
        {
            if (transitionName == null)
            {
                instance.signal();
            }
            else
            {
                try
                {
                    instance.signal(transitionName);
                }
                catch (Exception e)
                {
                    //System.out.println(e.getMessage());
                }
            }
        }
        else
        {
            List taskInstances = context.getTaskMgmtSession().findTaskInstances(actorId);
            for (Iterator iterator = taskInstances.iterator(); iterator.hasNext();)
            {
                TaskInstance ti = (TaskInstance) iterator.next();
                if (ti.getProcessInstance().getId() == processInstanceId)
                {
                    if (transitionName == null)
                    {
                        ti.end();
                    }
                    else
                    {
                        ti.end(transitionName);
                    }
                    break;
                }
            }

            // ���������������ʵ��
            List pooledTaskInstances = context.getTaskMgmtSession().findPooledTaskInstances(actorId);
            for (Iterator iterator = pooledTaskInstances.iterator(); iterator.hasNext();)
            {
                TaskInstance ti = (TaskInstance) iterator.next();
                if (ti.getProcessInstance().getId() == processInstanceId)
                {
                    if (transitionName == null)
                    {
                        ti.end();
                    }
                    else
                    {
                        ti.end(transitionName);
                    }
                    break;
                }
            }
        }

        // ����ת��֮��Ľڵ�����
        return instance.getRootToken().getNode().getName();
    }

    /**
     * ����
     * [��Ҫ����]:<br/>
     * [��ϸ����]:<br/>
     * 
     * @author tangdingyi
     * @param processInstanceId
     * @param actorId
     * @return
     * @exception 
     * @see com.base.frame.workflow.jbpm.JbpmFacade#backStep(long, java.lang.String)
     */
    public Object[] backStep(long processInstanceId, String actorId)
    {
        JbpmContext context = getJbpmContext();

        // ��������ʵ����ʶ��������ʵ��
        ProcessInstance instance = context.getProcessInstance(processInstanceId);
        
        //instance.getTaskMgmtInstance().getId()
        Object[] os = new Object[2];
        // �����û���Ӧ�����е�����ʵ��
        List taskInstances = context.getTaskMgmtSession().findPooledTaskInstances(actorId);
        for (Iterator iterator = taskInstances.iterator(); iterator.hasNext();)
        {
            TaskInstance ti = (TaskInstance) iterator.next();
            if (ti.getProcessInstance().getId() == processInstanceId)
            {

                // ���ж��Ƿ���Ҫ���˵����
                Set set = ti.getToken().getNode().getArrivingTransitions();
                for (Iterator iterator2 = set.iterator(); iterator2.hasNext();)
                {
                    Transition t = (Transition) iterator2.next();
                    // �������Ҫ���˵����
                    //if (t.getFrom().equals(ti.getProcessInstance().getProcessDefinition().getStartState()))
                    {
                        int leaveId = (Integer) ti.getProcessInstance().getContextInstance().getVariable("leave");
                        // ������ǰ������ʵ��
                        ti.getProcessInstance().end();
                        // ������ǰ����ʵ��
                        ti.end();

                        // ���´�������ʵ������
                        ProcessInstance pi = new ProcessInstance(ti.getProcessInstance().getProcessDefinition());
                        pi.setKey(UUID.randomUUID().toString());
                        pi.getContextInstance().setVariable("leave", leaveId);
                        // ������ʵ���������³־û������ݿ�
                        context.save(pi);

                        os[0] = Leave.STATUS_MODIFY;
                        os[1] = pi.getId();

                        return os;
                    }
                }

                // �������Ҫ���˵����
                //ti.end(CreateTransitionAction.BACK_TRANSITION);
                //break;
            }
        }

        os[0] = instance.getRootToken().getNode().getName();
        os[1] = processInstanceId;

        return os;
    }

    /**
     * 
     * [��Ҫ����]:<br/>
     * [��ϸ����]:<br/>
     * 
     * @author tangdingyi
     * @param actorId
     * @return
     * @exception 
     * @see com.base.frame.workflow.jbpm.JbpmFacade#searchMyTaskList(java.lang.String)
     */
    public List searchMyTaskList(String actorId)
    {

        JbpmContext context = getJbpmContext();
        List leaveIds = new ArrayList();
        List taskInstances = context.getTaskMgmtSession().findTaskInstances(actorId);
        for (Iterator iterator = taskInstances.iterator(); iterator.hasNext();)
        {
            TaskInstance ti = (TaskInstance) iterator.next();
            
            
            
            Integer leaveId = (Integer) ti.getProcessInstance().getContextInstance().getVariable("leave");
            leaveIds.add(leaveId);
        }

        // ���������������ʵ��
        List pooledTaskInstances = context.getTaskMgmtSession().findPooledTaskInstances(actorId);
        for (Iterator iterator = pooledTaskInstances.iterator(); iterator.hasNext();)
        {
            TaskInstance ti = (TaskInstance) iterator.next();
            Integer docId = (Integer) ti.getProcessInstance().getContextInstance().getVariable("leave");
            leaveIds.add(docId);
        }

        return leaveIds;
    }

    /**
     * 
     * [��Ҫ����]:<br/>
     * [��ϸ����]:<br/>
     * 
     * @author tangdingyi
     * @param processInstanceId
     * @param actorId
     * @return
     * @exception 
     * @see com.base.frame.workflow.jbpm.JbpmFacade#searchNextTransitions(long, java.lang.String)
     */
    public List searchNextTransitions(long processInstanceId, String actorId)
    {
        JbpmContext context = getJbpmContext();
        ProcessInstance instance = context.getProcessInstance(processInstanceId);
        
        //instance.getTaskMgmtInstance().get

        // ��ǰ�ڵ�
        String currentNodeName = instance.getRootToken().getNode().getName();

        // ��������
        String startNodeName = instance.getProcessDefinition().getStartState().getName();

        Collection transitions = null;

        // ����������
        if (startNodeName.equals(currentNodeName))
        {
            transitions = instance.getRootToken().getAvailableTransitions();
        }
        else
        {
            List taskInstances = context.getTaskMgmtSession().findTaskInstances(actorId);
            for (Iterator iterator = taskInstances.iterator(); iterator.hasNext();)
            {
                TaskInstance ti = (TaskInstance) iterator.next();
                if (ti.getProcessInstance().getId() == processInstanceId)
                {
                    transitions = ti.getAvailableTransitions();
                    break;
                }
            }

            // ���������������ʵ��
            List pooledTaskInstances = context.getTaskMgmtSession().findPooledTaskInstances(actorId);
            for (Iterator iterator = pooledTaskInstances.iterator(); iterator.hasNext();)
            {
                TaskInstance ti = (TaskInstance) iterator.next();
                if (ti.getProcessInstance().getId() == processInstanceId)
                {
                    transitions = ti.getAvailableTransitions();
                }
            }
        }

        List transitionNames = new ArrayList();

        if (transitions != null)
        {
            // Ϊ�˲���Transition����ֱ�ӱ�¶��OAϵͳ����Ҫ����ת��Ϊ�����б�
            for (Iterator iterator = transitions.iterator(); iterator.hasNext();)
            {
                Transition transition = (Transition) iterator.next();
                transitionNames.add(transition.getName());
            }
        }

        return transitionNames;
    }

    private JbpmContext getJbpmContext()
    {
        JbpmContext context = jbpmConfiguration.createJbpmContext();
        context.setSession(getSession());
        return context;
    }

    public void setJbpmConfiguration(JbpmConfiguration jbpmConfiguration)
    {
        this.jbpmConfiguration = jbpmConfiguration;
    }

    public TaskInstance loadTaskInstance(int taskInstanceId)
    {
        JbpmContext jbpmContext = getJbpmContext();
        TaskInstance taskInstance = jbpmContext.getTaskMgmtSession().loadTaskInstance(taskInstanceId);
        return taskInstance;
    }

    public Token loadToken(int tokenInstanceId)
    {
        JbpmContext jbpmContext = getJbpmContext();
        return jbpmContext.getGraphSession().loadToken(tokenInstanceId);
    }
    
    public ProcessInstance loadProcessInstance(int processInstanceId)
    {
        JbpmContext jbpmContext = getJbpmContext();
        ProcessInstance instance = jbpmContext.getProcessInstance(processInstanceId);
        return instance;
    }

    
}
