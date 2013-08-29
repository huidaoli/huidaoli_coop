package com.base.frame.common;

import java.util.Map;

import com.base.frame.model.ACL;

/**
 * JSTL函数，主要功能是可以完成权限的即时认证
 * @author Administrator
 *
 */
//@Component
public class SecurityFunctions {
    
	
	/**
	注入service,注意加上@Component
	private static AclService aclService;
	
	@Autowired
	public void setAclService(AclService aclService)
	{
	    SecurityFunctions.aclService = aclService;
	}
    */
    public static boolean hasPermission(int buttonId, Map<Integer, ACL> aclMap)
    {

        return aclMap.get(buttonId) == null ? false : true;
    }

	
}
