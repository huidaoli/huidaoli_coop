package com.base.frame.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.jbpm.JbpmContext;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.base.frame.common.BaseManager;
import com.base.frame.dao.LeaveManager;
import com.base.frame.model.AppInfo;
import com.base.frame.model.Leave;
import com.base.frame.model.UserInfo;
import com.base.frame.model.Workflow;
import com.base.frame.system.PagerModel;
import com.base.frame.workflow.jbpm.JbpmFacade;

@Repository
public class LeaveManagerImpl extends BaseManager implements LeaveManager
{

    //@Autowired
    private JbpmFacade jbpmFacade;

    
    /**
     *  审批
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param appInfo
     * @param leaveId
     * @param approverId
     * @param back
     * @exception 
     */
    public void addApproveInfo(AppInfo appInfo, int leaveId, int approverId, boolean back)
    {
        Leave leave = (Leave) getHibernateTemplate().load(Leave.class, leaveId);
        UserInfo user = (UserInfo) getHibernateTemplate().load(UserInfo.class, approverId);
        appInfo.setLeave(leave);
        appInfo.setApprover(user);
        try
        {
            getHibernateTemplate().save(appInfo);
        }
        catch (Exception e)
        {
            //System.out.println(e.getMessage());
        }
        // 如果是驳回，则返回上一个节点
        if (back)
        {
            Object[] os = jbpmFacade.backStep(leave.getProcessInstanceId(), user.getUsername());
            leave.setStatus((String) os[0]);
            leave.setProcessInstanceId((Long) os[1]);
            getHibernateTemplate().update(leave);
        }
    }

    /**
     * 
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 添加假条
     * @author tangdingyi
     * @param leave
     * @param workflowId
     * @param userId
     * @param appInfo
     * @exception 
     * @see com.base.frame.dao.LeaveManager#addLeave(com.base.frame.model.Leave, int, int, com.base.frame.model.AppInfo)
     */
    public void addLeave(Leave leave, int workflowId, int userId,AppInfo appInfo)
    {

        // 保存公文信息
        leave.setWorkflow((Workflow) getHibernateTemplate().load(Workflow.class, workflowId));
        leave.setCreator((UserInfo) getHibernateTemplate().load(UserInfo.class, userId));
        leave.setStatus(Leave.STATUS_NEW);
        leave.setCreateTime(new Date());

        // 设置其它属性
        // leave.setPropertiesMap(props);

        try
        {
            getHibernateTemplate().save(leave);
        }
        catch (Exception e)
        {
            //System.out.println(e.getMessage());
        }
        // 添加流程实例
        long processInstanceId = jbpmFacade.addProcessInstance(leave.getWorkflow().getRealName(), leave);

        // 绑定流程实例的标识到公文对象
        leave.setProcessInstanceId(processInstanceId);
        getHibernateTemplate().update(leave);
        
        
        
        UserInfo user = (UserInfo) getHibernateTemplate().load(UserInfo.class, userId);
        appInfo.setLeave(leave);
        appInfo.setApprover(user);
        getHibernateTemplate().save(appInfo);
        
        
    }

    /**
     * 删除公文
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param leaveId
     * @exception 
     * @see com.base.frame.dao.LeaveManager#delLeave(int)
     */
    public void delLeave(int leaveId)
    {
        Leave leave = (Leave) getHibernateTemplate().load(Leave.class, leaveId);

        // 删除公文信息
        getHibernateTemplate().delete(leave);

        // 删除流程实例
        jbpmFacade.delProcessInstance(leave.getProcessInstanceId());
    }

    /**
     * 
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param leaveId
     * @return
     * @exception 
     * @see com.base.frame.dao.LeaveManager#findLeave(int)
     */
    public Leave findLeave(int leaveId)
    {

        return (Leave) getHibernateTemplate().load(Leave.class, leaveId);
    }

    /**
     * 查找公文的审批历史
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param leaveId
     * @return
     * @exception 
     * @see com.base.frame.dao.LeaveManager#searchApproveInfos(int)
     */
    public List searchApproveInfos(int leaveId)
    {

        return getHibernateTemplate().find("from AppInfo ai where ai.leave.id = ?"+ " order by id desc", leaveId);
    }

