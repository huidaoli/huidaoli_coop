package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Ads;

/**
 * 
 * @author tdy
 * 
 */
public interface AdsMapper {


	Ads getInfoById(int id);
	
	List<Ads> getAllInfo(Map pata);
	
	List<Ads> getAllInfo2(int type);
	
	int getCounts(int type);

	void insert(Ads ads);

	void update(Ads ads);
	
	void delete(int id);
	

}
