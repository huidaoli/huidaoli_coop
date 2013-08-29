package com.base.frame.security.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.base.frame.common.SystemException;
import com.base.frame.dao.AclManager;
import com.base.frame.dao.ModuleManager;
import com.base.frame.dao.UserInfoManager;
import com.base.frame.model.ACL;
import com.base.frame.model.Module;
import com.base.frame.model.Role;
import com.base.frame.security.service.AclService;

/**
 * [简要描述]:<br/> [详细描述]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 28, 2011
 */
@Service("aclImplService")
public class AclImplService implements AclService
{
    
    private Log logger = LogFactory.getLog(AclImplService.class);

    @Autowired
    private AclManager aclManager;

    @Autowired
    private ModuleManager moduleManager;

    @Autowired
    private UserInfoManager userInfoManager;

    @Override
    @Transactional
    public void addOrUpdatePermission(String idarr, String type, int roleId)
    {
        JSONArray jsonArray = JSONArray.fromObject(idarr);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        for (int id : ids)
        {
            aclManager.addOrUpdatePermission(type, roleId, id);
        }
    }

    /**
     * [简要描述]:<br/> [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param principalType
     * @param principalId
     * @return
     * @exception
     * @see com.base.frame.security.service.AclService#searchAclRecord(java.lang.String,
     *      int)
     */
    @SuppressWarnings("unchecked")
    public String searchAclRecord(String principalType, int principalId)
    {
        List<ACL> lists = null;
        try
        {
            lists = aclManager.searchAclRecord(principalType, principalId);
        }
        catch (DataAccessException e)
        {
            logger.error("searchAclRecord error", e);
            throw new SystemException("searchAclRecord error",e);
        }
        Set<Integer> lb = new HashSet<Integer>();

        Module module = null;

        for (ACL acl : lists)
        {
            int moduleId = acl.getModuleId();

            module = moduleManager.findModule(moduleId);
            
            if(null == module) 
            {
                continue;
            }

            if (module.getModuleType() == 1)
            {
                lb.add(moduleId);
            }
            else
            {
                if (null == module.getChildren() || module.getChildren().size() == 0)
                {
                    lb.add(moduleId);
                }
            }
        }

        String temp = StringUtils.join(lb, ",");
        return "[" + temp + "]";
    }

    /**
     * [简要描述]:<br/> [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param principalType
     * @param principalId
     * @return
     * @exception
     * @see com.base.frame.security.service.AclService#searchAclsRecord(java.lang.String,
     *      int)
     */
    public List<ACL> searchAclsRecord(String principalType, int principalId)
    {
        return aclManager.searchAclRecord(principalType, principalId);
    }

    /**
     * [简要描述]:<br/> [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param principalId
     * @exception
     * @see com.base.frame.security.service.AclService#deleByPrincipalId(int)
     */
    @SuppressWarnings("unchecked")
    @Transactional
    public void deleByPrincipalId(int principalId)
    {
        List<ACL> lists = aclManager.getModulesByPrincipalId(principalId);
        if (null != lists && lists.size() > 0)
        {
            for (ACL acl : lists)
            {
                aclManager.delACL(acl);
            }
        }
    }

    /**
     * [简要描述]:<br/> [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param id
     * @return
     * @exception
     * @see com.base.frame.security.service.AclService#searchModules(int)
     */
    public String searchModules(Map<Integer, ACL> aclMap, int mid)
    {
        String result = "";

        if (null != aclMap.get(mid))
        {
            result = getModuleTreeData(mid, aclMap);
        }

        return result;
    }

    /**
     * 
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param parentId
     * @param userId
     * @return
     * @exception 
     * @see com.base.frame.security.service.AclService#searchModulesData(int, int)
     */
    public List<Module> searchModulesData(int parentId,Map<Integer, ACL> aclMap)
    {
        // 查找用户拥有的角色，并按优先级从低到高排序
        
        List<Module> resLists = new ArrayList<Module>();

        // 依次查找角色的授权（ACL对象）
        List<Module> modules =  moduleManager.searchModulesData(parentId);
        
        for(Module m : modules)
        {
            if(null!=aclMap.get(m.getId()))
            {
                resLists.add(m);
            }
        }
        
        return resLists;
    }
    
    
    /**
     * 
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param userId
     * @return
     */
    public Map<Integer, ACL> getAclMap(int userId)
    {
        List<Role> roles = userInfoManager.getRolesByUserId(userId);
        
        Map<Integer, ACL> tempMap = new HashMap<Integer, ACL>();

        List<ACL> acls = null;

        // 依次查找角色的授权（ACL对象）
        for (Role r : roles)
        {
            acls = aclManager.searchAclRecord(ACL.TYPE_ROLE, r.getId());
            for (ACL acl : acls)
            {
                tempMap.put(acl.getModuleId(), acl);
            }
        }
        
        return tempMap;
    }

    /**
     * 
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param id
     * @param tempMap
     * @return
     */
    private String getModuleTreeData(int id, Map<Integer, ACL> tempMap)
    {

        StringBuilder sb = new StringBuilder();

        Module module = moduleManager.findModule(id);

        // 子节点Set
        getJsonData(module, sb, tempMap);

        String r = ("[" + sb.toString() + "]").replaceAll("\\,]", "\\]");

        //System.out.println(r);
        
        return r;

    }

    /**
     * [简要描述]:<br/> [详细描述]:<br/>
     * 
     * @author tangdingyi
     * @param module
     * @param sb
     */
    private void getJsonData(Module module, StringBuilder sb, Map<Integer, ACL> tempMap)
    {
        Set<Module> modules = module.getChildren();
        if (checkChild(modules, tempMap))
        {
            sb.append("{\"id\":");
            sb.append(module.getId());
            sb.append(",\"text\":");
            sb.append("\"" + module.getName() + "\"");
            sb.append(",\"children\":[");
            for (Module orgtmp : modules)
            {
                getJsonData(orgtmp, sb, tempMap);

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
     * [简要描述]:<br/> [详细描述]:<br/>判断是否有子节点
     * 
     * @author tangdingyi
     * @param orgs
     * @return
     */
    private boolean checkChild(Set<Module> modules, Map<Integer, ACL> tempMap)
    {
        //LinkedHashSet 有序
        Set<Module> modulesTemp = new LinkedHashSet<Module>(); 
        for (Module moduletmp : modules)
        {
            if (null != tempMap.get(moduletmp.getId()) && moduletmp.getModuleType() == 0)
            {
                modulesTemp.add(moduletmp);
            }
        }
        modules.clear();
        modules.addAll(modulesTemp);
        return modules.size() > 0 ? true : false;

    }

    @Override
    public boolean hasPermissionByResourceSn(int userId, String resourceSn, int permission)
    {
        // TODO Auto-generated method stub
        return false;
    }

}
