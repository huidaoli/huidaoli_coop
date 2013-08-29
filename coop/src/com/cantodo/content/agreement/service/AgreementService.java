package com.cantodo.content.agreement.service;


import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Agreement;

public interface AgreementService {
	
	 @SuppressWarnings("unchecked")
     String getList(Map param);
	 
	 List<Agreement> getAllInfo(Map pata);
	 
	 void add(Agreement agreement);
	 
	 void update(Agreement agreement);
	 
	 Agreement getInfoById(int id);
	 
	 void delete(String ids);
	 
	 int getCounts2();

    void stateOpt(String idarr, int state);

    int passAgree(String id);

    int checkState(String id);
	 
}
