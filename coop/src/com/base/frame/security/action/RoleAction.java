package com.base.frame.security.action;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.common.SystemException;
import com.base.frame.model.Role;
import com.base.frame.security.service.AclService;
import com.base.frame.security.service.RoleService;

/**
 * [¼òÒªÃèÊö]:<br/> 
 * [ÏêÏ¸ÃèÊö]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
@Controller("role")
@Scope("prototype")
public class RoleAction extends BaseAction
{

    /**
     * 
     */
    private static final long serialVersionUID = -8447775974657965697L;

    private Role role;

    private Log logger = LogFactory.getLog(RoleAction.class);

    @Autowired
    private RoleService roleService;
    
    @Autowired
    private AclService aclService;


    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String saveRole()
    {

        String opt = request.getParameter("opt");

        if (opt.equals("add"))
        {
            try
            {
                roleService.addRole(role);
            }
            catch (SystemException e) 
            {
                logger.debug("",e);
            }
        }
        if (opt.equals("edit"))
        {
            try
            {
                roleService.updateRole(role);
            }
            catch (SystemException e)
            {
                logger.debug("",e);
            }
        }

        return success();
    }
    
    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String saveACL()
    {
        String idarr = request.getParameter("ids");
        
        String type = request.getParameter("type");
        
        String roleId = request.getParameter("roleId");
        
        int roleid = Integer.parseInt(roleId);
        
        aclService.deleByPrincipalId(roleid);
        
        aclService.addOrUpdatePermission(idarr, type, roleid);
        
        
        return success();
    }

    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String getRoleInfoList()
    {

        return SUCCESS;
    }

    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String loadRole()
    {

        return SUCCESS;
    }

    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String deleteRoles()
    {

        String idarr = request.getParameter("ids");
        
        roleService.delRole(idarr);
        
              
        return success();
    }

    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String loadRoleInfoById()
    {

        String id = request.getParameter("id");

        String opt = request.getParameter("opt");

        this.role = roleService.findRole(Integer.parseInt(id));

        if (opt.equals("edit"))
        {
            return SUCCESS;
        }
        else
        {
            return "view";
        }

    }

    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String getRoleAjaxData()
    {
        
        response.setHeader("Cache-Control", "no-cache");

        String strpage = request.getParameter("page");

        String strrows = request.getParameter("rows");

        int rows = Integer.parseInt(strrows);

        int offset = (Integer.parseInt(strpage) - 1) * rows;
        
        
        String name = request.getParameter("name");
        
        String jsonData = roleService.searchRoles(name,offset, rows);

       
        return toJsonData(jsonData);
    }
    
    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String getAllRole()
    {
        String jsonData = roleService.getAllRole();

        return toJsonData(jsonData);
    }

    
    
    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

}
