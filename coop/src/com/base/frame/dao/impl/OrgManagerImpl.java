package com.base.frame.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.base.frame.common.BaseManager;
import com.base.frame.dao.OrgManager;
import com.base.frame.model.Organization;

/**
 * [简要描述]:<br/> [详细描述]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
@Repository("orgdao")
public class OrgManagerImpl extends BaseManager implements OrgManager
{

    public int addOrg(Organization org) throws DataAccessException
    {

        if (org.getParent().getId() == 0)
        {
            org.setParent(findOrg(org.getParent().getId()));
        }

        getHibernateTemplate().save(org);
        
        return org.getId();

    }

    public void delOrg(int orgId) throws DataAccessException
    {
         Organization org = (Organization)findOrg(orgId);
//         if(org.getChildren().size() > 0){
//         //throw new
//         RuntimeException("机构【"+org.getName()+"】下面存在子机构信息，不允许删除！");
//         throw new
//         SystemException("org.suborg.not.null",org.getName(),"机构【"+org.getName()+"】下面存在子机构信息，不允许删除！");
//         }
//         String hql = "select count(*) from Person p where p.org.id = ? ";
//         Long size = (Long)getSession().createQuery(hql).setParameter(0,
//         orgId).uniqueResult();
//         if(size > 0){
//         throw new SystemException("机构【"+org.getName()+"】下面存在人员信息，不允许删除！");
//         //throw new
//         RuntimeException("机构【"+org.getName()+"】下面存在人员信息，不允许删除！");
//         }
         getHibernateTemplate().delete(org);
    }

    public Organization findOrg(int orgId) throws DataAccessException
    {
        return (Organization) getHibernateTemplate().load(Organization.class, orgId);
    }

    @SuppressWarnings("unchecked")
    public List searchOrgsData(int parentId) throws DataAccessException
    {

        String selectHql = "select o from Organization o where o.parent is null";
        if (parentId != 0)
        {
            selectHql = "select o from Organization o where o.parent.id = " + parentId;
        }

        return searchPaginatedData(selectHql);
    }

    public void updateOrg(Organization org) throws DataAccessException
    {
        int parentId = org.getParent().getId();
        if (parentId == 0)
        {
            org.setParent(null);
        }
        getHibernateTemplate().update(org);
    }

}
