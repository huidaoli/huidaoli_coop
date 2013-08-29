package com.base.frame.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.base.frame.common.BaseManager;
import com.base.frame.dao.UserInfoManager;
import com.base.frame.model.UserInfo;
import com.base.frame.model.UsersRoles;
import com.base.frame.system.PagerModel;


/**
 * 
 * [¼òÒªÃèÊö]:<br/>
 * [ÏêÏ¸ÃèÊö]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
@Repository
public class UserInfoManagerImpl extends BaseManager implements UserInfoManager
{

    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param user
     * @throws DataAccessException
     * @exception 
     * @see com.base.frame.dao.UserInfoManager#addUserInfo(com.base.frame.model.UserInfo)
     */
    public void addUserInfo(UserInfo user) throws DataAccessException
    {

        getHibernateTemplate().save(user);

    }
    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param usersRoles
     * @throws DataAccessException
     * @exception 
     * @see com.base.frame.dao.UserInfoManager#addUsersRoles(com.base.frame.model.UsersRoles)
     */
    public void addUsersRoles(UsersRoles usersRoles) throws DataAccessException
    {

        getHibernateTemplate().save(usersRoles);

    }

    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param userId
     * @throws DataAccessException
     * @exception 
     * @see com.base.frame.dao.UserInfoManager#delUserInfo(int)
     */
    public void delUserInfo(int userId) throws DataAccessException
    {

        try
        {
            getHibernateTemplate().delete(findUser(userId));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param ur
     * @exception 
     * @see com.base.frame.dao.UserInfoManager#delUserRole(com.base.frame.model.UsersRoles)
     */
    public void delUserRole(UsersRoles ur) throws DataAccessException
    {
        getHibernateTemplate().delete(ur);
    }

    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param userId
     * @return
     * @exception 
     * @see com.base.frame.dao.UserInfoManager#searchUserRoles(int)
     */
    public List searchUserRoles(int userId) throws DataAccessException
    {
        return getHibernateTemplate().find(
                "select ur from UsersRoles ur " + "where ur.users.id = ? order by ur.orderNo", userId);
    }

    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param userId
     * @param roleId
     * @return
     * @exception 
     * @see com.base.frame.dao.UserInfoManager#findUsersRoles(int, int)
     */
    public UsersRoles findUsersRoles(int userId, int roleId) throws DataAccessException
    {
        return (UsersRoles) getSession().createQuery(
                "select ur from UsersRoles ur where " + "ur.roles.id = ? and ur.users.id = ?").setParameter(0, roleId).setParameter(
                1, userId).uniqueResult();
    }
    
    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param userId
     * @return
     * @exception 
     * @see com.base.frame.dao.UserInfoManager#getRolesByUserId(int)
     */
    @SuppressWarnings("unchecked")
    public List getRolesByUserId(int userId) throws DataAccessException
    {
        Query query = getSession().createQuery("select r from UsersRoles ur, Role r where  ur.roles.id = r.id and ur.users.id="+userId);
        List datas = query.list();
        return datas;
    }
    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param userId
     * @return
     * @throws DataAccessException
     * @exception 
     * @see com.base.frame.dao.UserInfoManager#findUser(int)
     */
    public UserInfo findUser(int userId) throws DataAccessException
    {
        return (UserInfo) getHibernateTemplate().load(UserInfo.class, userId);
    }

    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param param
     * @param offset
     * @param pagesize
     * @return
     * @throws DataAccessException
     * @exception 
     * @see com.base.frame.dao.UserInfoManager#searchRoles(java.lang.Object, int, int)
     */
    public PagerModel searchUserInfos(Object param, int offset, int pagesize) throws DataAccessException
    {
        if(null == param || param.equals("")) 
        {
            //return searchPaginated("select u.id,u.username,u.realname,u.sex,u.phone,u.officePhone,u.mail,u.description,u.createDate from UserInfo u  order by id desc", offset, pagesize);
            return searchPaginated("select u from UserInfo u  order by id desc", offset, pagesize);
        }
        else
        {
            return searchPaginated("select u from UserInfo u where u.username like '%"+param+"%' order by id desc", offset, pagesize);
        }
      
    }
    
    

    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param username
     * @param password
     * @return
     */
    public UserInfo login(String username, String password) throws DataAccessException
    {

        UserInfo user = (UserInfo) getSession().createQuery("select u from UserInfo u where u.username = ?").setParameter(
                0, username).uniqueResult();

        return user;
    }
    
    public UserInfo findUserInfo(String username)
    {
    	 UserInfo user = (UserInfo) getSession().createQuery("select u from UserInfo u where u.username = ?").setParameter(
                 0, username).uniqueResult();

         return user;
    }

    /**
     * [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param user
     * @throws DataAccessException
     * @exception
     * @see com.base.frame.dao.UserInfoManager#updateUserInfo(com.base.frame.model.UserInfo)
     */
    public void updateUserInfo(UserInfo user) throws DataAccessException
    {
        try {
			getHibernateTemplate().update(user);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
