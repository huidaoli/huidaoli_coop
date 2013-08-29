package com.base.frame.security.action;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.Organization;
import com.base.frame.security.service.OrgService;

/**
 * [¼òÒªÃèÊö]:<br/>
 * [ÏêÏ¸ÃèÊö]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
@Controller("org")
@Scope("prototype")
public class OrgAction extends BaseAction
{

    /**
     * 
     */
    private static final long serialVersionUID = 5241384377405318246L;

    private Organization org;

    private Log logger = LogFactory.getLog(OrgAction.class);

    @Autowired
    private OrgService orgService;

    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String addOrg()
    {
        //org.setId(0);
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
    public String modOrg()
    {
        String id = request.getParameter("id");

        org = orgService.findOrg(Integer.parseInt(id));
       
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
    public String deleOrg()
    {
        String orgId = request.getParameter("id");

        orgService.delOrg(Integer.parseInt(orgId));
        
              
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
    public String saveOrg()
    {
        
        String opt = request.getParameter("opt");
        
        int id = 0;
        
        if(opt.equals("add"))
        {
            id = orgService.addOrg(org);
        }
        if(opt.equals("mod"))
        {
            id = org.getId();
            orgService.modOrg(org);
        }
        
        try
        {
            response.getWriter().println("{\"id\":"+id+"}");
           
        }
        catch (IOException e)
        {
        }
        
        return null;
    }

    
    /**
     * 
     * [¼òÒªÃèÊö]:<br/>
     * [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String getOrgInfoList()
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
    public String getOrgTreeData()
    {

        response.setHeader("Cache-Control", "no-cache");

        String treeData = orgService.getOrgTreeData(1);

        return toJsonData(treeData);
    }

    public Organization getOrg()
    {
        return org;
    }

    public void setOrg(Organization org)
    {
        this.org = org;
    }

}
