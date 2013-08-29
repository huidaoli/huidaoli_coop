package com.cantodo.content.randdsys.service;


import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Divproper;
import com.cantodo.content.dto.RandDSys;

public interface RandDSysService {
	
	 @SuppressWarnings("unchecked")
     String getList(Map param);
	 
	 List<RandDSys> getAllInfo(Map pata);
	 
	 void add(RandDSys randDSys);
	 
	 void update(RandDSys randDSys);
	 
	 RandDSys getInfoById(int id);
	 
	 List<Map> getImgsById(int id);
	 
	 void delete(String ids);
	 
	 List<Divproper> getDivInfo(String id);
	 
	 int getCounts2();
	 
}