    /**
     * 查找用户已审批过的公文
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param param
     * @param offset
     * @param pagesize
     * @param userId
     * @return
     * @exception 
     * @see com.base.frame.dao.LeaveManager#searchApprovedLeaves(java.lang.Object, int, int, int)
     */
    public PagerModel searchApprovedLeaves(Object param, int offset, int pagesize, int userId)
    {
        if (null == param || param.equals(""))
        {
            return searchPaginated("select distinct ai.leave from AppInfo ai where ai.approver.id = ?", userId, offset, pagesize);
        }
        else
        {
            return searchPaginated("select distinct ai.leave from AppInfo ai where ai.approver.id = ? and ai.leave.title like '%"+param+"%'", userId, offset, pagesize);
        }
       // return searchPaginated("select distinct ai.leave from AppInfo ai where ai.approver.id = ?", userId);
    }

    /**
     * 查找正在等待审批的公文
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param param
     * @param userId
     * @param offset
     * @param pagesize
     * @return
     * @exception 
     * @see com.base.frame.dao.LeaveManager#searchApprovingLeaves(java.lang.Object, int, int, int)
     */
    public PagerModel searchApprovingLeaves(Object param,int userId,int offset, int pagesize)
    {
        UserInfo user = (UserInfo) getHibernateTemplate().load(UserInfo.class, userId);

        // 搜索已流转到用户那里的公文标识列表
        List leaveIds = jbpmFacade.searchMyTaskList(user.getUsername());

        if (leaveIds == null || leaveIds.isEmpty())
        {
            PagerModel pm = new PagerModel();
            pm.setDatas(new ArrayList());
            pm.setTotal(0);
            return pm;
        }
        
        Query query = null;
        
        int total = 0;

        // 根据公文标识查找所有的公文对象
        
        if (null == param || param.equals(""))
        {
            query = getSession().createQuery("select count(*) from Leave d where d.id in (:ids)").setParameterList(
                    "ids", leaveIds);

            total = ((Long) query.uniqueResult()).intValue();

            query = getSession().createQuery("select d from Leave d where d.id in (:ids)").setParameterList("ids",
                    leaveIds);
        }
        else
        {
            query = getSession().createQuery("select count(*) from Leave d where d.title like '%"+param+"%' and d.id in (:ids)").setParameterList(
                    "ids", leaveIds);

            total = ((Long) query.uniqueResult()).intValue();

            query = getSession().createQuery("select d from Leave d where d.title like '%"+param+"%' and d.id in (:ids)").setParameterList("ids",
                    leaveIds);
        }
        
        

        // 获取结果集
       
        
        query.setFirstResult(offset);
        query.setMaxResults(pagesize);
        List datas = query.list();

        // 返回PagerModel
        PagerModel pm = new PagerModel();
        pm.setDatas(datas);
        pm.setTotal(total);
        return pm;
    }

    /**
     * 查找用户创建的所有公文
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param userId
     * @return
     * @exception 
     * @see com.base.frame.dao.LeaveManager#searchMyLeaves(int)
     */
    public PagerModel searchMyLeaves(int userId)
    {

        return searchPaginated("select d from Leave d where d.creator.id = ?", userId);
    }

    public List<String> searchNextSteps(int leaveId, int userId)
    {
        Leave leave = findLeave(leaveId);
        UserInfo user = (UserInfo) getHibernateTemplate().load(UserInfo.class, userId);
        String username = user.getUsername();

        return jbpmFacade.searchNextTransitions(leave.getProcessInstanceId(), username);
    }

