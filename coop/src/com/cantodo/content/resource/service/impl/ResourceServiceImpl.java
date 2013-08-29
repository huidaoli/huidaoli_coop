package com.cantodo.content.resource.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.base.frame.dao.DictBussManager;
import com.base.frame.model.DictBuss;
import com.cantodo.content.dto.Resource;
import com.cantodo.content.front.tool.HtmlRegexpUtil;
import com.cantodo.content.persistence.ResourceMapper;
import com.cantodo.content.resource.service.ResourceService;

@Service("resourceServiceImpl")
public class ResourceServiceImpl implements ResourceService
{

    private Log logger = LogFactory.getLog(ResourceServiceImpl.class);

    @Autowired
    private DictBussManager dictBussManager;

    @Autowired
    private ResourceMapper resourceMapper;

    private List<DictBuss> listDictBuss(int type)
    {
        return dictBussManager.listDictBuss(type);
    }

    @Override
    @SuppressWarnings("unchecked")
    public String getList(Map param, String type)
    {
    	logger.debug("enter getList");


        JsonConfig jsonConfig = new JsonConfig();

        // 处理属性为Date类型
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor()
        {
            public Object processArrayValue(Object value, JsonConfig jsonConfig)
            {
                if (value == null)
                {
                    return "";
                }
                return value;
            }

            public Object processObjectValue(String key, Object value, JsonConfig jsonConfig)
            {

                if (key.equals("createDate"))
                {
                    if (null == value)
                    {
                        return "";
                    }
                    String res = DateFormatUtils.format((Date) value, "yyyy-MM-dd");

                    return res;
                }

                return value;

            }

        });

        if ("1".equals(type))
        {
            jsonConfig.registerJsonValueProcessor(int.class, new JsonValueProcessor()
            {
                public Object processArrayValue(Object value, JsonConfig jsonConfig)
                {
                    if (value == null)
                    {
                        return "";
                    }
                    return value;
                }

                public Object processObjectValue(String key, Object value, JsonConfig jsonConfig)
                {

                    if (key.equals("type"))
                    {
                        if (null == value)
                        {
                            return "";
                        }
                        String res = "";
                        List<DictBuss> listDictBuss = listDictBuss(15);
                        for (DictBuss db : listDictBuss)
                        {
                            if (db.getDictId() == Integer.parseInt(value.toString()))
                            {
                                return db.getDictName();
                            }
                        }

                        return res;
                    }

                    return value;

                }

            });
        }
        if ("2".equals(type))
        {
            jsonConfig.registerJsonValueProcessor(int.class, new JsonValueProcessor()
            {
                public Object processArrayValue(Object value, JsonConfig jsonConfig)
                {
                    if (value == null)
                    {
                        return "";
                    }
                    return value;
                }

                public Object processObjectValue(String key, Object value, JsonConfig jsonConfig)
                {

                    if (key.equals("type"))
                    {
                        if (null == value)
                        {
                            return "";
                        }
                        String res = "";
                        List<DictBuss> listDictBuss = listDictBuss(16);
                        for (DictBuss db : listDictBuss)
                        {
                            if (db.getDictId() == Integer.parseInt(value.toString()))
                            {
                                return db.getDictName();
                            }
                        }

                        return res;
                    }

                    return value;

                }

            });
        }
        if ("3".equals(type))
        {
            jsonConfig.registerJsonValueProcessor(int.class, new JsonValueProcessor()
            {
                public Object processArrayValue(Object value, JsonConfig jsonConfig)
                {
                    if (value == null)
                    {
                        return "";
                    }
                    return value;
                }

                public Object processObjectValue(String key, Object value, JsonConfig jsonConfig)
                {

                    if (key.equals("type"))
                    {
                        if (null == value)
                        {
                            return "";
                        }
                        String res = "";
                        List<DictBuss> listDictBuss = listDictBuss(17);
                        for (DictBuss db : listDictBuss)
                        {
                            if (db.getDictId() == Integer.parseInt(value.toString()))
                            {
                                return db.getDictName();
                            }
                        }

                        return res;
                    }

                    return value;

                }

            });
        }
        if ("4".equals(type))
        {
            jsonConfig.registerJsonValueProcessor(int.class, new JsonValueProcessor()
            {
                public Object processArrayValue(Object value, JsonConfig jsonConfig)
                {
                    if (value == null)
                    {
                        return "";
                    }
                    return value;
                }

                public Object processObjectValue(String key, Object value, JsonConfig jsonConfig)
                {

                    if (key.equals("type"))
                    {
                        if (null == value)
                        {
                            return "";
                        }
                        String res = "";
                        List<DictBuss> listDictBuss = listDictBuss(18);
                        for (DictBuss db : listDictBuss)
                        {
                            if (db.getDictId() == Integer.parseInt(value.toString()))
                            {
                                return db.getDictName();
                            }
                        }

                        return res;
                    }

                    return value;

                }

            });
        }

