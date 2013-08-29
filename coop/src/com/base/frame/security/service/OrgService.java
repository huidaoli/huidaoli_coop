package com.base.frame.security.service;

import com.base.frame.model.Organization;

public interface OrgService {
	
	int addOrg(Organization org);
	
	void modOrg(Organization org);
	
	Organization findOrg(int orgId);
	
	String getOrgTreeData(int oid);
	
	void delOrg(int orgId);

}
