package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.BgImg;


/**
 * 
 * @author tdy
 * 
 */
public interface BgimgMapper {


	BgImg getInfoById(int id);
	
	List<BgImg> getAllInfo(Map pata);
	
	List<BgImg> getAllInfo2(int type);
	
	int getCounts(int type);

	void insert(BgImg ads);

	void update(BgImg ads);
	
	void delete(int id);
	
	void usedBgImg(int id);
	
	void usedBgImg2(int type);
	
	String getUsedBgImg(int type);
	

}
