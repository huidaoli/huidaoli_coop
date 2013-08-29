package com.cantodo.content.projectnews.service;


import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.News;
import com.cantodo.content.dto.ProjectNews;

public interface ProjectNewsService {
	
	 @SuppressWarnings("unchecked")
     String getList(Map param);
	 
	 void add(ProjectNews projectNews);
	 
	 void update(ProjectNews projectNews);
	 
	 ProjectNews getInfoById(int id);
	 
	 void delete(String ids);
	 
	 List<ProjectNews> getAllList(Map param);
	 
	 int getCounts2();
	 
	 List<ProjectNews> getAllInfo(Map pata);
	 
}
