package com.base.frame.common;

import java.util.Map;

import com.base.frame.model.ACL;

/**
 * JSTL��������Ҫ�����ǿ������Ȩ�޵ļ�ʱ��֤
 * @author Administrator
 *
 */
//@Component
public class SecurityFunctions {
    
	
	/**
	ע��service,ע�����@Component
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
