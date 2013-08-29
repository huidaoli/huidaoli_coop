package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.PracticeSys;

/**
 * 
 * @author tdy
 * 
 */
public interface PracticeSysMapper {

    PracticeSys getInfoById(int id);
	
	List<PracticeSys> getAllInfo(Map pata);
	
	List<Map> getImgsById(int id);
	
	int getCounts(Map param);
	
	int getCounts2();

	void insert(PracticeSys practiceSys);

	void update(PracticeSys practiceSys);
	
	void delete(int id);
	

}
