package com.cantodo.content.bussdict.service.impl;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.frame.dao.DictBussManager;
import com.base.frame.model.DictBuss;
import com.cantodo.content.bussdict.service.BussdictService;

@Service("bussdictServiceImpl")
public class BussdictServiceImpl implements BussdictService
{

    private Log logger = LogFactory.getLog(BussdictServiceImpl.class);

    @Autowired
    private DictBussManager dictBussManagerImpl;

    @Override
    @SuppressWarnings("unchecked")
    public String getList(Map param, String type)
    {
        logger.debug("enter getList");

        List<DictBuss> dblist = dictBussManagerImpl.getAllList();

        String s = "";
        try
        {
            s = JSONArray.fromObject(dblist).toString();
        }
        catch (Exception e)
        {
            logger.error("JSONObject.fromObject(result,jsonConfig).toString()", e);
        }

        logger.debug("exit getList");
        return s;

    }

    public void save(String jsonData)
    {
        JSONArray jsonArray = null;
        try
        {
            jsonArray = JSONArray.fromObject(jsonData);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        DictBuss[] sysConfigs = (DictBuss[]) JSONArray.toArray(jsonArray, DictBuss.class);

        // System.out.println(sysConfigs);
        // dictBussManagerImpl.save(sysConfigs);
    }

    public List<DictBuss> listDictBuss(int type)
    {
        return dictBussManagerImpl.listDictBuss(type);
    }

    public void update(String arg1, String arg2, String arg3)
    {

        dictBussManagerImpl.update(arg1, arg2, arg3);
    }

    public void insert(DictBuss dictbuss)
    {
        dictBussManagerImpl.insert(dictbuss);
    }

    public String getDescript(int type)
    {

        return dictBussManagerImpl.getDescript(type);
    }

    public void del(int id)
    {
        dictBussManagerImpl.del(id);
    }
    
    @Transactional
    public  void savecont(String[] ids,String[] dictIds,String[] dictNames,String typeid)
    {
        DictBuss dictBuss = null;
        String descript =  getDescript(Integer.parseInt(typeid));
        for (int i = 0; i < dictNames.length; i++)
        {
            //2个同时有值
            if(StringUtils.isNotEmpty(dictNames[i]) && StringUtils.isNotEmpty(dictIds[i]))
            {
                //如果有id，说明是修改
                if(StringUtils.isNotEmpty(ids[i]))
                {
                    dictBuss = dictBussManagerImpl.find(Integer.parseInt(ids[i]));
                    dictBuss.setDictId(Integer.parseInt(dictIds[i]));
                    dictBuss.setDictName(dictNames[i]);
                    dictBussManagerImpl.update(dictBuss);
                    //dictBussManagerImpl.update(dictIds[i], dictNames[i], ids[i]);
                }
                //没有id，说明是新增
                else
                {
                    dictBuss = new DictBuss();
                    dictBuss.setDictId(Integer.parseInt(dictIds[i]));
                    dictBuss.setDictName(dictNames[i]);
                    dictBuss.setDictType(Integer.parseInt(typeid));
                    dictBuss.setDescript(descript);
                    dictBussManagerImpl.insert(dictBuss);
                }
            }
            else
            {
                
                //如果只有id，没有其它2项值，说明是删除
                if(StringUtils.isNotEmpty(ids[i]))
                {
                    dictBussManagerImpl.del(Integer.parseInt(ids[i]));
                }
                //没有id情况下，其它2项信息又不全。不处理
            }
          
        }
    }
    
    
    /**
     *在 savecont2上加事务，不起作用，是因为 dictBussManagerImpl.update(dictIds[i], dictNames[i], ids[i]);
     *和 dictBussManagerImpl.insert(dictBuss); dictBussManagerImpl.del(Integer.parseInt(ids[i]));
     *不是同一个连接，改用 savecont就可以了
     *
     */
    @SuppressWarnings("unused")
    @Transactional
    private  void savecont2(String[] ids,String[] dictIds,String[] dictNames,String typeid)
    {
        DictBuss dictBuss = null;
        String descript =  getDescript(Integer.parseInt(typeid));
        for (int i = 0; i < dictNames.length; i++)
        {
            //2个同时有值
            if(StringUtils.isNotEmpty(dictNames[i]) && StringUtils.isNotEmpty(dictIds[i]))
            {
                //如果有id，说明是修改
                if(StringUtils.isNotEmpty(ids[i]))
                {
                    dictBussManagerImpl.update(dictIds[i], dictNames[i], ids[i]);
                }
                //没有id，说明是新增
                else
                {
                    dictBuss = new DictBuss();
                    dictBuss.setDictId(Integer.parseInt(dictIds[i]));
                    dictBuss.setDictName(dictNames[i]);
                    dictBuss.setDictType(Integer.parseInt(typeid));
                    dictBuss.setDescript(descript);
                    dictBussManagerImpl.insert(dictBuss);
                }
            }
            else
            {
                
                //如果只有id，没有其它2项值，说明是删除
                if(StringUtils.isNotEmpty(ids[i]))
                {
                    dictBussManagerImpl.del(Integer.parseInt(ids[i]));
                }
                //没有id情况下，其它2项信息又不全。不处理
            }
          
        }
    }

}
