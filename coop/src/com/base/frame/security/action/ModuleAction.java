package com.base.frame.security.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.ACL;
import com.base.frame.model.DictBuss;
import com.base.frame.model.Module;
import com.base.frame.security.service.AclService;
import com.base.frame.security.service.DictBussService;
import com.base.frame.security.service.ModuleService;

/**
 * [ºÚ“™√Ë ˆ]:<br/>
 * [œÍœ∏√Ë ˆ]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
@Controller("module")
@Scope("prototype")
public class ModuleAction extends BaseAction
{

    /**
     * [ºÚ“™√Ë ˆ]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = -8445218813956893133L;

    private Module module;

    private Log logger = LogFactory.getLog(ModuleAction.class);

    @Autowired
    private ModuleService moduleService;
    
    @Autowired
    private DictBussService dictBussService;
    
    @Autowired
    private AclService aclService;
    
    
    private List<DictBuss> listDictBuss;
    
    
    public List<DictBuss> getListDictBuss()
    {
        return listDictBuss;
    }


    public void setListDictBuss(List<DictBuss> listDictBuss)
    {
        this.listDictBuss = listDictBuss;
    }

    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String addModule()
    {
        //org.setId(0);
        request.setAttribute("opt", "add");
        listDictBuss = dictBussService.listDictBuss(2);
        return SUCCESS;
    }
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String modModule()
    {
        request.setAttribute("opt", "mod");
        
        String id = request.getParameter("id");
        
        listDictBuss = dictBussService.listDictBuss(2);

        module = moduleService.findModule(Integer.parseInt(id));
        
        return SUCCESS;
    }
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String deleModule()
    {
        String moduleId = request.getParameter("id");

        moduleService.delModule(Integer.parseInt(moduleId));
        
                
        return success();
    }

    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String saveModule()
    {
        
        String opt = request.getParameter("opt");
        
        int id = 0;
        
        if(opt.equals("add"))
        {
            id = moduleService.addModule(module);
        }
        if(opt.equals("mod"))
        {
            id = module.getId();
            try
            {
                moduleService.modModule(module);
            }
            catch (DataAccessException e)
            {
                logger.error("DataAccessException", e);
            }
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
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    @SuppressWarnings("unchecked")
    public String getModuleInfoList()
    {
        String opt = request.getParameter("opt");
        
        if(null!=opt && StringUtils.isNotBlank(opt) && opt.equals("selectModule"))
        {
            String roleId = request.getParameter("roleId");
            
            int roleid = Integer.parseInt(roleId);
            
            String result = aclService.searchAclRecord(ACL.TYPE_ROLE, roleid);
            
            request.setAttribute("result", result);
            
            return "selectModule";
        }
        return SUCCESS;
    }

    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String getModuleTreeData()
    {

        response.setHeader("Cache-Control", "no-cache");

        String treeData = moduleService.getModuleTreeData(1);

        return toJsonData(treeData);

    }

    public Module getModule()
    {
        return module;
    }

    public void setModule(Module module)
    {
        this.module = module;
    }


}
