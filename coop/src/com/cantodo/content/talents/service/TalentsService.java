package com.cantodo.content.talents.service;


import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Talents;

public interface TalentsService {
	
	 @SuppressWarnings("unchecked")
     String getList(Map param);
	 
	 void add(Talents talents);
	 
	 void update(Talents talents);
	 
	 Talents getInfoById(int id);
	 
	 void delete(String ids);
	 
	 List<Talents> getAllList(Map param);
	 
	 int getCounts2();
	 
	 List<Talents> getAllInfo(Map pata);
	 
}

