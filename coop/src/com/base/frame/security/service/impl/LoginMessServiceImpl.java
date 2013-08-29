package com.base.frame.security.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.frame.dao.LoginMessManager;
import com.base.frame.model.LoginMess;
import com.base.frame.security.service.LoginMessService;

@Service
public class LoginMessServiceImpl implements LoginMessService
{
    
    private Log logger = LogFactory.getLog(LoginMessServiceImpl.class);
    

    @Autowired
    private LoginMessManager loginMessManager;
    
    @Override
    @Transactional
    public void addLoginMess(LoginMess loginMess)
    {
        loginMessManager.addLoginMess(loginMess);
    }

    @Override
    public LoginMess findLoginMess(String username)
    {
        return loginMessManager.findLoginMess(username);
    }

    @Override
    @Transactional
    public void updateLoginMess(LoginMess loginMess)
    {
        loginMessManager.updateLoginMess(loginMess);
    }

}
