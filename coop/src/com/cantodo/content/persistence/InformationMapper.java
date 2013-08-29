package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Information;

/**
 * 
 * @author tdy
 * 
 */
public interface InformationMapper {

	Information getInfoById(Map map);
	
	List<Information> getAllInfo(Map pata);
	
	List<Information> getAllInfoSearch(Map pata);
	
	int getCounts(Map param);
	
	int getCounts2(String cctype);
	
	int getCounts3(String name);

	void insert(Information information);

	void update(Information information);
	
	void delete(int id);
	

}
