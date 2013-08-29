package com.base.frame.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.base.frame.common.BaseManager;
import com.base.frame.dao.DictBussManager;
import com.base.frame.model.DictBuss;

/**
 * [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
@Repository("dictBussdao")
public class DictBussManagerImpl extends BaseManager implements DictBussManager
{
    /**
     * ÒµÎñ×Öµä [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @param type
     * @return
     * @throws DataAccessException
     * @exception
     * @see com.base.frame.dao.DictBussManager#listDictBuss(int)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<DictBuss> listDictBuss(int type) throws DataAccessException
    {
        String selectHql = "select d from DictBuss d where d.dictType =" + type;

        return searchPaginatedData(selectHql);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DictBuss> getAllList() throws DataAccessException
    {
        String selectHql = "select d.dictType,d.descript from DictBuss d where d.dictType not in(1,2) group by d.dictType  order by d.dictType";

        return searchPaginatedData(selectHql);
    }

    @SuppressWarnings("unchecked")
    @Override
    public int getIdByName(String name, int type) throws DataAccessException
    {
        String selectHql = "select d.dictId from DictBuss d where d.dictType =? and d.dictName=? ";

        Query query = getSession().createQuery(selectHql);

        query.setParameter(0, type);
        query.setParameter(1, name);
        int dictId = 0;
        try
        {
            dictId = (Integer) query.uniqueResult();
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dictId;
    }

    public void update(String arg1, String arg2, String arg3)
    {
        String updatesql = "update t_dictbuss set dictId =? , dictName=?  where id=?";
        SQLQuery sQLQuery = getSession().createSQLQuery(updatesql);
        sQLQuery.setParameter(0, arg1);
        sQLQuery.setParameter(1, arg2);
        sQLQuery.setParameter(2, arg3);
        try
        {
            sQLQuery.executeUpdate();
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void insert(DictBuss dictbuss)
    {
        getSession().save(dictbuss);
    }
    
    public void update(DictBuss dictbuss)
    {
        getSession().update(dictbuss);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getDescript(int type) throws DataAccessException
    {
        String selectHql = "select distinct(d.descript) from DictBuss d where d.dictType =?";

        Query query = getSession().createQuery(selectHql);

        query.setParameter(0, type);
        String descript = "";
        try
        {
            descript = (String) query.uniqueResult();
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return descript;
    }

    public void del(int id)
    {

        DictBuss dbu = (DictBuss) getHibernateTemplate().get(DictBuss.class, id);
        getHibernateTemplate().delete(dbu);

    }
    
    public DictBuss find(int id)
    {
        return (DictBuss) getHibernateTemplate().get(DictBuss.class, id);
    }

}
