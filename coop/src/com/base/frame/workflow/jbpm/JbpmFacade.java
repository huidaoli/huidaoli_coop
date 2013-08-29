package com.base.frame.workflow.jbpm;

import java.util.List;

import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;

import com.base.frame.model.Leave;

@SuppressWarnings("unchecked")
public interface JbpmFacade {
	
    /**
     * �������̶���
     * @param processDef ���̶����ļ�������
     * @return ��������
     */
    public String deployProcessDefinition(String newName,String path);
    
    /**
     * ɾ�����̶���
     * @param processName ��������
     */
    public void delProcessDefinition(String processName);
    
    /**
     * �������ʵ��
     * @param processName ����ʵ����Ӧ����������
     * @param docId ����ID
     * @return ����ʵ��
     */
    public long addProcessInstance(String processName,Leave leave);
    
    /**
     * ɾ������ʵ������
     * @param processInstanceId ɾ������ʵ������
     */
    public void delProcessInstance(long processInstanceId);
    
    /**
     * ����ĳ���û����ϵĹ����б�
     * @param actorId �û��ʺ�
     * @return List�е�Ԫ����docId
     */
    public List searchMyTaskList(String actorId);
    
    /**
     * ��ѯ��һ��Transition�б�
     * @param processInstanceId ����ʵ����ʶ
     * @param actorId �û��ʺ�
     * @return List�е�Ԫ����Transition���������
     */
    public List searchNextTransitions(long processInstanceId,String actorId);
    
    /**
     * ����JBPM������ת����һ��
     * @param processInstanceId ����ʵ����ʶ
     * @param actorId �û��ʺ�
     * @param transitionName transition Name
     * @return ��ת֮�󣬵�ǰ����ʵ������Ӧ��rootToken��ָ��Ľڵ������
     */
    public String nextStep(long processInstanceId,String actorId,String transitionName);
    
    /**
     * ���˲���
     * 
     * @param processInstanceId ����ʵ����ʶ
     * @param actorId ������
     * @return ����Ϊ2�����飬��һ��ֵ��ת��֮��Ľڵ����ƣ��ڶ���ֵ������ʵ����ʶ
     */
    public Object[] backStep(long processInstanceId,String actorId);
    
    public TaskInstance loadTaskInstance(int taskInstanceId);
    
    public Token loadToken(int tokenInstanceId);
    
    public ProcessInstance loadProcessInstance(int processInstanceId);
    
}
