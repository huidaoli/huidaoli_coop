package com.base.frame.business.service;

import com.base.frame.model.SysConfig;
import com.base.frame.system.PagerModel;



public interface SysService
{

	PagerModel getList();
	
	
    String getJsonData();
    
    SysConfig getSysConfigByKeyword(String keyword);
    
    String getPropertyValueByKeyword(String keyword);
    
    void save(String jsonData);
}


