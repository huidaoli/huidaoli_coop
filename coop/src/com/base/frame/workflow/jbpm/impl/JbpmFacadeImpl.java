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
 * [简要描述]:<br/> [详细描述]:<br/>
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

        // 将公文标题也提交到流程实例变量中，以便在E-Mail中能够提示这个公文的名称
        instance.getContextInstance().setVariable("leaveTitle", leave.getTitle());

        // 将公文的相关属性设置进入流程实例变量
        // Map props = leave.getProperties();
        // if(props != null){
        // Set entries = props.entrySet();
        // for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
        // Map.Entry entry = (Map.Entry) iterator.next();
        // String propertyName = (String)entry.getKey();
        // Object obj = leave.getProperty(propertyName);
        // //将变量放入流程实例变量
        // instance.getContextInstance().setVariable(propertyName, obj);
        // }
        // }

        instance.setKey(UUID.randomUUID().toString());

        context.save(instance);

        return instance.getId();
    }

    /**
     * 
     * [简要描述]:<br/>
     * [详细描述]:<br/>
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
     * [简要描述]:<br/>
     * [详细描述]:<br/>
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
     * [简要描述]:<br/>
     * [详细描述]:<br/>
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
     * [简要描述]:<br/>
     * [详细描述]:<br/>
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

        // 当前节点
        String currentNodeName = instance.getRootToken().getNode().getName();

        // 起点的名称
        String startNodeName = instance.getProcessDefinition().getStartState().getName();

        // 如果是在起点
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

            // 查找所属组的任务实例
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

        // 返回转向之后的节点名称
        return instance.getRootToken().getNode().getName();
    }

    /**
     * 回退
     * [简要描述]:<br/>
     * [详细描述]:<br/>
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

        // 根据流程实例标识查找流程实例
        ProcessInstance instance = context.getProcessInstance(processInstanceId);
        
        //instance.getTaskMgmtInstance().getId()
        Object[] os = new Object[2];
        // 搜索用户对应的所有的任务实例
        List taskInstances = context.getTaskMgmtSession().findPooledTaskInstances(actorId);
        for (Iterator iterator = taskInstances.iterator(); iterator.hasNext();)
        {
            TaskInstance ti = (TaskInstance) iterator.next();
            if (ti.getProcessInstance().getId() == processInstanceId)
            {

                // 先判断是否是要回退到起点
                Set set = ti.getToken().getNode().getArrivingTransitions();
                for (Iterator iterator2 = set.iterator(); iterator2.hasNext();)
                {
                    Transition t = (Transition) iterator2.next();
                    // 如果它需要回退到起点
                    //if (t.getFrom().equals(ti.getProcessInstance().getProcessDefinition().getStartState()))
                    {
                        int leaveId = (Integer) ti.getProcessInstance().getContextInstance().getVariable("leave");
                        // 结束当前的流程实例
                        ti.getProcessInstance().end();
                        // 结束当前任务实例
                        ti.end();

                        // 重新创建流程实例对象
                        ProcessInstance pi = new ProcessInstance(ti.getProcessInstance().getProcessDefinition());
                        pi.setKey(UUID.randomUUID().toString());
                        pi.getContextInstance().setVariable("leave", leaveId);
                        // 将流程实例对象重新持久化到数据库
                        context.save(pi);

                        os[0] = Leave.STATUS_MODIFY;
                        os[1] = pi.getId();

                        return os;
                    }
                }

                // 如果不需要回退到起点
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
     * [简要描述]:<br/>
     * [详细描述]:<br/>
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

        // 查找所属组的任务实例
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
     * [简要描述]:<br/>
     * [详细描述]:<br/>
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

        // 当前节点
        String currentNodeName = instance.getRootToken().getNode().getName();

        // 起点的名称
        String startNodeName = instance.getProcessDefinition().getStartState().getName();

        Collection transitions = null;

        // 如果是在起点
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

            // 查找所属组的任务实例
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
            // 为了不把Transition对象直接暴露给OA系统，需要将其转换为名称列表
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