    /**
     *  提交到流程
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param userId
     * @param leaveId
     * @param transitionName
     * @exception 
     * @see com.base.frame.dao.LeaveManager#submitToWorkflow(int, int, java.lang.String)
     */
    public void submitToWorkflow(int userId, int leaveId, String transitionName)
    {
        UserInfo user = (UserInfo) getHibernateTemplate().load(UserInfo.class, userId);
        String username = user.getUsername();

        Leave leave = (Leave) getHibernateTemplate().load(Leave.class, leaveId);
        long processInstanceId = leave.getProcessInstanceId();
        
        if(leave.getStatus().equals(Leave.STATUS_MODIFY))
        {
            AppInfo appInfo = new AppInfo();
            appInfo.setApproveTime(new Date());
            appInfo.setAggType(Leave.STATUS_SUBMIT);
            appInfo.setLeave(leave);
            appInfo.setApprover(user);
            getHibernateTemplate().save(appInfo);
        }

        String status = jbpmFacade.nextStep(processInstanceId, username, transitionName);

        leave.setStatus(status);
        getHibernateTemplate().update(leave);
    }
    
    private int get(int leaveId)
    {
        Leave leave = (Leave) getHibernateTemplate().load(Leave.class, leaveId);
        long processInstanceId = leave.getProcessInstanceId();
        
        JbpmContext context = null;
        ProcessInstance instance = context.getProcessInstance(processInstanceId);
        
        return (int)instance.getTaskMgmtInstance().getId();
    }

    /**
     * 更新公文信息
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param leave
     * @param workflowId
     * @param userId
     * @exception 
     * @see com.base.frame.dao.LeaveManager#updateLeave(com.base.frame.model.Leave, int, int)
     */
    public void updateLeave(Leave leave, int workflowId, int userId)
    {
        Leave leaveDb = (Leave) getHibernateTemplate().load(Leave.class, leave.getId());

        leaveDb.setDays(leave.getDays());
        leaveDb.setDescription(leave.getDescription());
        leaveDb.setEndTime(leave.getEndTime());
        leaveDb.setStartTime(leave.getStartTime());
        leaveDb.setLeaveType(leave.getLeaveType());
        leaveDb.setTitle(leave.getTitle());
        
        getHibernateTemplate().update(leaveDb);
        
    }

    public void setJbpmFacade(JbpmFacade jbpmFacade)
    {
        this.jbpmFacade = jbpmFacade;
    }

    public PagerModel searchLeaves(Object param, int offset, int pagesize, int userId,String type)
    {
        String li =null;
        if(type.equals("execcart"))
        {
            li = "=";
        }
        if(type.equals("listleave"))
        {
            li = "!=";
        }
        if (null == param || param.equals(""))
        {
            return searchPaginated("select d from Leave d where d.creator.id =" + userId
                    + " and d.leaveType "+li+"10000 order by d.createTime desc", offset, pagesize);
        }
        else
        {
            return searchPaginated("select d from Leave d where d.creator.id =" + userId + " and d.title like '%"
                    + param + "%' and  d.leaveType "+li+" 10000 order by d.createTime desc", offset, pagesize);
        }
    }

    @Override
    public List getUser(String roleName, int orgId)
    {
        Query query = getSession().createQuery(
                "select u.username from UserInfo u , UsersRoles ur, Role r where u.id = ur.users.id and ur.roles.id = r.id and r.name=? and u.orga.id=?");
       
        List datas = query.setParameter(0, roleName).setParameter(1, orgId).list();
        
        return datas;
    }
    
    /**
     * 
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param leaveId
     * @exception 
     * @see com.base.frame.dao.LeaveManager#delAppInfoByLeaveId(int)
     */
    public void delAppInfoByLeaveId(int leaveId)
    {
        
        Query q = getSession().createQuery("delete from AppInfo ap where ap.leave.id="+leaveId) ;
        
        q.executeUpdate();
    }
    
    public TaskInstance loadTaskInstance(int taskInstanceId)
    {
        return jbpmFacade.loadTaskInstance(taskInstanceId);
    }

    public Token loadToken(int tokenInstanceId)
    {
        return jbpmFacade.loadToken(tokenInstanceId);
    }

    @Override
    public ProcessInstance loadProcessInstance(int leaveId)
    {
        Leave leave = (Leave) getHibernateTemplate().load(Leave.class, leaveId);
        int processInstanceId = (int)leave.getProcessInstanceId();
        
        return jbpmFacade.loadProcessInstance(processInstanceId);
    }

}
