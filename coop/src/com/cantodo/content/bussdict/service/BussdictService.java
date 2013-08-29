package com.cantodo.content.bussdict.service;

import java.util.List;
import java.util.Map;

import com.base.frame.model.DictBuss;

public interface BussdictService
{

    @SuppressWarnings("unchecked")
    String getList(Map param, String type);

    void save(String jsonData);

    List<DictBuss> listDictBuss(int type);

    void update(String arg1, String arg2, String arg3);
    
    void insert(DictBuss dictbuss);
    
    String getDescript(int type);
    
    void del(int id);
    
    void savecont(String[] ids,String[] dictIds,String[] dictNames,String typeid);
    

}
