package com.cantodo.content.openclass.service;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.OpenClass;

public interface OpenClassService {
	
	 String searchClassInfos(Map param);
	 
	 
	 void addOpenClass(OpenClass openClass);
	 
	 void updateOpenClass(OpenClass openClass);
	 
	 OpenClass findOpenClass(int id);
	 
	 void deleteOpenClasss(String id);
	 
	 List<OpenClass> getAllList(Map param);
	 
	 int getCounts2();
	 
	 List<Map<String,Object>> getClassList(Map conditionMap);
	 
	 void saveState(Map para);
	 
	 List<OpenClass> getAllInfo(Map pata);

}
