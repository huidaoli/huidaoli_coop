package com.base.frame.security.service;
import java.util.List;

import com.base.frame.model.DictBuss;
import com.base.frame.model.UserInfo;
import com.base.frame.model.UsersRoles;

/**
 * 
 * [ºÚ“™√Ë ˆ]:<br/>
 * [œÍœ∏√Ë ˆ]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
public interface UserInfoService
{

    void addUserInfo(UserInfo user,String [] roleIds);

    void delUserInfo(int userId);
    
    void delUserInfo(String ids);

    void updateUserInfo(UserInfo user,String [] roleIds);
    
    void updateUserInfo(UserInfo user);

    UserInfo findUserInfo(int userId);
    
    List searchUserRoles(int userId);
    
    boolean findUserInfoByName(String username);
    
    String roleIdsByUserId(int userId);

    String  searchUserInfos(Object param,int offset, int pagesize);
    
    List<DictBuss> listDictBuss(int type);
    
    List<UsersRoles> getRolesByUserId(int userId);
    
    UserInfo login(String username, String password);
    

}
