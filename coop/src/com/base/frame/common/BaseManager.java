package com.base.frame.common;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.base.frame.system.PagerModel;
import com.base.frame.system.SystemContext;

/**
 * [简要描述]:<br/> 
 * [详细描述]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
@Component("baseManager")
public class BaseManager extends HibernateDaoSupport
{

    @Resource
    public void setSuperSessionFactory(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }

    public PagerModel searchPaginated(String hql)
    {
        return searchPaginated(hql, null);
    }

    public PagerModel searchPaginated(String hql, Object param)
    {
        return searchPaginated(hql, new Object[] {param});
    }

    public PagerModel searchPaginated(String hql, Object[] params)
    {
        return searchPaginated(hql, params, SystemContext.getOffset(), SystemContext.getPagesize());
    }

    public PagerModel searchPaginated(String hql, int offset, int pagesize)
    {
        return searchPaginated(hql, null, offset, pagesize);
    }

    public PagerModel searchPaginated(String hql, Object param, int offset, int pagesize)
    {
        return searchPaginated(hql, new Object[] {param}, offset, pagesize);
    }

    /**
     * 
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param hql
     * @param params
     * @param offset
     * @param pagesize
     * @return
     */
    @SuppressWarnings("unchecked")
    public PagerModel searchPaginated(String hql, Object[] params, int offset, int pagesize)
    {
        // 获取记录总数
        String countHql = getCountQuery(hql);
        Query query = getSession().createQuery(countHql);
        if (params != null && params.length > 0)
        {
            for (int i = 0; i < params.length; i++)
            {
                query.setParameter(i, params[i]);
            }
        }
        int total = ((Long) query.uniqueResult()).intValue();

        // 获取结果集
        query = getSession().createQuery(hql);
        if (params != null && params.length > 0)
        {
            for (int i = 0; i < params.length; i++)
            {
                query.setParameter(i, params[i]);
            }
        }
        query.setFirstResult(offset);
        query.setMaxResults(pagesize);
        List datas = query.list();

        // 返回PagerModel
        PagerModel pm = new PagerModel();
        pm.setDatas(datas);
        pm.setTotal(total);
        return pm;
    }

    @SuppressWarnings("unchecked")
    public List searchPaginatedData(String hql)
    {
        Query query = getSession().createQuery(hql);
        
        return query.list();
    }

    /**
     * 根据HQL语句，获得查询总记录数的HQL语句 如： select ... from Organization o where o.parent
     * is null 经过转换，可以得到： select count(*) from Organziation o where o.parent
     * is null
     * 
     * @param hql
     * @return
     */
    private String getCountQuery(String hql)
    {
        int index = hql.indexOf("from");
        if (index != -1)
        {
            return "select count(*) " + hql.substring(index);
        }
        return "";
    }

}
