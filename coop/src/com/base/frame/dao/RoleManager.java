package com.base.frame.dao;

import java.util.List;

import com.base.frame.model.Role;
import com.base.frame.system.PagerModel;

/**
 * 
 * [¼òÒªÃèÊö]:<br/>
 * [ÏêÏ¸ÃèÊö]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
public interface RoleManager
{
    public void addRole(Role role);

    public void delRole(int roleId);

    public void updateRole(Role role);

    public Role findRole(int roleId);

    public PagerModel searchRoles(Object param, int offset, int pagesize);
    
    public List getAllRole();
}
