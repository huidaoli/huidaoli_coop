package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Atta;

/**
 * 
 * @author tdy
 * 
 */
public interface AttaMapper {


	void insert(Map mappara);
	
	void delete(String id);
	
	void deleteContent(String contentcode);
	
	List getAttaById(String ids);
	
	List<Atta> getAttaByImgId(String imgid);

}
