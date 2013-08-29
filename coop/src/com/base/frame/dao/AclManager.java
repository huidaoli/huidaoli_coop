package com.base.frame.dao;

import java.util.List;

import com.base.frame.model.ACL;

public interface AclManager
{

    /**
     * ��ӻ������Ȩ
     * 
     * @param principalType �������ͱ�ʶ�����ɫ���û�
     * @param principalId �����ʶ
     * @param moduleId ģ���ʶ
     * @param permission ������ʶ��C/R/U/D��
     * @param yes �Ƿ�����
     */
    public void addOrUpdatePermission(String principalType, int principalId, int moduleId);
    
    public List getModulesByPrincipalId(int principalId);
    
    public void delACL(ACL acl);

    /**
     * ɾ����Ȩ
     * 
     * @param principalType
     * @param principalId
     * @param moduleId
     */
    public void delPermission(String principalType, int principalId, int moduleId);

    /**
     * ����aclTriState��ֵ
     * 
     * @param userId �û���ʶ
     * @param moduleId ģ���ʶ
     * @param yes �Ƿ���Ч
     */
    public void addOrUpdateUserExtends(int userId, int moduleId, boolean yes);

    /**
     * ��ʱ��֤���ж�ĳ���û��Ƿ�ӵ�ж�ĳ��ģ���ĳ��������Ȩ��
     * 
     * @param userId �û���ʶ
     * @param moduleId ģ���ʶ
     * @param permission ������ʶ��C/R/U/D��
     * @return ���������
     */
    public boolean hasPermission(int userId, int moduleId, int permission);

    /**
     * �ж��û���ĳģ���ĳ��������Ȩ�����������
     * 
     * @param userId �û�ID
     * @param reourceSn ��ԴΨһ��ʶ��sn��
     * @param permission Ȩ�ޣ�C/R/U/D��
     * @return ����true��������false��
     */
    public boolean hasPermissionByResourceSn(int userId, String reourceSn, int permission);

    /**
     * ��ѯ�û�ӵ�ж�ȡȨ�޵�ģ���б�
     * 
     * @param userId �û���ʶ
     * @return �б�Ԫ����Module����
     */
    public List searchModules(int userId);

    public List searchAclRecord(String principalType, int principalId);
}
