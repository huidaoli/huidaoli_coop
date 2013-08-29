package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Resource;

/**
 * 
 * @author tdy
 * 
 */
public interface ResourceMapper {

    Resource getInfoById(Map map);
	
	List<Resource> getAllInfo(Map pata);
	
	List<Resource> getAllInfoSearch(Map pata);
	
	int getCounts(Map param);
	
	int getCounts2(String cctype);
	
	int getCounts3(String name);

	void insert(Resource resource);

	void update(Resource resource);
	
	void delete(int id);
	

}
