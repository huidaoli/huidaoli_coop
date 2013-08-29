package com.base.frame.model;

/**
 * [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 21, 2011
 */

public class UsersRoles
{
    private int id;

    private Role roles;

    private UserInfo users;

    private int orderNo;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    

    public Role getRoles()
    {
        return roles;
    }

    public void setRoles(Role roles)
    {
        this.roles = roles;
    }

    public UserInfo getUsers()
    {
        return users;
    }

    public void setUsers(UserInfo users)
    {
        this.users = users;
    }

    public int getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(int orderNo)
    {
        this.orderNo = orderNo;
    }
}
