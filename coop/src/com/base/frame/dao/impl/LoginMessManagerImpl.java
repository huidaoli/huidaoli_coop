package com.base.frame.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.base.frame.common.BaseManager;
import com.base.frame.dao.LoginMessManager;
import com.base.frame.model.LoginMess;

@Repository
public class LoginMessManagerImpl extends BaseManager implements LoginMessManager
{

    @Override
    public void addLoginMess(LoginMess loginMess) throws DataAccessException
    {
        getHibernateTemplate().save(loginMess);
    }

    @Override
    public LoginMess findLoginMess(String username) throws DataAccessException
    {
        return (LoginMess) getSession().createQuery(
                "select loginMess from LoginMess loginMess where loginMess.username = ?").setParameter(0, username).uniqueResult();
    }

    @Override
    public void updateLoginMess(LoginMess loginMess) throws DataAccessException
    {
        getHibernateTemplate().update(loginMess);

    }

}
