package com.base.frame.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.base.frame.common.BaseManager;
import com.base.frame.dao.AclManager;
import com.base.frame.model.ACL;

@Repository("acldao")
public class AclManagerImpl extends BaseManager implements AclManager {

    @Override
    public void addOrUpdatePermission(String principalType, int principalId, int moduleId) throws DataAccessException
    {
      //����ACL����
        ACL acl = findACL(principalType, principalId, moduleId);
        
        //�ܹ��ҵ�ACL���󣬸���permission
        if(acl != null){
            getHibernateTemplate().update(acl);
            return;
        }
        
        //�Ҳ���ACL�����򴴽�ACL���󣬲�����permission
        acl = new ACL();
        acl.setPrincipalType(principalType);
        acl.setPrincipalId(principalId);
        acl.setModuleId(moduleId);
        getHibernateTemplate().save(acl);
        
    }
    
    @SuppressWarnings("unchecked")
    public List getModulesByPrincipalId(int principalId) throws DataAccessException
    {
        Query query = getSession().createQuery("select a from ACL a where a.principalId ="+principalId);
        List datas = query.list();
        return datas;
    }
    
    /**
     * 
     * [��Ҫ����]:<br/>
     * [��ϸ����]:<br/>
     * 
     * @author tangdingyi
     * @param aclId
     * @exception 
     * @see com.base.frame.dao.AclManager#delACL(int)
     */
    public void delACL(ACL acl) throws DataAccessException
    {
        getHibernateTemplate().delete(acl);
    }
    
    /**
     * ������Ȩ��¼������Ҳ��������ؿ�ֵ
     * @param principalType
     * @param principalId
     * @param moduleId
     * @return
     */
    private ACL findACL(String principalType,int principalId,int moduleId) throws DataAccessException
    {
        return (ACL)getSession().createQuery(
                "select acl from ACL acl where acl.principalType = ? " +
                "and acl.principalId=? and acl.moduleId = ?")
                .setParameter(0, principalType)
                .setParameter(1, principalId)
                .setParameter(2, moduleId)
                .uniqueResult();
    }

    @Override
    public void addOrUpdateUserExtends(int userId, int moduleId, boolean yes) throws DataAccessException
    {
        // TODO Auto-generated method stub
        
    }

    @Override 
    public void delPermission(String principalType, int principalId, int moduleId) throws DataAccessException
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean hasPermission(int userId, int moduleId, int permission) throws DataAccessException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasPermissionByResourceSn(int userId, String reourceSn, int permission) throws DataAccessException
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List searchAclRecord(String principalType, int principalId) throws DataAccessException
    {
        
        Query query = getSession().createQuery("select a from ACL a where a.principalType='"+principalType+"' and a.principalId="+principalId);
        return query.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List searchModules(int userId) throws DataAccessException
    {
        // TODO Auto-generated method stub
        return null;
    }

	
	
	

}
