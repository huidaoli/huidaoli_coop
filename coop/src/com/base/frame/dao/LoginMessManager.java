package com.base.frame.dao;

import java.util.List;

import com.base.frame.model.LoginMess;
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
public interface LoginMessManager
{
    public void addLoginMess(LoginMess loginMess);

    public void updateLoginMess(LoginMess loginMess);

    public LoginMess findLoginMess(String username);
    
}
