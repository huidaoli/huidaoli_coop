package com.base.frame.dao;

import java.util.List;

import com.base.frame.model.Module;

/**
 * [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
public interface ModuleManager
{

    public int addModule(Module module);

    public void delModule(int moduleId);

    public void updateModule(Module org);

    public Module findModule(int moduleId);

    public List<Module> searchModulesData(int parentId);
    
    public List<Module> getAllActions();
}
