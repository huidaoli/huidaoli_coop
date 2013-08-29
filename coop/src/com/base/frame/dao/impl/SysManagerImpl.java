package com.base.frame.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.base.frame.common.BaseManager;
import com.base.frame.dao.SysManager;
import com.base.frame.model.ACL;
import com.base.frame.model.SysConfig;
import com.base.frame.system.PagerModel;

@Repository
public class SysManagerImpl extends BaseManager implements SysManager
{

    @SuppressWarnings("unchecked")
    @Override
    public PagerModel getList()
    {
        Query query = getSession().createQuery("select sc from SysConfig sc  order by sc.id asc");

        List datas = query.list();

        query = getSession().createQuery("select count(*) from SysConfig sc");

        int total = ((Long) query.uniqueResult()).intValue();

        PagerModel pm = new PagerModel();
        
        pm.setDatas(datas);
        
        pm.setTotal(total);
        
        return pm;
    }

    @Override
    public SysConfig getSysConfigByKeyword(String keyword)
    {
        return (SysConfig)getSession().createQuery(
                "select sc from SysConfig sc where sc.keyword = ? ")
                .setParameter(0, keyword).uniqueResult();
    }

    @Override
    public void save(SysConfig[] sysConfigs)
    {
        
        SysConfig syconfig = null;
        
        for (SysConfig sysconfigtemp : sysConfigs)
        {
            
            syconfig = getHibernateTemplate().load(SysConfig.class, sysconfigtemp.getId());
            
            syconfig.setValue(sysconfigtemp.getValue());
            
            getHibernateTemplate().update(syconfig);
        }
        
        
    }
    
    
    

}
