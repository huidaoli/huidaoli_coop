package com.cantodo.content.persistence;


import java.util.List;

import com.cantodo.content.dto.Divproper;

/**
 * 
 * @author tdy
 * 
 */
public interface DivproperMapper {


	void insert(Divproper divproper);
	
	void delete(String imgid);
	
	
	List<Divproper> getDivInfo(String id);
	
}
