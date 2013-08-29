package com.cantodo.content.product.service;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.FileUpload;
import com.cantodo.content.dto.ProPic;
import com.cantodo.content.dto.Product;

public interface ProductService
{

    List<Product> getAllProduct(Map pata);

    int getCounts(Map param);
    
    List<Product> getAllProduct2(Map pata);

    int getCounts2(Map param);
    
    void add(Product product,String path,List<FileUpload> list);

    void update(Product product,String path,List<FileUpload> list);

	String getProductList(Map conditionMap);
	
	Product getInfoById(int id);
	
	List<ProPic> getProPicByCode(String code);

    void delete(String idarr);

    void lineOpt(String idarr,int state);
    
    void stateOpt(String idarr,int state);
    
    List<Product> getAllProductToPage(int memid);

    void syncDataToShop(Product product);

    void synctoshop(Map cmap);

}
