package com.base.frame.security.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.frame.dao.DictBussManager;
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;

@Service
public class DictBussImplService implements DictBussService
{

    private Log logger = LogFactory.getLog(DictBussImplService.class);
    
    @Autowired
    private DictBussManager dictBussManager;
    
    @Override
    public List<DictBuss> listDictBuss(int type)
    {
        return dictBussManager.listDictBuss(type);
    }
    
    public Map<Integer,String> mapDictBuss(int type)
    {
    	Map<Integer,String> map = new HashMap<Integer,String>();
        List<DictBuss> list =  dictBussManager.listDictBuss(type);
        for(DictBuss db : list)
        {
        	map.put(db.getDictId(), db.getDictName());
        }
        return map;
    }

}
