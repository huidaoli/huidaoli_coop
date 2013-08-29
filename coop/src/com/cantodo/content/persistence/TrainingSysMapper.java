package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.TrainingSys;

/**
 * 
 * @author tdy
 * 
 */
public interface TrainingSysMapper {

	TrainingSys getInfoById(int id);
	
	List<TrainingSys> getAllInfo(Map pata);
	
	List<Map> getImgsById(int id);
	
	int getCounts(Map param);
	
	int getCounts2();

	void insert(TrainingSys trainingSys);

	void update(TrainingSys trainingSys);
	
	void delete(int id);
	

}
