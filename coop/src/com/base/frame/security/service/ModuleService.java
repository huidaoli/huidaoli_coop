package com.base.frame.security.service;

import java.util.List;

import com.base.frame.model.Module;

public interface ModuleService {
	
	int addModule(Module module);
	
	void modModule(Module module);
	
	Module findModule(int moduleId);
	
	String getModuleTreeData(int oid);
	
	void delModule(int moduleId);
	
	List<Module> searchModulesData(int parentId);
	
	public List<Module> getAllActions();

}
