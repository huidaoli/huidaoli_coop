package com.cantodo.content.randdresult.service;


import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.RandDResult;

public interface RandDResultService {
	
	 @SuppressWarnings("unchecked")
     String getList(Map param);
	 
	 List<RandDResult> getAllInfo(Map pata);
	 
	 void add(RandDResult randDResult);
	 
	 void update(RandDResult randDResult);
	 
	 RandDResult getInfoById(int id);
	 
	 void delete(String ids);
	 
	 int getCounts2();
	 
}
