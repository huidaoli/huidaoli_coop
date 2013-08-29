package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.TrainingResult;

/**
 * 
 * @author tdy
 * 
 */
public interface TrainingResultMapper {

	TrainingResult getInfoById(int id);
	
	List<TrainingResult> getAllInfo(Map pata);
	
	int getCounts(Map param);
	
	int getCounts2();

	void insert(TrainingResult trainingresult);

	void update(TrainingResult trainingsys);
	
	void delete(int id);
	

}
