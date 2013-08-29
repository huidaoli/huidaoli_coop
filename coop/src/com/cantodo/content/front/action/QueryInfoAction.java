package com.cantodo.content.front.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;
import com.cantodo.content.dto.Atta;
import com.cantodo.content.dto.Information;
import com.cantodo.content.dto.News;
import com.cantodo.content.dto.OpenClass;
import com.cantodo.content.dto.PracticeResult;
import com.cantodo.content.dto.PracticeSys;
import com.cantodo.content.dto.Project;
import com.cantodo.content.dto.ProjectNews;
import com.cantodo.content.dto.RandDResult;
import com.cantodo.content.dto.RandDSys;
import com.cantodo.content.dto.Resource;
import com.cantodo.content.dto.Talents;
import com.cantodo.content.dto.TrainingResult;
import com.cantodo.content.dto.TrainingSys;
import com.cantodo.content.front.tool.PageUtil;
import com.cantodo.content.information.service.InformationService;
import com.cantodo.content.news.service.NewsService;
import com.cantodo.content.openclass.service.OpenClassService;
import com.cantodo.content.practiceresult.service.PracticeResultService;
import com.cantodo.content.practicesys.service.PracticeSysService;
import com.cantodo.content.project.service.ProjectService;
import com.cantodo.content.projectnews.service.ProjectNewsService;
import com.cantodo.content.randdresult.service.RandDResultService;
import com.cantodo.content.randdsys.service.RandDSysService;
import com.cantodo.content.resource.service.ResourceService;
import com.cantodo.content.talents.service.TalentsService;
import com.cantodo.content.trainingresult.service.TrainingResultService;
import com.cantodo.content.trainingsys.service.Tool;
import com.cantodo.content.trainingsys.service.TrainingSysService;
import com.cantodo.content.upload.service.UploadService;

@Controller("queryInfoAction")
@Scope("prototype")
public class QueryInfoAction extends BaseAction
{ 

