package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.RandDResult;

/**
 * 
 * @author tdy
 * 
 */
public interface RandDResultMapper {

    RandDResult getInfoById(int id);
	
	List<RandDResult> getAllInfo(Map pata);
	
	int getCounts(Map param);
	
	int getCounts2();

	void insert(RandDResult randDResult);

	void update(RandDResult randDResult);
	
	void delete(int id);
	

}
