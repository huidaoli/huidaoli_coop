package com.cantodo.content.practiceresult.service;


import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.PracticeResult;

public interface PracticeResultService {
	
	 @SuppressWarnings("unchecked")
     String getList(Map param);
	 
	 List<PracticeResult> getAllInfo(Map pata);
	 
	 void add(PracticeResult practiceResult);
	 
	 void update(PracticeResult practiceResult);
	 
	 PracticeResult getInfoById(int id);
	 
	 void delete(String ids);
	 
	 int getCounts2();
	 
}
