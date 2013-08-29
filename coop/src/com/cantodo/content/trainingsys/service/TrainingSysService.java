package com.cantodo.content.trainingsys.service;


import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Atta;
import com.cantodo.content.dto.Divproper;
import com.cantodo.content.dto.TrainingSys;

public interface TrainingSysService {
	
	 @SuppressWarnings("unchecked")
     String getList(Map param);
	 
	 List<TrainingSys> getAllInfo(Map pata);
	 
	 void add(TrainingSys trainingSys);
	 
	 void update(TrainingSys trainingSys);
	 
	 TrainingSys getInfoById(int id);
	 
	 List<Map> getImgsById(int id);
	 
	 void delete(String ids);
	 
	 int getCounts2();
	 
	 void insert(Divproper divproper);
	 
	 List<Divproper> getDivInfo(String id);
	 
	 List<Atta> getAttaByImgId(String imgid);
	 
	 void deleteImg(String ids);
	 
}
