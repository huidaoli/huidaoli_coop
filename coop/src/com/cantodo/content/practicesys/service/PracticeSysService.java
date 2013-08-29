package com.cantodo.content.practicesys.service;


import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Divproper;
import com.cantodo.content.dto.PracticeSys;

public interface PracticeSysService {
	
	 @SuppressWarnings("unchecked")
     String getList(Map param);
	 
	 List<PracticeSys> getAllInfo(Map pata);
	 
	 void add(PracticeSys practiceSys);
	 
	 void update(PracticeSys practiceSys);
	 
	 PracticeSys getInfoById(int id);
	 
	 List<Map> getImgsById(int id);
	 
	 void delete(String ids);
	 
	 List<Divproper> getDivInfo(String id);
	 
	 int getCounts2();
	 
}
