package com.base.frame.dao;

import com.base.frame.model.SysConfig;
import com.base.frame.system.PagerModel;

/**
 * [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
public interface SysManager
{

    PagerModel getList();
    
    
    SysConfig getSysConfigByKeyword(String keyword);
    
    
    void save(SysConfig[] sysConfigs);
}
