package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.OpenClass;

/**
 * 
 * @author tdy
 * 
 */
public interface OpenClassMapper {

	OpenClass getOpenClassById(int id);
	
	List<OpenClass> getAllOpenClass(Map pata);
	
	int getCounts(Map param);

	void insert(OpenClass openClass);

	void update(OpenClass openClass);
	
	void delete(int id);
	
	List<Map<String,Object>> getClassList(Map conditionMap);
	
	int getCounts2();

}