        Map result = new HashMap();
        List<Resource> list = null;
        int total = 0;
        try
        {
            list = resourceMapper.getAllInfo(param);
            total = resourceMapper.getCounts(param);
        }
        catch (RuntimeException e1)
        {
            logger.debug("", e1);
        }
        //System.out.println(list.size());

        result.put("total", total);
        result.put("rows", list);

        String s = "";
        try
        {
            s = JSONObject.fromObject(result, jsonConfig).toString();
        }
        catch (DataAccessException e)
        {
            logger.error("JSONObject.fromObject(result,jsonConfig).toString()", e);
        }
        
  		
        logger.debug("exit getList");
        return s;

    }

    public void add(Resource resource)
    {
    	logger.debug("===============enter  add===============");

        try 
        {
			resourceMapper.insert(resource);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("add(Resource resource)", e);
		}
  		
        logger.debug("===============exit  add===============");
    }

    public void update(Resource resource)
    {
    	logger.debug("===============enter update===============");

        try {
			resourceMapper.update(resource);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("update(Resource resource)", e);
		}
  		
        logger.debug("===============exit update===============");
    }

    public Resource getInfoById(Map map)
    {
    	logger.debug("enter getInfoById");
    	
    	Resource r = resourceMapper.getInfoById(map);
  		
        logger.debug("exit getInfoById");
        return r;
    }

    public void delete(String strids)
    {
    	logger.debug("enter delete");

        JSONArray jsonArray = JSONArray.fromObject(strids);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        for (int id : ids)
        {
            resourceMapper.delete(id);
        }
  		
        logger.debug("exit delete");
    }

    public List<Resource> getAllInfo(Map pata)
    {
    	logger.debug("enter getAllInfo");
    	
    	 List<Resource> r =resourceMapper.getAllInfo(pata);
  		
        logger.debug("exit getAllInfo");
        return r;
    }

    public List<Resource> getAllInfoSearch(Map pata)
    {
    	logger.debug("enter getAllInfoSearch");

        List<Resource> list = resourceMapper.getAllInfoSearch(pata);
        String cname = null;
        String name = null;
        String ccontent = null;
        for (Resource resource : list)
        {
            name = (String) pata.get("cname");
            if (StringUtils.isNotBlank(name))
            {
                name = name.replaceAll("%", "");
                cname = resource.getName().replaceAll(name, "<font color='red'>" + name + "</font>");
                ccontent = resource.getContent();
                resource.setName(cname);
                resource.setContent(changeStr(ccontent, name));
            }

        }
  		
        logger.debug("exit getAllInfoSearch");
        return list;
    }

    // )
    public int getCounts2(String cctype)
    {
    	logger.debug("enter getCounts2");
    	
    	int s = resourceMapper.getCounts2(cctype);
  		
        logger.debug("exit getCounts2");
        return s;
    }

    @Override
    public int getCounts3(String name)
    {
    	logger.debug("enter getCounts3");

        int res = 0;
        try
        {
            res = resourceMapper.getCounts3(name);
        }
        catch (RuntimeException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  		
        logger.debug("exit getCounts3");
        return res;
    }

    private String changeStr(String s, String key)
    {
    	logger.debug("enter changeStr");

    	if(StringUtils.isBlank(s))
    	{
    		return "";
    	}
    	s = HtmlRegexpUtil.splitAndFilterString(s).trim();
        int keyp = s.indexOf(key);
        String newstr = s;
        
        int start = 0;

        int len = newstr.length();
        int end = 0;
        int sub = len - keyp;
        if(keyp<60)
        {
            start = 0;
        }
        else
        {
            start = keyp -50;
        }
        
        if (sub < 10)
        {
            end = len;
        }
        else
        {
            end = keyp + 10;
        }

        String res = newstr.substring(start, end) ;
        res = res.replaceAll(key, "<font color='red'>" + key + "</font>");
        
  		
        logger.debug("exit changeStr");
        return res;

    }

}
