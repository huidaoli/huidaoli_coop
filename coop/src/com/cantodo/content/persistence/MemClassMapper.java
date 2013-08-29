package com.cantodo.content.persistence;

import java.util.Map;

import com.cantodo.content.dto.MemClass;

/**
 * @author tdy
 */
public interface MemClassMapper
{

    MemClass getInfoById(Map<String, Integer> ids);

    void insert(MemClass memclass);

    void delete(Map<String, Integer> ids);
    
    int getClassMemCount(int classid);
    
    int getClassMemCount2(int classid);
    
    int hastoclass(int memid);
    
    void saveState(Map para);

}
