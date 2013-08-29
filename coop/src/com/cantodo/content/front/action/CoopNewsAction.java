package com.cantodo.content.front.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;
import com.cantodo.content.dto.Member;
import com.cantodo.content.dto.News;
import com.cantodo.content.news.action.NewsAction;
import com.cantodo.content.news.service.NewsService;

/**
 */
@Controller("coopNewsAction")
@Scope("prototype")
public class CoopNewsAction extends BaseAction
{


    /**
     * [¼òÒªÃèÊö]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = 4890628957035130751L
    ;

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

    @SuppressWarnings("unchecked")
    public String getAjaxDataNews() {
        
       

        logger.debug("enter getAjaxData");
        
        Member member = (Member) request.getSession().getAttribute("member");
        
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
        conditionMap.put("coopid", member.getId());
        conditionMap.put("state", state);
        conditionMap.put("offset", offset);
        conditionMap.put("rows", rows);

        String jsonData = newsServiceImpl.searchNewsInfo2(conditionMap);
        
        logger.debug("exit getAjaxData");

        return toJsonData(jsonData);
    }

    public String loadNews() {
        
        logger.debug("enter loadNews");
        Member member = (Member) request.getSession().getAttribute("member");

        if (null == member)
        {
            return ERROR;
        }

        
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

        Member member = (Member) request.getSession().getAttribute("member");

        if (null == member)
        {
            return ERROR;
        }
        logger.debug("enter saveNews");
        
        String path = "";
        
        String datePath = "";
        
        String opt = request.getParameter("opt");

        if (opt.equals("add")) {
            
            news.setCoopid(member.getId());
            //ÉóºËÍ¨¹ý
            news.setState(0);
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
        
        Member member = (Member) request.getSession().getAttribute("member");

        if (null == member)
        {
            return ERROR;
        }

        
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
        
        Member member = (Member) request.getSession().getAttribute("member");

        if (null == member)
        {
            return ERROR;
        }


        String idarr = request.getParameter("ids");

        newsServiceImpl.deleteNews(idarr);
        
        
        logger.debug("exit deleteNews");

        return success();
    }
    

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

}
