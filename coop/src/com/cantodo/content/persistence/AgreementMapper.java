package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Agreement;
import com.cantodo.content.dto.AgreementItem;

/**
 * 
 * @author tdy
 * 
 */
public interface AgreementMapper {


    Agreement getInfoById(int id);
	
	List<Agreement> getAllInfo(Map pata);
	
	int getCounts(Map pata);
	
	void insertAgreement(Agreement agreement);

	void insertAItem(List<AgreementItem> list);

	void update(Agreement agreement);
	
	void delete(int id);
	
	void deleteAItem(String pcode);
	
	void deleteAExt(String code);
	
	void updateAExt(Map param);
	
	int getCounts2();

	void insertAExt(List<String[]> ext);

	List<Map<String,String>> getExtInfoById(String code);

	List<Map<String,String>> getItemListById(String code);

    void stateOpt(Map cmap);

    void passAgree(Map cmap);
    
    int getstate(int id);

}
