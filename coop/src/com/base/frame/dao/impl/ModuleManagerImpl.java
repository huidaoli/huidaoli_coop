package com.base.frame.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.base.frame.common.BaseManager;
import com.base.frame.dao.ModuleManager;
import com.base.frame.model.Module;

/**
 * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
@Repository("moduledao")
public class ModuleManagerImpl extends BaseManager implements ModuleManager
{

    public int addModule(Module module) throws DataAccessException
    {

        if (module.getParent().getId() == 0)
        {
            module.setParent(findModule(module.getParent().getId()));
        }

        getHibernateTemplate().save(module);
        
        return module.getId();

    }

    public void delModule(int moduleId) throws DataAccessException
    {
        Module org = (Module) findModule(moduleId);
        getHibernateTemplate().delete(org);
    }

    public Module findModule(int moduleId) throws DataAccessException
    {
        return (Module) getHibernateTemplate().get(Module.class, moduleId);
    }

    @SuppressWarnings("unchecked")
    public List searchModulesData(int parentId) throws DataAccessException
    {

        String selectHql = "select m from Module m where m.parent is null";
        if (parentId != 0)
        {
            selectHql = "select m from Module m where m.parent.id = " + parentId + " order by m.id asc,m.orderNo desc";
        }

        return searchPaginatedData(selectHql);
    }

    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @param module
     * @throws DataAccessException
     * @exception 
     * @see com.base.frame.dao.ModuleManager#updateModule(com.base.frame.model.Module)
     */
    public void updateModule(Module module) throws DataAccessException
    {
        int parentId = module.getParent().getId();
        if (parentId == 0)
        {
            module.setParent(null);
        }
        getHibernateTemplate().update(module);
    }
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     * @throws RuntimeException
     */
    @SuppressWarnings("unchecked")
    public List<Module> getAllActions() throws RuntimeException
    {
        Query query = getSession().createQuery("select m from Module m where m.url is not null order by id desc");
        List datas = query.list();
        return datas;
    }

}
