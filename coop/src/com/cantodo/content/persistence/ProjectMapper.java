package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Project;

/**
 * 
 * @author tdy
 * 
 */
public interface ProjectMapper {

    Project getProjectById(int id);
	
	List<Project> getAllProject(Map pata);
	
	int getCounts(Map param);
	
	int getCounts2(String ctype);
	
	List<Map<String,Object>> getProjectList(Map conditionMap);

	void insert(Project project);

	void update(Project project);
	
	void delete(int id);
	
	void addBatch(Map<String,List <Map<String,String>>> projects);
	
	int checkProjectNo(String no);

}
