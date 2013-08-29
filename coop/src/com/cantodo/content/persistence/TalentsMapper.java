package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Talents;

/**
 * 
 * @author tdy
 * 
 */
public interface TalentsMapper {

	Talents getInfoById(int id);
	
	List<Talents> getAllInfo(Map pata);
	
	int getCounts(Map param);

	void insert(Talents talents);

	void update(Talents talents);
	
	void delete(int id);
	
	int getCounts2();
	

}
