package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.ProPic;
import com.cantodo.content.dto.Product;

/**
 * 
 * @author tdy
 * 
 */
public interface ProductMapper {

	
	List<Product> getAllProduct(Map pata);
	
	List<Product> getAllProductToPage(int memid);
	
	int getCounts(Map param);
	
    List<Product> getAllProduct2(Map pata);
	
	int getCounts2(Map param);
	
	void insert(Product product);
	
	void insertProPic(List<ProPic> propiclist);
	
	void deleteProPic(String pcode);
	
	void deleteProPicById(int id);
	
	void delete(int id);
	
	void update(Product product);
	
	Product getInfoById(int id);
	
	List<ProPic> getProPicByCode(String code);

    void lineOpt(Map cmap);
    
    void stateOpt(Map cmap);

    void synctoshop(Map cmap);
    
    void updateMallURL(Map cmap);
    

}
