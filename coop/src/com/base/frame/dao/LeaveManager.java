package com.base.frame.dao;

import java.util.List;
import java.util.Map;

import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.base.frame.model.AppInfo;
import com.base.frame.model.Leave;
import com.base.frame.system.PagerModel;

public interface LeaveManager {
	
	/**
	 * 添加公文信息
	 * @param document 公文对象
	 * @param workflowId 公文对应的流程ID
	 * @param userId 公文的创建者ID
	 * @param props 额外的属性 
	 */
	public void addLeave(Leave leave,int workflowId,int userId,AppInfo appInfo);
	
	/**
	 * 更新公文信息
	 * @param document
	 */
	public void updateLeave(Leave leave,int workflowId,int userId);
	
	/**
	 * 查找某个公文
	 * @param documentId
	 * @return
	 */
	public Leave findLeave(int leaveId);
	
	/**
	 * 搜索我的公文列表（即搜索由当前登录用户创建的公文列表）
	 * @param userId 当前登录用户
	 * @return
	 */
	public PagerModel searchMyLeaves(int userId);
	
	/**
	 * 删除公文信息
	 * @param documentId
	 */
	public void delLeave(int leaveId);
	
	/**
	 * 审批公文，记录审批信息
	 * @param approveInfo 审批信息
	 * @param documentId 被审批的公文
	 * @param approverId 审批者，取当前登录用户的ID
	 * @param back 是否回退
	 */
	public void addApproveInfo(AppInfo approveInfo,int leaveId,int approverId,boolean back);
	
	/**
	 * 查询(当前登录用户的)已审公文列表
	 * @param userId 用户ID，取当前登录用户的ID
	 * @return
	 */
	public PagerModel searchApprovedLeaves(Object param, int offset, int pagesize, int userId);
	
	/**
	 * 查询公文的审批历史（即查询公文都经过了哪些人审批）
	 * @param documentId 公文的ID
	 * @return
	 */
	public List searchApproveInfos(int leaveId);
	
	/**
	 * 查询待审（即等待当前登录用户审批的）公文列表
	 * @param userId 当前登录用户的ID
	 * @return
	 */
	public PagerModel searchApprovingLeaves(Object param,int userId,int offset, int pagesize);
	
	/**
	 * 查询下一个可选步骤列表（公文ID，用户标识）
	 * @param documentId
	 * @param userId
	 * @return
	 */
	public List<String> searchNextSteps(int leaveId,int userId);
	
	/**
	 * 提交到流程
	 * @param userId 当前登录用户的ID
	 * @param documentId 被提交的公文ID
	 * @param transistionName 要提交到哪里去
	 */
	public void submitToWorkflow(int userId,int leaveId,String transistionName);
	
	public PagerModel searchLeaves(Object param,int offset, int pagesize, int userId,String type);
	
	public List getUser(String roleName,int orgId);
	
	public void delAppInfoByLeaveId(int leaveId);
	
	public TaskInstance loadTaskInstance(int taskInstanceId);

    public Token loadToken(int tokenInstanceId);
    
    public ProcessInstance loadProcessInstance(int processInstanceId);
}
