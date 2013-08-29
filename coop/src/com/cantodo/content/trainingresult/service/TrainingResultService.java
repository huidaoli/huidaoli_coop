package com.cantodo.content.trainingresult.service;


import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.TrainingResult;

public interface TrainingResultService {
	
	 @SuppressWarnings("unchecked")
     String getList(Map param);
	 
	 List<TrainingResult> getAllInfo(Map pata);
	 
	 void add(TrainingResult trainingResult);
	 
	 void update(TrainingResult trainingResult);
	 
	 TrainingResult getInfoById(int id);
	 
	 void delete(String ids);
	 
	 int getCounts2();
	 
}
