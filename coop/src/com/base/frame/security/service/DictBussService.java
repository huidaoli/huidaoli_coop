package com.base.frame.security.service;

import java.util.List;
import java.util.Map;

import com.base.frame.model.DictBuss;

/**
 * 
 * [¼òÒªÃèÊö]:<br/>
 * [ÏêÏ¸ÃèÊö]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 28, 2011
 */
public interface DictBussService
{

    public List<DictBuss> listDictBuss(int type);
    
    public Map<Integer,String> mapDictBuss(int type);
}
