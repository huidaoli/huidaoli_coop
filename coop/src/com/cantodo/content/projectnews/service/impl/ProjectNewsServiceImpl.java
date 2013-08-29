package com.cantodo.content.projectnews.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.base.frame.dao.DictBussManager;
import com.base.frame.model.DictBuss;
import com.cantodo.content.dto.ProjectNews;
import com.cantodo.content.dto.Talents;
import com.cantodo.content.persistence.ProjectNewsMapper;
import com.cantodo.content.projectnews.service.ProjectNewsService;

@Service("projectNewsServiceImpl")
public class ProjectNewsServiceImpl implements ProjectNewsService
{

    private Log logger = LogFactory.getLog(ProjectNewsServiceImpl.class);

    @Autowired
    private DictBussManager dictBussManager;

    @Autowired
    private ProjectNewsMapper projectNewsMapper;


    private List<DictBuss> listDictBuss(int type)
    {
        return dictBussManager.listDictBuss(type);
    }


    @Override
    @SuppressWarnings("unchecked")
    public String getList(Map param)
    {
    	logger.debug("enter getList");


    	JsonConfig jsonConfig = new JsonConfig();

		// 处理属性为Date类型
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonValueProcessor() {
					public Object processArrayValue(Object value,
							JsonConfig jsonConfig) {
						if (value == null) {
							return "";
						}
						return value;
					}

					public Object processObjectValue(String key, Object value,
							JsonConfig jsonConfig) {

						if (key.equals("createDate")) {
							if (null == value) {
								return "";
							}
							String res = DateFormatUtils.format((Date) value,
									"yyyy-MM-dd");

							return res;
						}

						return value;

					}

				});

		jsonConfig.registerJsonValueProcessor(int.class,
				new JsonValueProcessor() {
					public Object processArrayValue(Object value,
							JsonConfig jsonConfig) {
						if (value == null) {
							return "";
						}
						return value;
					}

					public Object processObjectValue(String key, Object value,
							JsonConfig jsonConfig) {

						if (key.equals("type")) {
							if (null == value) {
								return "";
							}
							String res = "";
							List<DictBuss> listDictBuss = listDictBuss(9);
							for (DictBuss db : listDictBuss) {
								if (db.getDictId() == Integer.parseInt(value
										.toString())) {
									return db.getDictName();
								}
							}

							return res;
						}

						return value;

					}

				});
		Map result = new HashMap();
		List<ProjectNews> list = null;
		int total = 0;
		try {
			list = projectNewsMapper.getAllInfo(param);
			total = projectNewsMapper.getCounts(param);
		} catch (RuntimeException e1) {
			logger.debug("",e1);
		}
		//System.out.println(list.size());

		result.put("total", total);
		result.put("rows", list);

		String s = "";
		try {
			s = JSONObject.fromObject(result, jsonConfig).toString();
		} catch (DataAccessException e) {
			logger.error("JSONObject.fromObject(result,jsonConfig).toString()",
					e);
		}
		
  		
        logger.debug("exit getList");
		return s;

    }
    
    public List<ProjectNews> getAllList(Map param)
    {
    	logger.debug("enter getAllList");
    	
    	 List<ProjectNews> r = projectNewsMapper.getAllInfo(param);
  		
        logger.debug("exit getAllList");
    	return r;
    }

    public void add(ProjectNews projectNews)
    {
    	logger.debug("enter add");

    	projectNewsMapper.insert(projectNews);
  		
        logger.debug("exit add");
    }
    
   

    public void update(ProjectNews projectNews)
    {
    	logger.debug("enter update");

    	projectNewsMapper.update(projectNews);
  		
        logger.debug("exit update");
    }

    public ProjectNews getInfoById(int id)
    {
    	logger.debug("enter getInfoById");
    	
    	ProjectNews r =  projectNewsMapper.getInfoById(id);
  		
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
        	projectNewsMapper.delete(id);
        }
  		
        logger.debug("exit delete");
    }
    
    public int getCounts2()
	{
    	logger.debug("enter getCounts2");
    	
    	int r =  projectNewsMapper.getCounts2();
  		
        logger.debug("exit getCounts2");
		return r;
	}
    
    public List<ProjectNews> getAllInfo(Map pata)
    {
    	logger.debug("enter getAllInfo");
    	
    	List<ProjectNews> r =  projectNewsMapper.getAllInfo(pata);
  		
        logger.debug("exit getAllInfo");
    	return r;
    }


}
