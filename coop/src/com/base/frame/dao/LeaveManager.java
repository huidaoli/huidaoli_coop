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
	 * ��ӹ�����Ϣ
	 * @param document ���Ķ���
	 * @param workflowId ���Ķ�Ӧ������ID
	 * @param userId ���ĵĴ�����ID
	 * @param props ��������� 
	 */
	public void addLeave(Leave leave,int workflowId,int userId,AppInfo appInfo);
	
	/**
	 * ���¹�����Ϣ
	 * @param document
	 */
	public void updateLeave(Leave leave,int workflowId,int userId);
	
	/**
	 * ����ĳ������
	 * @param documentId
	 * @return
	 */
	public Leave findLeave(int leaveId);
	
	/**
	 * �����ҵĹ����б��������ɵ�ǰ��¼�û������Ĺ����б�
	 * @param userId ��ǰ��¼�û�
	 * @return
	 */
	public PagerModel searchMyLeaves(int userId);
	
	/**
	 * ɾ��������Ϣ
	 * @param documentId
	 */
	public void delLeave(int leaveId);
	
	/**
	 * �������ģ���¼������Ϣ
	 * @param approveInfo ������Ϣ
	 * @param documentId �������Ĺ���
	 * @param approverId �����ߣ�ȡ��ǰ��¼�û���ID
	 * @param back �Ƿ����
	 */
	public void addApproveInfo(AppInfo approveInfo,int leaveId,int approverId,boolean back);
	
	/**
	 * ��ѯ(��ǰ��¼�û���)�������б�
	 * @param userId �û�ID��ȡ��ǰ��¼�û���ID
	 * @return
	 */
	public PagerModel searchApprovedLeaves(Object param, int offset, int pagesize, int userId);
	
	/**
	 * ��ѯ���ĵ�������ʷ������ѯ���Ķ���������Щ��������
	 * @param documentId ���ĵ�ID
	 * @return
	 */
	public List searchApproveInfos(int leaveId);
	
	/**
	 * ��ѯ���󣨼��ȴ���ǰ��¼�û������ģ������б�
	 * @param userId ��ǰ��¼�û���ID
	 * @return
	 */
	public PagerModel searchApprovingLeaves(Object param,int userId,int offset, int pagesize);
	
	/**
	 * ��ѯ��һ����ѡ�����б�����ID���û���ʶ��
	 * @param documentId
	 * @param userId
	 * @return
	 */
	public List<String> searchNextSteps(int leaveId,int userId);
	
	/**
	 * �ύ������
	 * @param userId ��ǰ��¼�û���ID
	 * @param documentId ���ύ�Ĺ���ID
	 * @param transistionName Ҫ�ύ������ȥ
	 */
	public void submitToWorkflow(int userId,int leaveId,String transistionName);
	
	public PagerModel searchLeaves(Object param,int offset, int pagesize, int userId,String type);
	
	public List getUser(String roleName,int orgId);
	
	public void delAppInfoByLeaveId(int leaveId);
	
	public TaskInstance loadTaskInstance(int taskInstanceId);

    public Token loadToken(int tokenInstanceId);
    
    public ProcessInstance loadProcessInstance(int processInstanceId);
}
