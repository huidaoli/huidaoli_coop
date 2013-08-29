package com.base.frame.dao;

import java.util.List;

import com.base.frame.model.UserInfo;
import com.base.frame.model.UsersRoles;
import com.base.frame.system.PagerModel;

/**
 * 
 * [ºÚ“™√Ë ˆ]:<br/>
 * [œÍœ∏√Ë ˆ]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
public interface UserInfoManager
{
    public void addUserInfo(UserInfo user);
    
    public void addUsersRoles(UsersRoles usersRoles);

    public void delUserInfo(int userId);

    public void updateUserInfo(UserInfo user);

    public UserInfo findUser(int userId);
    
    public void delUserRole(UsersRoles ur);
    
    public List searchUserRoles(int userId);
    
    public UsersRoles findUsersRoles(int userId, int roleId);

    public PagerModel searchUserInfos(Object param, int offset, int pagesize);
    
    List getRolesByUserId(int userId);
    
    UserInfo login(String username, String password);
    
    UserInfo findUserInfo(String username);
}
