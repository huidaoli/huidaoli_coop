package com.base.frame.security.service;

import com.base.frame.model.LoginMess;

public interface LoginMessService
{
    void addLoginMess(LoginMess loginMess);

    void updateLoginMess(LoginMess loginMess);

    LoginMess findLoginMess(String username);
}
