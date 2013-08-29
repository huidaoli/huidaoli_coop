package com.cantodo.content.resource.service;


import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Resource;

public interface ResourceService {
	
	 @SuppressWarnings("unchecked")
     String getList(Map param,String type);
	 
	 List<Resource> getAllInfo(Map pata);
	 
	 List<Resource> getAllInfoSearch(Map pata);
	 
	 void add(Resource resource);
	 
	 void update(Resource resource);
	 
	 Resource getInfoById(Map param);
	 
	 void delete(String ids);
	 
	 int getCounts2(String cctype);
	 
	 int getCounts3(String name);
	 
}
