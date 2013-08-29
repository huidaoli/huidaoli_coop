package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.RandDSys;

/**
 * 
 * @author tdy
 * 
 */
public interface RandDSysMapper {

    RandDSys getInfoById(int id);
	
	List<RandDSys> getAllInfo(Map pata);
	
	List<Map> getImgsById(int id);
	
	int getCounts(Map param);
	
	int getCounts2();

	void insert(RandDSys randDSys);

	void update(RandDSys randDSys);
	
	void delete(int id);
	

}
