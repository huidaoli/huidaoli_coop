package com.base.frame.security.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.frame.dao.ModuleManager;
import com.base.frame.model.Menu;
import com.base.frame.model.Module;
import com.base.frame.security.service.ModuleService;

@Service("moduleServiceImpl")
public class ModuleServiceImpl implements ModuleService
{
    
    private Log logger = LogFactory.getLog(ModuleServiceImpl.class);

    @Autowired
    private ModuleManager moduleManager;

    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @param module
     * @throws DataAccessException
     * @exception 
     * @see com.base.frame.security.service.ModuleService#addModule(com.base.frame.model.Module)
     */
    @Transactional
    public int addModule(Module module) throws DataAccessException
    {

       return moduleManager.addModule(module);

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
     * @see com.base.frame.security.service.ModuleService#modModule(com.base.frame.model.Module)
     */
    @Transactional
    public void modModule(Module module) throws DataAccessException
    {
        moduleManager.updateModule(module);

    }

    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @param moduleId
     * @return
     * @throws DataAccessException
     * @exception 
     * @see com.base.frame.security.service.ModuleService#findModule(int)
     */
    public Module findModule(int moduleId) throws DataAccessException
    {
        return moduleManager.findModule(moduleId);
    }

    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @param moduleId
     * @throws DataAccessException
     * @exception 
     * @see com.base.frame.security.service.ModuleService#delModule(int)
     */
    @Transactional
    public void delModule(int moduleId) throws DataAccessException
    {
        moduleManager.delModule(moduleId);
    }
    
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @param parentId
     * @return
     * @exception 
     * @see com.base.frame.security.service.ModuleService#searchModulesData(int)
     */
    public List<Module> searchModulesData(int parentId)
    {
        return moduleManager.searchModulesData(parentId);
    }

   /**
    * 
    * [ºÚ“™√Ë ˆ]:<br/>
    * [œÍœ∏√Ë ˆ]:<br/>
    * 
    * @author tangdingyi
    * @param module
    * @param sb
    */
    private void getJsonData(Module module, StringBuilder sb)
    {
        Set<Module> modules = module.getChildren();
        if (hasChild(modules))
        {
            sb.append("{\"id\":");
            sb.append(module.getId());
            sb.append(",\"text\":");
            sb.append("\"" + module.getName() + "\"");
            sb.append(",\"children\":[");
            for (Module orgtmp : modules)
            {
                getJsonData(orgtmp, sb);
            }
            sb.append("]},");
        }
        else
        {
            sb.append("{\"id\":");
            sb.append(module.getId());
            sb.append(",\"text\":");
            sb.append("\"" + module.getName() + "\"");
            sb.append("},");
        }

    }

    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>// ≈–∂œ «∑Ò”–◊”Ω⁄µ„
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @param orgs
     * @return
     */
    
    private boolean hasChild(Set<Module> orgs)
    {

        return orgs.size() > 0 ? true : false;

    }

    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @param id
     * @return
     * @exception 
     * @see com.base.frame.security.service.ModuleService#getModuleTreeData(int)
     */
    public String getModuleTreeData(int id)
    {

        StringBuilder sb = new StringBuilder();

        Module module = moduleManager.findModule(id);
        // ◊”Ω⁄µ„Set
        getJsonData(module, sb);

        String r = ("[" + sb.toString() + "]").replaceAll("\\,]", "\\]");

        // System.out.println(r);

        return r;

    }
    
    /**
     * 
     * [ºÚ“™√Ë ˆ]:<br/>
     * [œÍœ∏√Ë ˆ]:<br/>
     * 
     * @author tangdingyi
     * @return
     * @exception 
     * @see com.base.frame.security.service.ModuleService#getAllActions()
     */
    public List<Module> getAllActions() 
    {
        return moduleManager.getAllActions();
    }

}
