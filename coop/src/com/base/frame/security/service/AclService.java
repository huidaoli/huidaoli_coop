package com.base.frame.security.service;

import java.util.List;
import java.util.Map;

import com.base.frame.model.ACL;
import com.base.frame.model.Menu;
import com.base.frame.model.Module;

/**
 * 
 * [ºÚ“™√Ë ˆ]:<br/>
 * [œÍœ∏√Ë ˆ]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 28, 2011
 */
public interface AclService
{

    void addOrUpdatePermission(String idarr, String type, int roleId);
    
    String searchAclRecord(String principalType, int principalId);

    void deleByPrincipalId(int principalId);
    
    List<ACL> searchAclsRecord(String principalType, int principalId);

    List<Module> searchModulesData(int parentId,Map<Integer, ACL> aclMap);
    
    String searchModules(Map<Integer, ACL> map, int mid);

    boolean hasPermissionByResourceSn(int userId, String resourceSn, int permission);
    
    Map<Integer, ACL> getAclMap(int userId);
}
