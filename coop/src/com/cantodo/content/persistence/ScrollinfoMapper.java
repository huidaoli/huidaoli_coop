package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Scrollinfo;

/**
 * 
 * @author tdy
 * 
 */
public interface ScrollinfoMapper {


    Scrollinfo getInfoById(Map map);
    
    List<Scrollinfo> getAllInfo(Map pata);
    
    List<Scrollinfo> getAllInfoSearch(String type);
    
    int getCounts(Map param);
    
    int getCounts2(String cctype);
    
    int getCounts3(String name);

    void insert(Scrollinfo scrollinfo);

    void update(Scrollinfo scrollinfo);
    
    void delete(int id);

}
