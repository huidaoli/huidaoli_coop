package com.base.frame.dao;

import java.util.List;

import com.base.frame.model.ACL;

public interface AclManager
{

    /**
     * 添加或更新授权
     * 
     * @param principalType 主体类型标识：如角色或用户
     * @param principalId 主体标识
     * @param moduleId 模块标识
     * @param permission 操作标识（C/R/U/D）
     * @param yes 是否允许
     */
    public void addOrUpdatePermission(String principalType, int principalId, int moduleId);
    
    public List getModulesByPrincipalId(int principalId);
    
    public void delACL(ACL acl);

    /**
     * 删除授权
     * 
     * @param principalType
     * @param principalId
     * @param moduleId
     */
    public void delPermission(String principalType, int principalId, int moduleId);

    /**
     * 设置aclTriState的值
     * 
     * @param userId 用户标识
     * @param moduleId 模块标识
     * @param yes 是否有效
     */
    public void addOrUpdateUserExtends(int userId, int moduleId, boolean yes);

    /**
     * 即时认证，判断某个用户是否拥有对某个模块的某个操作的权限
     * 
     * @param userId 用户标识
     * @param moduleId 模块标识
     * @param permission 操作标识（C/R/U/D）
     * @return 允许或不允许
     */
    public boolean hasPermission(int userId, int moduleId, int permission);

    /**
     * 判断用户对某模块的某操作的授权（允许或不允许）
     * 
     * @param userId 用户ID
     * @param reourceSn 资源唯一标识（sn）
     * @param permission 权限（C/R/U/D）
     * @return 允许（true）或不允许（false）
     */
    public boolean hasPermissionByResourceSn(int userId, String reourceSn, int permission);

    /**
     * 查询用户拥有读取权限的模块列表
     * 
     * @param userId 用户标识
     * @return 列表元素是Module对象
     */
    public List searchModules(int userId);

    public List searchAclRecord(String principalType, int principalId);
}
