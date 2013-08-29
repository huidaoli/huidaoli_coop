package com.cantodo.content.news.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;
import com.cantodo.content.dto.News;
import com.cantodo.content.news.service.NewsService;

/**
 * 
 * @author tdy
 * 
 */
@Controller("newsAction")
@Scope("prototype")
public class NewsAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8537097029951060106L;

	/**
	 * 
	 */

	private Log logger = LogFactory.getLog(NewsAction.class);

	@Autowired
	private NewsService newsServiceImpl;

	@Autowired
	private DictBussService dictBussImplService;

	private News news;

	private List<DictBuss> listDictBuss;

	public List<DictBuss> getListDictBuss() {
		return listDictBuss;
	}

	public void setListDictBuss(List<DictBuss> listDictBuss) {
		this.listDictBuss = listDictBuss;
	}

	public String getNewsList() {
		listDictBuss = dictBussImplService.listDictBuss(4);
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String getAjaxData() {

    	logger.debug("enter getAjaxData");
  		
		response.setHeader("Cache-Control", "no-cache");

		String strpage = request.getParameter("page");

		String strrows = request.getParameter("rows");

		int rows = Integer.parseInt(strrows);

		int offset = (Integer.parseInt(strpage) - 1) * rows;

		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String state = request.getParameter("state");
		
		name = StringUtils.isBlank(name) ? null : "%"+name+"%";
		type = ("-1").equals(type) ? null : type;
		state = ("").equals(state) ? null : state;
		

		Map conditionMap = new HashMap();
		conditionMap.put("cname", name);
		conditionMap.put("ctype", type);
		conditionMap.put("coopid", null);
		conditionMap.put("state", state);
		conditionMap.put("offset", offset);
		conditionMap.put("rows", rows);

		String jsonData = newsServiceImpl.searchNewsInfo(conditionMap);
		
        logger.debug("exit getAjaxData");

		return toJsonData(jsonData);
	}

	public String loadNews() {
		
    	logger.debug("enter loadNews");

		
		response.setHeader("Cache-Control", "no-cache");
		request.setAttribute("opt", "add");
		String contcode = UUID.randomUUID().toString();
		news = new News();
		news.setContcode(contcode);
		news.setCreateDate(new Date());
		
		
		listDictBuss = dictBussImplService.listDictBuss(4);
		
  		
        logger.debug("exit loadNews");
		
		return SUCCESS;
	}

	public String saveNews() {

		
    	logger.debug("enter saveNews");
    	
    	String path = "";
    	
    	String datePath = "";
		
		String opt = request.getParameter("opt");

		if (opt.equals("add")) {
		    
		    news.setCoopid(-1);
	        //ÉóºËÍ¨¹ý
	        news.setState(1);
			newsServiceImpl.addNews(news,path,datePath);

		}
		if (opt.equals("edit")) {
		    
			newsServiceImpl.updateNews(news,path,datePath);
		}
		
  		
        logger.debug("exit saveNews");

		return success();
	}

	

	@SuppressWarnings("unchecked")
	public String loadNewsInfoById() {

    	logger.debug("enter loadNewsInfoById");

		
		String id = request.getParameter("id");
		String opt = request.getParameter("opt");
		listDictBuss = dictBussImplService.listDictBuss(4);

		try {
			news = newsServiceImpl.findNews(Integer.parseInt(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("opt", "edit");

		if (opt.equals("edit")) {

	        logger.debug("exit loadNewsInfoById");
			return SUCCESS;
		} else {
	  		
	        logger.debug("exit loadNewsInfoById");
			return "view";
		}

	}

	public String deleteNews() {
		
    	logger.debug("enter deleteNews");


		String idarr = request.getParameter("ids");

		newsServiceImpl.deleteNews(idarr);
		
  		
        logger.debug("exit deleteNews");

		return success();
	}
	
	 /**
     * [¼òÒªÃèÊö]:<br/> [ÏêÏ¸ÃèÊö]:<br/>
     * 
     * @author tangdingyi
     * @return
     */
    public String stateOpt()
    {

        String idarr = request.getParameter("ids");

        String statestr = request.getParameter("state");

        int state = NumberUtils.toInt(statestr, 0);

        newsServiceImpl.stateOpt(idarr, state);

        return success();

    }
    
    
    public String setTop()
    {

        String idarr = request.getParameter("ids");

        String statestr = request.getParameter("state");

        int state = NumberUtils.toInt(statestr, 0);

        newsServiceImpl.setTop(idarr, state);

        return success();

    }

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

}
