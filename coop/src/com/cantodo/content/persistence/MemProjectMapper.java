package com.cantodo.content.persistence;

import java.util.Map;

import com.cantodo.content.dto.MemProject;

/**
 * @author tdy
 */
public interface MemProjectMapper
{

	MemProject getInfoById(Map<String, Integer> ids);

    void insert(MemProject memProject);

    void delete(Map<String, Integer> ids);
    
    int getMemProjectCount(int projectid);
    
    int getMemProjectCount2(int projectid);
    
    void saveState(Map para);

}
