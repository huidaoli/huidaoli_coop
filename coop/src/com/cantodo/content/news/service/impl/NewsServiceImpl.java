package com.cantodo.content.news.service.impl;

import java.io.File;
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
import org.springframework.stereotype.Service;

import com.base.frame.dao.DictBussManager;
import com.base.frame.model.DictBuss;
import com.cantodo.content.dto.News;
import com.cantodo.content.front.tool.HttpClient2;
import com.cantodo.content.news.service.NewsService;
import com.cantodo.content.persistence.NewsMapper;

@Service("newServiceImpl")
public class NewsServiceImpl implements NewsService
{

    private Log logger = LogFactory.getLog(NewsServiceImpl.class);

    @Autowired
    private DictBussManager dictBussManager;

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public void addNews(News news, String path, String datePath)
    {
        logger.debug("enter addNews");

        newsMapper.insert(news);

        logger.debug("exit addNews");

    }

    private void createHtml(String contcode, String path, String datePath) throws Exception
    {
        News news2 = newsMapper.getNewsByContcode(contcode);

        String savePath = path + File.separator + contcode + ".html";

        Map pata = new HashMap();
        pata.put("htmlpath", datePath + "/" + contcode + ".html");
        pata.put("contcode", contcode);

        newsMapper.updateHtmlpath(pata);

        HttpClient2.createHTML("queryInfoById.action?id=" + news2.getId() + "&type=1", savePath);
    }

    @Override
    public void deleteNews(String strids)
    {
        logger.debug("enter deleteNews");

        JSONArray jsonArray = JSONArray.fromObject(strids);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        for (int id : ids)
        {
            newsMapper.delete(id);
        }

        logger.debug("exit deleteNews");

    }

    @Override
    public News findNews(int id)
    {
        logger.debug("enter findNews");

        News s = newsMapper.getNewsById(id);

        logger.debug("exit findNews");

        return s;
    }

    private List<DictBuss> listDictBuss(int type)
    {
        return dictBussManager.listDictBuss(type);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String searchNewsInfo(Map param)
    {

        logger.debug("enter searchNewsInfo");

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
                if (key.equals("optddtime"))
                {
                    if (null == value)
                    {
                        return "";
                    }
                    String res = DateFormatUtils.format((Date) value, "yyyy-MM-dd HH:mm:ss");

                    return res;
                }
                

                return value;

            }

        });

        Map result = new HashMap();
        List<News> openlist = null;
        int total = 0;
        try
        {
            openlist = newsMapper.getAllNews(param);
            total = newsMapper.getCounts(param);
        }
        catch (RuntimeException e1)
        {
            e1.printStackTrace();
        }
        // System.out.println(openlist.size());

        result.put("total", total);
        result.put("rows", openlist);

        String s = "";
        try
        {
            JSONObject j = JSONObject.fromObject(result, jsonConfig);
            s = j.toString();
        }
        catch (Exception e)
        {
            logger.error("JSONObject.fromObject(result,jsonConfig).toString()", e);
        }

        logger.debug("exit searchNewsInfo");

        return s;
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public String searchNewsInfo2(Map param)
    {

        logger.debug("enter searchNewsInfo");

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
                if (key.equals("optddtime"))
                {
                    if (null == value)
                    {
                        return "";
                    }
                    String res = DateFormatUtils.format((Date) value, "yyyy-MM-dd HH:mm:ss");

                    return res;
                }
                

                return value;

            }

        });

        Map result = new HashMap();
        List<News> openlist = null;
        int total = 0;
        try
        {
            openlist = newsMapper.getAllNews2(param); 
            total = newsMapper.getCounts22(param);
        }
        catch (RuntimeException e1)
        {
            e1.printStackTrace();
        }
        // System.out.println(openlist.size());

        result.put("total", total);
        result.put("rows", openlist);

        String s = "";
        try
        {
            JSONObject j = JSONObject.fromObject(result, jsonConfig);
            s = j.toString();
        }
        catch (Exception e)
        {
            logger.error("JSONObject.fromObject(result,jsonConfig).toString()", e);
        }

        logger.debug("exit searchNewsInfo");

        return s;
    }

    public List<News> getAllList(Map param)
    {
        logger.debug("enter getAllList");

        List<News> s = newsMapper.getAllNews(param);

        logger.debug("exit getAllList");

        return s;
    }

    @Override
    public void updateNews(News news, String path, String datePath)
    {
        logger.debug("enter updateNews");

        newsMapper.update(news);

        logger.debug("exit updateNews");

    }

    public List<News> getAllInfo(Map pata)
    {

        logger.debug("enter getAllInfo");

        List<News> r = newsMapper.getAllNews(pata);

        logger.debug("exit getAllInfo");
        return r;
    }

    public int getCounts2()
    {
        logger.debug("enter getCounts2");

        int r = newsMapper.getCounts2();

        logger.debug("exit getCounts2");
        return r;
    }

	@Override
	public void stateOpt(String idarr, int state) 
	{
 
		JSONArray jsonArray = JSONArray.fromObject(idarr);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        Map cmap = new HashMap();

        //for 赋值给map时，无需new HashMap，因为map后覆盖前的
        for (int id : ids)
        {
            cmap.put("id", id);
            cmap.put("state", state);
            newsMapper.stateOpt(cmap);
        }
	}

	@Override
	public void setTop(String idarr, int zhiding) 
	{
		JSONArray jsonArray = JSONArray.fromObject(idarr);

        int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

        Map cmap = new HashMap();

        //for 赋值给map时，无需new HashMap，因为map后覆盖前的
        for (int id : ids)
        {
            cmap.put("id", id);
            cmap.put("zhiding", zhiding);
            if(0==zhiding)
            {
            	cmap.put("optddtime", null);
            }
            else
            {
                cmap.put("optddtime", new Date());
            }
           
            newsMapper.setZd(cmap);
        }
		
	}

    @Override
    public List<News> getAllNews2(Map param)
    {
        // TODO Auto-generated method stub
        return newsMapper.getAllNews2(param);
    }

    @Override
    public int getCounts22(Map param)
    {
        // TODO Auto-generated method stub
        return newsMapper.getCounts22(param);
    }

}
