package com.base.frame.dao;

import java.util.List;

import com.base.frame.model.Organization;


/**
 * 
 * [��Ҫ����]:<br/>
 * [��ϸ����]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
public interface OrgManager {
	
	/**
	 * ��ӻ�����Ϣ�����parentIdΪ0������ӵ��Ƕ�������
	 * ��Ҫ�Զ����ɻ���Ψһ���
	 * @param org ������Ϣ
	 * @param parentId ��������ʶ
	 */
	public int addOrg(Organization org);
	
	/**
	 * ɾ��������Ϣ����������������ӻ����������������Ա��Ϣ��������ɾ��
	 * @param orgId ������ʶ
	 */
	public void delOrg(int orgId);
	
	
	public void updateOrg(Organization org);
	
	/**
	 * ��ѯ�ض��Ļ���
	 * @param orgId
	 * @return
	 */
	public Organization findOrg(int orgId);
	
	/**
	 * ���ݸ�������ʶ��ѯ���µ��ӻ����б�
	 * ���parentIdΪ0�����ѯ���������б�
	 * @param parentId ��������ʶ
	 * @return ���ϵ�Ԫ����Organization����
	 */
	public List searchOrgsData(int parentId);
}
