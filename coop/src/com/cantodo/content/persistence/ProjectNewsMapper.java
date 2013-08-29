package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.ProjectNews;
import com.cantodo.content.dto.Talents;

/**
 * 
 * @author tdy
 * 
 */
public interface ProjectNewsMapper {

	ProjectNews getInfoById(int id);
	
	List<ProjectNews> getAllInfo(Map pata);
	
	int getCounts(Map param);

	void insert(ProjectNews projectNews);

	void update(ProjectNews projectNews);
	
	void delete(int id);
	
	int getCounts2();
	

}