    /**
     * [简要描述]: type 1:基地新闻 2:项目资讯 3:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = -6185856549024699283L;

    private Log logger = LogFactory.getLog(QueryInfoAction.class);

    @Autowired
    private NewsService newsServiceImpl;

    @Autowired
    private TalentsService talentsServiceImpl;

    @Autowired
    private OpenClassService openClassServiceImpl;

    @Autowired
    private ProjectNewsService projectNewsServiceImpl;
    
    @Autowired
    private UploadService uploadServiceImpl;

    @Autowired
    private DictBussService dictBussImplService;

    @Autowired
    private TrainingSysService trainingSysServiceImpl;

    @Autowired
    private TrainingResultService trainingResultServiceImpl;

    @Autowired
    private ProjectService projectServiceImpl;
    
    @Autowired
    private RandDSysService randDSysServiceImpl;
    
    @Autowired
    private RandDResultService randDResultServiceImpl;
    
    @Autowired
    private ResourceService resourceServiceImpl;
    
    @Autowired
    private InformationService informationService;
    
    @Autowired
    private PracticeResultService practiceResultServiceImpl;
    
    @Autowired
    private PracticeSysService practiceSysServiceImpl;
    
    private List<DictBuss> listDictBuss;
    
    private List<DictBuss> listDictBusstype;

    private List<DictBuss> listDictBussitfx;

    private List<DictBuss> listDictBussyyfx;
    
    private Project project;

    public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<DictBuss> getListDictBusstype() {
		return listDictBusstype;
	}

	public void setListDictBusstype(List<DictBuss> listDictBusstype) {
		this.listDictBusstype = listDictBusstype;
	}

	public List<DictBuss> getListDictBussitfx() {
		return listDictBussitfx;
	}

	public void setListDictBussitfx(List<DictBuss> listDictBussitfx) {
		this.listDictBussitfx = listDictBussitfx;
	}

	public List<DictBuss> getListDictBussyyfx() {
		return listDictBussyyfx;
	}

	public void setListDictBussyyfx(List<DictBuss> listDictBussyyfx) {
		this.listDictBussyyfx = listDictBussyyfx;
	}

	public List<DictBuss> getListDictBuss()
    {
        return listDictBuss;
    }

    public void setListDictBuss(List<DictBuss> listDictBuss)
    {
        this.listDictBuss = listDictBuss;
    }

    @SuppressWarnings("unchecked")
    public String queryInfoById()
    {
    	logger.debug("enter queryInfoById");
    	
        String strid = request.getParameter("id");
        String strtype = request.getParameter("type");
        String flag = request.getParameter("flag");
        int id = NumberUtils.toInt(strid, 0);
        int type = NumberUtils.toInt(strtype, 0);
        Map resMap = null;
        switch (type)
        {
            // 1:基地新闻
            case 1:
            {
                News news = newsServiceImpl.findNews(id);
                
                List<Atta> list = uploadServiceImpl.getAttaById(news.getContcode());
                
                resMap = toMap(news);
                
                resMap.put("attalist", list);

            }
                break;
            // 2:项目资讯
            case 2:
            {
                ProjectNews pn = projectNewsServiceImpl.getInfoById(id);
                
                List<Atta> list = uploadServiceImpl.getAttaById(pn.getContcode());
                
                resMap = toMap(pn);
                
                resMap.put("attalist", list);
                
            }

                break;
            // 3:人才资讯
            case 3:
            {
                Talents talents = talentsServiceImpl.getInfoById(id);
                
                List<Atta> list = uploadServiceImpl.getAttaById(talents.getContcode());
                
                resMap = toMap(talents);
                
                resMap.put("attalist", list);
                
            }

                break;
            // 4:开班资讯
            case 4:
            {
                OpenClass oc = openClassServiceImpl.findOpenClass(id);
                
                List<Atta> list = uploadServiceImpl.getAttaById(oc.getContcode());

                resMap = toMap(oc);
                
                resMap.put("attalist", list);
                
            }

                break;
            // 5:培育体系
            case 5:
            {

                TrainingSys ts = trainingSysServiceImpl.getInfoById(id);
                
                List<Map> list = trainingSysServiceImpl.getImgsById(ts.getId());

                if (!(null == list || list.size() == 0))
                {
                    Map smap = list.get(0);

                    String imgid = (String) smap.get("attaid");

                    String imgName = (String) smap.get("newname");

                    int width = (Integer) smap.get("width");

                    int height = (Integer) smap.get("height");
                    
                    List divlist = trainingSysServiceImpl.getDivInfo(imgid);

                    String div = Tool.createTable(imgName, new int[] {width, height},divlist,1);

                    request.setAttribute("divs", div);
                }

                
                resMap = toMap(ts);

            }

                break;

            // 6:培育成果
            case 6:
            {

                TrainingResult trainingResult = trainingResultServiceImpl.getInfoById(id);
                
                List<Atta> list = uploadServiceImpl.getAttaById(trainingResult.getContcode());
                
                resMap = toMap(trainingResult);
                
                resMap.put("attalist", list);
            }

                break;

            // 7:项目信息
            case 7:
            {
                this.project = projectServiceImpl.getInfoById(id);
                
                listDictBussitfx = dictBussImplService.listDictBuss(5);
                listDictBussyyfx = dictBussImplService.listDictBuss(6);
                listDictBusstype = dictBussImplService.listDictBuss(7);
                
                List<Atta> list = uploadServiceImpl.getAttaById(project.getContcode());
                
                resMap = toMap(project);
                
                resMap.put("attalist", list);

            }

                break;
            // 8:研发体系
            case 8:
            {
                RandDSys tds = randDSysServiceImpl.getInfoById(id);
                List<Map> list = randDSysServiceImpl.getImgsById(tds.getId());

                if (!(null == list || list.size() == 0))
                {
                    Map smap = list.get(0);

                    String imgid = (String) smap.get("attaid");

                    String imgName = (String) smap.get("newname");

                    int width = (Integer) smap.get("width");

                    int height = (Integer) smap.get("height");
                    
                    List divlist = trainingSysServiceImpl.getDivInfo(imgid);

                    String div = Tool.createTable(imgName, new int[] {width, height},divlist,1);

                    request.setAttribute("divs", div);
                }
                resMap = toMap(tds);

            }

                break;
            // 9:项目成果 
            case 9:
            {
                RandDResult rdr = randDResultServiceImpl.getInfoById(id);
                
                List<Atta> list = uploadServiceImpl.getAttaById(rdr.getContcode());
                
                resMap = toMap(rdr);
                
                resMap.put("attalist", list);
                
            }

                break;
             // 10:热门项目
            case 10:
            {
                
                Map conditionMap = new HashMap();
                conditionMap.put("id", id);
                conditionMap.put("cctype", "1");
                Resource resource = resourceServiceImpl.getInfoById(conditionMap);
                
                List<Atta> list = uploadServiceImpl.getAttaById(resource.getContcode());
                
                resMap = toMap(resource);
                
                resMap.put("attalist", list);
                
            }

                break;
             // 11:热门培育
            case 11:
            {

                Map conditionMap = new HashMap();
                conditionMap.put("id", id);
                conditionMap.put("cctype", "2");
                Resource resource = resourceServiceImpl.getInfoById(conditionMap);
                
                List<Atta> list = uploadServiceImpl.getAttaById(resource.getContcode());
                
                resMap = toMap(resource);
                
                resMap.put("attalist", list);
                
            }

                break;
                // 12抢手人才
            case 12:
            {

                Map conditionMap = new HashMap();
                conditionMap.put("id", id);
                conditionMap.put("cctype", "3");
                Resource resource = resourceServiceImpl.getInfoById(conditionMap);
                
                List<Atta> list = uploadServiceImpl.getAttaById(resource.getContcode());
                
                resMap = toMap(resource);
                
                resMap.put("attalist", list);
                
            }

                break;
                // 13声望专家
            case 13:
            {

                Map conditionMap = new HashMap();
                conditionMap.put("id", id);
                conditionMap.put("cctype", "4");
                Resource resource = resourceServiceImpl.getInfoById(conditionMap);
                
                List<Atta> list = uploadServiceImpl.getAttaById(resource.getContcode());
                
                resMap = toMap(resource);
                
                resMap.put("attalist", list);
                
            }

                break;
                
            case 14:
            {

                Map conditionMap = new HashMap();
                conditionMap.put("id", id);
                conditionMap.put("cctype", "1");
                Information information = informationService.getInfoById(conditionMap);
                
                List<Atta> list = uploadServiceImpl.getAttaById(information.getContcode());
                
                resMap = toMap(information);
                
                resMap.put("attalist", list);
                
            }

                break;
            case 15:
            {

                Map conditionMap = new HashMap();
                conditionMap.put("id", id);
                conditionMap.put("cctype", "2");
                Information information = informationService.getInfoById(conditionMap);
                
                List<Atta> list = uploadServiceImpl.getAttaById(information.getContcode());
                
                resMap = toMap(information);
                
                resMap.put("attalist", list);
                
            }

                break;
            case 16:
            {

                Map conditionMap = new HashMap();
                conditionMap.put("id", id);
                conditionMap.put("cctype", "3");
                Information information = informationService.getInfoById(conditionMap);
                
                List<Atta> list = uploadServiceImpl.getAttaById(information.getContcode());
                
                resMap = toMap(information);
                
                resMap.put("attalist", list);
                
            }

                break;
            case 17:
            {

                Map conditionMap = new HashMap();
                conditionMap.put("id", id);
                conditionMap.put("cctype", "4");
                Information information = informationService.getInfoById(conditionMap);
                
                List<Atta> list = uploadServiceImpl.getAttaById(information.getContcode());
                
                resMap = toMap(information);
                
                resMap.put("attalist", list);
                
            }

                break;
            case 18:
            {

                Map conditionMap = new HashMap();
                conditionMap.put("id", id);
                conditionMap.put("cctype", "5");
                Information information = informationService.getInfoById(conditionMap);
                
                List<Atta> list = uploadServiceImpl.getAttaById(information.getContcode());
                
                resMap = toMap(information);
                
                resMap.put("attalist", list);
                
            }

                break;
                
            // 19:项目成果 
            case 19:
            {
                PracticeResult rdr = practiceResultServiceImpl.getInfoById(id);
                
                List<Atta> list = uploadServiceImpl.getAttaById(rdr.getContcode());
                
                resMap = toMap(rdr);
                
                resMap.put("attalist", list);
                
            }

                break;
                
             // 8:研发体系
            case 20:
            {
                PracticeSys tds = practiceSysServiceImpl.getInfoById(id);
                List<Map> list = practiceSysServiceImpl.getImgsById(tds.getId());

                if (!(null == list || list.size() == 0))
                {
                    Map smap = list.get(0);

                    String imgid = (String) smap.get("attaid");

                    String imgName = (String) smap.get("newname");

                    int width = (Integer) smap.get("width");

                    int height = (Integer) smap.get("height");
                    
                    List divlist = practiceSysServiceImpl.getDivInfo(imgid);

                    String div = Tool.createTable(imgName, new int[] {width, height},divlist,1);

                    request.setAttribute("divs", div);
                }
                resMap = toMap(tds);

            }
             

            default:
                break;
        }
        
        request.setAttribute("type", type); 

        request.setAttribute("resMap", resMap);
        
        logger.debug("exit queryInfoById");
        
        if(StringUtils.isNotEmpty(flag) && "company".equals(flag))
        {
            return "success2";
        }
        
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String queryMoreInfoByType()
    {
    	 logger.debug("enter queryMoreInfoByType");
    	
        String strtype = request.getParameter("type");
        int type = NumberUtils.toInt(strtype, 0);
        response.setHeader("Cache-Control", "no-cache");
        int pages = NumberUtils.toInt(request.getParameter("pages"), 1);

        switch (type)
        {
            // 1:基地新闻
            case 1:
            {
                int count = newsServiceImpl.getCounts2();
                Map<String, Object> res = PageUtil.processPage(pages, count, 20, 5);
                Map conditionMap = new HashMap();
                conditionMap.put("cname", null);
                conditionMap.put("ctype", null);
                conditionMap.put("offset", res.get("recordbegin"));
                conditionMap.put("rows", res.get("pagesize"));
                List<News> list = newsServiceImpl.getAllInfo(conditionMap);
                listDictBuss = dictBussImplService.listDictBuss(4);
                request.setAttribute("list1", list);
                request.setAttribute("title", "行业资讯");
                request.setAttribute("type", type);
                request.setAttribute("pageHtml", res.get("pageHtml"));

            }
                break;
            // 2:项目资讯
            case 2:
            {

                int count = projectNewsServiceImpl.getCounts2();
                Map<String, Object> res = PageUtil.processPage(pages, count, 20, 5);
                Map conditionMap = new HashMap();
                conditionMap.put("cname", null);
                conditionMap.put("ctype", null);
                conditionMap.put("offset", res.get("recordbegin"));
                conditionMap.put("rows", res.get("pagesize"));
                List<ProjectNews> list = projectNewsServiceImpl.getAllInfo(conditionMap);
                listDictBuss = dictBussImplService.listDictBuss(9);
                request.setAttribute("list2", list);
                request.setAttribute("title", "业务公告");
                request.setAttribute("type", type);
                request.setAttribute("pageHtml", res.get("pageHtml"));

            }

                break;
            // 3:人才资讯
            case 3:
            {
                int count = talentsServiceImpl.getCounts2();
                Map<String, Object> res = PageUtil.processPage(pages, count, 20, 5);
                Map conditionMap = new HashMap();
                conditionMap.put("cname", null);
                conditionMap.put("ctype", null);
                conditionMap.put("offset", res.get("recordbegin"));
                conditionMap.put("rows", res.get("pagesize"));
                List<Talents> list = talentsServiceImpl.getAllInfo(conditionMap);
                listDictBuss = dictBussImplService.listDictBuss(8);
                request.setAttribute("list3", list);
                request.setAttribute("title", "人才资讯");
                request.setAttribute("type", type);
                request.setAttribute("pageHtml", res.get("pageHtml"));
            }

                break;
            // 4:开班资讯
            case 4:
            {

                int count = openClassServiceImpl.getCounts2();
                Map<String, Object> res = PageUtil.processPage(pages, count, 20, 5);
                Map conditionMap = new HashMap();
                conditionMap.put("cname", null);
                conditionMap.put("ctype", null);
                conditionMap.put("offset", res.get("recordbegin"));
                conditionMap.put("rows", res.get("pagesize"));
                List<OpenClass> list = openClassServiceImpl.getAllInfo(conditionMap);
                listDictBuss = dictBussImplService.listDictBuss(3);
                request.setAttribute("list4", list);
                request.setAttribute("title", "开班资讯");
                request.setAttribute("type", type);
                request.setAttribute("pageHtml", res.get("pageHtml"));
            }

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;

            default:
                break;
        }
        
        logger.debug("exit queryMoreInfoByType");

        return SUCCESS;
    }
    

    @SuppressWarnings("unchecked")
    private Map toMap(Object obj)
    {
        Map resMap = new HashMap();

        BeanMap beanMap = new BeanMap(obj);

        resMap.putAll(beanMap);

        return resMap;
    }

}
