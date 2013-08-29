package com.cantodo.content.scrollinfo.service;


import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Scrollinfo;

public interface ScrollinfoService {
	
	 @SuppressWarnings("unchecked")
     String getList(Map param,String type);
	 
	 List<Scrollinfo> getAllInfo(Map pata);
	 
	 List<Scrollinfo> getAllInfoSearch(String type);
	 
	 void add(Scrollinfo scrollinfo);
	 
	 void update(Scrollinfo scrollinfo);
	 
	 Scrollinfo getInfoById(Map param);
	 
	 void delete(String ids);
	 
	 int getCounts2(String cctype);
	 
	 int getCounts3(String name);
	 
}
