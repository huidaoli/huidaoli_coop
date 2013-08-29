package com.cantodo.content.information.service;


import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Information;

public interface InformationService {
	
	 @SuppressWarnings("unchecked")
     String getList(Map param,String type);
	 
	 List<Information> getAllInfo(Map pata);
	 
	 List<Information> getAllInfoSearch(Map pata);
	 
	 void add(Information information);
	 
	 void update(Information information);
	 
	 Information getInfoById(Map param);
	 
	 void delete(String ids);
	 
	 int getCounts2(String cctype);
	 
	 int getCounts3(String name);
	 
}
