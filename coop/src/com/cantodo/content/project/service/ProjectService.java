package com.cantodo.content.project.service;


import java.io.File;
import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Project;

public interface ProjectService {
	
	 @SuppressWarnings("unchecked")
     String getList(Map param);
	 
	 void add(Project project);
	 
	 void update(Project project);
	 
	 Project getInfoById(int id);
	 
	 void delete(String ids);
	 
	 void readExcel(File file,String type);
	 
	 int getCounts2(String ctype);
	 
	 void addBatch(Map<String,List <Map<String,String>>> projects);
	 
	 List<Map<String,Object>> getProjectList(Map conditionMap);
	 
	 void saveState(Map para);
	 
	 boolean checkProjectNo(String no);

}
