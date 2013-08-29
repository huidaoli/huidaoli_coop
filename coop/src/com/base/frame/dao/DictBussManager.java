package com.base.frame.dao;

import java.util.List;

import com.base.frame.model.DictBuss;

/**
 * [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
public interface DictBussManager
{

    List<DictBuss> listDictBuss(int type);
    
    int getIdByName(String name,int type);
    
    List<DictBuss> getAllList();
    
    void update(String arg1,String arg2,String arg3);
    
    void insert(DictBuss dictbuss);
    
    String getDescript(int type);
    
    void del(int id);
    
    DictBuss find(int id);
    
    void update(DictBuss dictbuss);
    
}
