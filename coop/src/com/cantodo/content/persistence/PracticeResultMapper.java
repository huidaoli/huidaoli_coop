package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.PracticeResult;

/**
 * 
 * @author tdy
 * 
 */
public interface PracticeResultMapper {

    PracticeResult getInfoById(int id);
	
	List<PracticeResult> getAllInfo(Map pata);
	
	int getCounts(Map param);
	
	int getCounts2();

	void insert(PracticeResult practiceResult);

	void update(PracticeResult practiceResult);
	
	void delete(int id);
	

}
