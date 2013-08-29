package com.base.frame.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.base.frame.common.BaseManager;
import com.base.frame.dao.RoleManager;
import com.base.frame.model.Role;
import com.base.frame.system.PagerModel;


/**
 * 
 * [ºÚ“™√Ë ˆ]:<br/>
 * [œÍœ∏√Ë ˆ]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
@Repository
public class RoleManagerImpl extends BaseManager implements RoleManager
{

    public void addRole(Role role) throws RuntimeException
    {

        getHibernateTemplate().save(role);

    }

    public void delRole(int roleId) throws RuntimeException
    {

        try
        {
            getHibernateTemplate().delete(findRole(roleId));
        }
        catch (Exception e)
        {
            //System.out.println(e.getMessage());
        }

    }

    public Role findRole(int roleId) throws RuntimeException
    {
        return (Role) getHibernateTemplate().load(Role.class, roleId);
    }

    public PagerModel searchRoles(Object param, int offset, int pagesize) throws DataAccessException
    {
        if(null == param || param.equals("")) 
        {
            return searchPaginated("select r from Role r  order by id desc", offset, pagesize);
        }
        else
        {
            return searchPaginated("select r from Role r where r.name like '%"+param+"%' order by id desc", offset, pagesize);
        }
      
    }
    
    @SuppressWarnings("unchecked")
    public List getAllRole() throws RuntimeException
    {
        Query query = getSession().createQuery("select r from Role r  order by id desc");
        List datas = query.list();
        return datas;
    }
    

    public void updateRole(Role role) throws RuntimeException
    {
        getHibernateTemplate().update(role);
    }

}
