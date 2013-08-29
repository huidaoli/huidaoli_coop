package com.base.frame.security.service;
import java.util.List;

import com.base.frame.model.Role;

/**
 * 
 * [¼òÒªÃèÊö]:<br/>
 * [ÏêÏ¸ÃèÊö]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
public interface RoleService
{

    void addRole(Role role);

    void delRole(int roleId);
    
    void delRole(String ids);

    void updateRole(Role role);

    Role findRole(int roleId);

    String  searchRoles(Object param,int offset, int pagesize);
    
    public String getAllRole();

}
