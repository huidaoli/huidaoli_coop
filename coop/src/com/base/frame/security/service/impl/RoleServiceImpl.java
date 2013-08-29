package com.base.frame.security.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.base.frame.common.SystemException;
import com.base.frame.dao.RoleManager;
import com.base.frame.model.Role;
import com.base.frame.security.service.RoleService;
import com.base.frame.system.PagerModel;

/**
 * [ºÚ“™√Ë ˆ]:<br/> 
 * [œÍœ∏√Ë ˆ]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
@Service
public class RoleServiceImpl implements RoleService
{

    private Log logger = LogFactory.getLog(RoleServiceImpl.class);

    @Autowired
    private RoleManager roleManager;

    @Override
    @Transactional
    public void addRole(Role role)
    {
        try
        {
            roleManager.addRole(role);
        }
        catch (RuntimeException e)
        {
            logger.debug("role:"+ToStringBuilder.reflectionToString(role, ToStringStyle.MULTI_LINE_STYLE),e);
            throw new SystemException("addRole error",e);
        }

    }

    @Override
    public void delRole(int roleId)
    {
        roleManager.delRole(roleId);

    }

    /**
     * [ºÚ“™√Ë ˆ]:<br/> [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @param strids
     * @exception
     * @see com.base.frame.security.service.RoleService#delRole(java.lang.String)
     */
    @Override
    @Transactional
    public void delRole(String strids)
    {

        
        JSONArray jsonArray = JSONArray.fromObject(strids);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        for (int id : ids)
        {
            delRole(id);
        }

    }

    @Override
    public Role findRole(int roleId)
    {
        return roleManager.findRole(roleId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String searchRoles(Object param,int offset, int pagesize)
    {

        Map result = new HashMap();
        PagerModel pm = roleManager.searchRoles(param ,offset, pagesize);
        List datas = pm.getDatas();
        int totals = pm.getTotal();
        result.put("total", totals);
        result.put("rows", datas);
        return JSONObject.fromObject(result).toString();

    }
    
    @Override
    @SuppressWarnings("unchecked")
    public String getAllRole()
    {
        List datas = roleManager.getAllRole();   
        return JSONArray.fromObject(datas).toString();
    }

    @Override
    @Transactional
    public void updateRole(Role role)
    {
        roleManager.updateRole(role);

    }

}
