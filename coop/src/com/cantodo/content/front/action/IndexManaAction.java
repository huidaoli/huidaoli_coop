package com.cantodo.content.front.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.business.Init;
import com.base.frame.common.BaseAction;
import com.base.frame.common.MD5;
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;
import com.cantodo.content.ads.service.AdsService;
import com.cantodo.content.agreement.service.AgreementService;
import com.cantodo.content.dto.Ads;
import com.cantodo.content.dto.Agreement;
import com.cantodo.content.dto.Content;
import com.cantodo.content.dto.Cooperation;
import com.cantodo.content.dto.Member;
import com.cantodo.content.dto.News;
import com.cantodo.content.dto.Product;
import com.cantodo.content.dto.ProjectNews;
import com.cantodo.content.dto.Talents;
import com.cantodo.content.front.tool.AverageImageScale;
import com.cantodo.content.front.tool.Constant;
import com.cantodo.content.front.tool.PageUtil;
import com.cantodo.content.manacont.service.ManacontService;
import com.cantodo.content.member.service.MemberService;
import com.cantodo.content.news.service.NewsService;
import com.cantodo.content.product.service.ProductService;
import com.cantodo.content.projectnews.service.ProjectNewsService;

/**
 * @author tdy 首页管理
 */
@Controller("indexManaAction")
@Scope("prototype")
public class IndexManaAction extends BaseAction
{

    /**
     *  
     */
    private static final long serialVersionUID = 3042740556171526275L;

    private Log logger = LogFactory.getLog(IndexManaAction.class);

    @Autowired
    private ProjectNewsService projectNewsServiceImpl;

    @Autowired
    private DictBussService dictBussImplService;

    @Autowired
    private NewsService newsServiceImpl;

    @Autowired
    private ManacontService manacontServiceImpl;

    @Autowired
    private AdsService adsServiceImpl;

    @Autowired
    private ProductService productServiceImpl;

    @Autowired
    private MemberService memberServiceImpl;
    
    @Autowired
    private AgreementService agreementServiceImpl;

    private List<News> listNews;

    private List<ProjectNews> listProjectNews;

    private List<Talents> listTalents;

    private List<Product> listProduct;

    private List<Cooperation> cooperationList;

    private Member member;
    
    private Agreement agreement;

    private List<DictBuss> listDictBuss;

    private List<DictBuss> listDictBusstype;

    private List<DictBuss> listDictBuss1;

    private List<DictBuss> listDictBuss2;

    private List<DictBuss> listDictBussxu;

    private List<DictBuss> hotword;

    private List<DictBuss> prodcutsort;

    private Content content;
    
    private List<DictBuss> typelist;
    
    public List<DictBuss> getTypelist()
    {
        return typelist;
    }

    public void setTypelist(List<DictBuss> typelist)
    {
        this.typelist = typelist;
    }


    public List<DictBuss> getListDictBusstype()
    {
        return listDictBusstype;
    }

    public void setListDictBusstype(List<DictBuss> listDictBusstype)
    {
        this.listDictBusstype = listDictBusstype;
    }

    public List<DictBuss> getListDictBuss()
    {
        return listDictBuss;
    }

    public void setListDictBuss(List<DictBuss> listDictBuss)
    {
        this.listDictBuss = listDictBuss;
    }

    public List<Cooperation> getCooperationList()
    {
        return cooperationList;
    }

    public void setCooperationList(List<Cooperation> cooperationList)
    {
        this.cooperationList = cooperationList;
    }

    public Content getContent()
    {
        return content;
    }

    public void setContent(Content content)
    {
        this.content = content;
    }

    public List<DictBuss> getListDictBuss1()
    {
        return listDictBuss1;
    }

    public void setListDictBuss1(List<DictBuss> listDictBuss1)
    {
        this.listDictBuss1 = listDictBuss1;
    }

    public List<DictBuss> getListDictBuss2()
    {
        return listDictBuss2;
    }

    public void setListDictBuss2(List<DictBuss> listDictBuss2)
    {
        this.listDictBuss2 = listDictBuss2;
    }

    public List<News> getListNews()
    {
        return listNews;
    }

    public void setListNews(List<News> listNews)
    {
        this.listNews = listNews;
    }

    public List<ProjectNews> getListProjectNews()
    {
        return listProjectNews;
    }

    public void setListProjectNews(List<ProjectNews> listProjectNews)
    {
        this.listProjectNews = listProjectNews;
    }

    public List<Talents> getListTalents()
    {
        return listTalents;
    }

    public void setListTalents(List<Talents> listTalents)
    {
        this.listTalents = listTalents;
    }

    public List<Product> getListProduct()
    {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct)
    {
        this.listProduct = listProduct;
    }

    /**
     * @return
     */
    public String index()
    {
        logger.debug("enter index");

        hotword = dictBussImplService.listDictBuss(17);

        listDictBuss1 = dictBussImplService.listDictBuss(4);
        Map m = getConditionMap();
        m.put("state", 1);
        //行业资讯，展示审核通过的
        listNews = newsServiceImpl.getAllList(m);

        listDictBuss2 = dictBussImplService.listDictBuss(9);
        listProjectNews = projectNewsServiceImpl.getAllList(getConditionMap());
        
        List<DictBuss> listDictCoop = dictBussImplService.listDictBuss(16);
        
        
        if(null != listProjectNews && listProjectNews.size()>0)
        { 
            int i = listProjectNews.size()>3?3:listProjectNews.size();
            List<ProjectNews> guandList = listProjectNews.subList(0, i);
            request.setAttribute("guandList", guandList);
        }

        request.setAttribute("listDictCoop", listDictCoop);

        String value = Init.getMap().get("topstyle");

        if ("1".equals(value))
        {
            List<Ads> list1 = adsServiceImpl.getAllInfo2(1);
            request.setAttribute("list1", list1);
        }
        else if ("2".equals(value))
        {
            List<Ads> list2 = adsServiceImpl.getAllInfo2(2);
            request.setAttribute("list2", list2);
        }
        else if ("3".equals(value))
        {
            List<Ads> list2 = adsServiceImpl.getAllInfo2(2);
            request.setAttribute("list2", list2);
        }
        else
        {
            List<Ads> list1 = adsServiceImpl.getAllInfo2(1);
            request.setAttribute("list1", list1);
        }
        request.setAttribute("value", value);

        logger.debug("exit index");

        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    private Map getConditionMap()
    {
        Map conditionMap = new HashMap();
        conditionMap.put("cname", null);
        conditionMap.put("ctype", null);
        conditionMap.put("offset", 0);
        conditionMap.put("rows", 8);
        return conditionMap;

    }

    public String toPartNews()
    {
        logger.debug("enter toPartNews");

        response.setHeader("Cache-Control", "no-cache");

        listDictBuss1 = dictBussImplService.listDictBuss(4);
        listNews = newsServiceImpl.getAllList(getConditionMap());

        logger.debug("exit toPartNews");

        return SUCCESS;
    }

    public String checkPhoneNo()
    {
        logger.debug("enter checkPhoneNo");

        response.setHeader("Cache-Control", "no-cache");


        String no = request.getParameter("member.userName");


        boolean flag = memberServiceImpl.checkUserName(no);

        // 直接返回提示信息validateReturn[2] = "";

        try
        {
            //JSONArray jsarry = JSONArray.fromObject(validateReturn);

            response.getWriter().println(flag);
        }
        catch (Exception e)
        {
            logger.error("getResponse().getWriter().println error.", e);
        }

        logger.debug("exit checkPhoneNo");

        return null;
    }

    public String toPartProjectNews()
    {
        logger.debug("enter toPartProjectNews");

        response.setHeader("Cache-Control", "no-cache");
        listDictBuss2 = dictBussImplService.listDictBuss(9);
        listProjectNews = projectNewsServiceImpl.getAllList(getConditionMap());

        logger.debug("exit toPartProjectNews");

        return SUCCESS;
    }

    public String toProduct()
    {
        logger.debug("enter toProduct");

        response.setHeader("Cache-Control", "no-cache");

        String name = request.getParameter("sear");

        name = StringUtils.isBlank(name) ? null : "%" + name + "%";

        String strpage = request.getParameter("page");

        int pages = NumberUtils.toInt(strpage, 1);

        // ------------------查出多少条 商城的数据是审核通过的并且是上架的-----------------------
        Map conditionMap = new HashMap();
        conditionMap.put("search", name);
        conditionMap.put("state", 1);
        conditionMap.put("linestate", 0);
        int count = productServiceImpl.getCounts(conditionMap);

        // ------------------查出数据 商城的数据是审核通过的并且是上架的------------------------
        Map<String, Object> res = PageUtil.processPage(pages, count, 8, 5);
        Map conditionMap2 = new HashMap();
        conditionMap2.put("search", name);
        conditionMap2.put("state", 1);
        conditionMap2.put("linestate", 0);
        conditionMap2.put("offset", res.get("recordbegin"));
        conditionMap2.put("rows", res.get("pagesize"));
        listProduct = productServiceImpl.getAllProduct(conditionMap2);
        request.setAttribute("pageHtml", res.get("pageHtml"));

        logger.debug("exit toProduct");

        return SUCCESS;
    }
    
    
    public String tocompanyproduct()
    {
        logger.debug("enter tocompanyproduct");

        response.setHeader("Cache-Control", "no-cache");

        String memid = request.getParameter("memid");

        listDictBuss1 = dictBussImplService.listDictBuss(4);

        String strpage = request.getParameter("page");

        int pages = NumberUtils.toInt(strpage, 1);

        // ------------------查出多少条 商城的数据是审核通过的并且是上架的-----------------------
        Map conditionMap = new HashMap();
        conditionMap.put("coopid", memid);
        int count = newsServiceImpl.getCounts22(conditionMap);

        // ------------------查出数据 商城的数据是审核通过的并且是上架的------------------------
        Map<String, Object> res = PageUtil.processPage3(pages, count, 8, 5,null);
        Map conditionMap2 = new HashMap();
        conditionMap2.put("coopid", memid);
        conditionMap2.put("offset", res.get("recordbegin"));
        conditionMap2.put("rows", res.get("pagesize"));
        List<News> listnews = newsServiceImpl.getAllNews2(conditionMap2);
        request.setAttribute("listnews", listnews);
        request.setAttribute("pageHtml", res.get("pageHtml"));

        logger.debug("exit toProduct");

        return SUCCESS;
    }

    public String register()
    {
        logger.debug("enter register");

        listDictBuss = dictBussImplService.listDictBuss(1);

        listDictBusstype = dictBussImplService.listDictBuss(16);

        logger.debug("exit register");

        return SUCCESS;
    }

    public String toLogin()
    {
        logger.debug("enter toLogin");

        logger.debug("exit toLogin");

        return SUCCESS;
    }

    /**
     * 用户注册信息保存
     * 
     * @return
     */
    public String saveMember()
    {

        logger.debug("enter saveMember");

        member.setCode(UUID.randomUUID().toString());
        member.setCreateDate(new Date());
        member.setState(Constant.MEMBER_STATE_START_1);
        member.setFlag(Constant.FLAG_STATE);
        // -------------------
        Map<String, String> tempMap = new HashMap<String, String>();
        tempMap.put("username", member.getUserName());
        tempMap.put("password", member.getPassword());
        request.getSession().setAttribute("tempMap", tempMap);
        
        //如果存在该号码
        if(!memberServiceImpl.checkUserName(member.getUserName()))
        {
            request.setAttribute("error", "该手机号已存在");
            return ERROR;
        }

        Member mem = memberServiceImpl.signup(member);

        // Map params = ActionContext.getContext().getParameters();

        // String[] tokens = (String[])(String[])params.get("struts.token");

        // System.out.println(tokens);

        request.getSession().setAttribute("member", mem);
        
        request.setAttribute("id", mem.getId());
        
        request.setAttribute("title", "用户注册");

        logger.debug("exit saveMember");


        return SUCCESS;
    }

    public String showmessage()
    {
        logger.debug("enter showmessage");

        String title = request.getParameter("title");

        String id = request.getParameter("id");

        int idint = NumberUtils.toInt(id, 1);

        content = manacontServiceImpl.getInfoById(idint);

        request.setAttribute("title", title);

        request.setAttribute("id", id);

        logger.debug("exit showmessage");

        return SUCCESS;
    }

    public String partmessage()
    {
        logger.debug("enter partmessage");

        String title = request.getParameter("title");

        String id = request.getParameter("id");

        int idint = NumberUtils.toInt(id, 1);

        content = manacontServiceImpl.getInfoById(idint);

        request.setAttribute("title", title);

        request.setAttribute("id", id);

        logger.debug("exit partmessage");

        return SUCCESS;
    }

    public String showtabs()
    {
        response.setHeader("Cache-Control", "no-cache");

        String type = request.getParameter("type");

        int inttype = NumberUtils.toInt(type, 1);

        String strpage = request.getParameter("page");

        int pages = NumberUtils.toInt(strpage, 1);

        listDictBusstype = dictBussImplService.listDictBuss(16);

        // ------------------查出多少条------------------------
        Map conditionMap = new HashMap();
        conditionMap.put("cooptype", inttype);
        int count = memberServiceImpl.getCounts(conditionMap);

        // ------------------查出数据------------------------
        Map<String, Object> res = PageUtil.processPage(pages, count, 5, 5, "2");
        Map conditionMap2 = new HashMap();
        conditionMap2.put("cooptype", inttype);
        conditionMap2.put("offset", res.get("recordbegin"));
        conditionMap2.put("rows", res.get("pagesize"));
        cooperationList = memberServiceImpl.getAllCooperation(conditionMap2);
        request.setAttribute("pageHtml", res.get("pageHtml"));

        request.setAttribute("type", res.get("type"));

        logger.debug("exit showtabs");

        return SUCCESS;
    }

    public String refreshLoginInfo()
    {
        logger.debug("enter refreshLoginInfo");

        logger.debug("exit refreshLoginInfo");

        return SUCCESS;
    }

    public String step()
    {
        String title = request.getParameter("title");

        Member member = (Member) request.getSession().getAttribute("member");

        if (null == member)
        {
            return ERROR;
        }
        int memid = member.getId();

        request.setAttribute("id", memid);
        request.setAttribute("title", title);

        return SUCCESS;
    }

    public String savestep()
    {
        String fileName = getFileName();

        member.setLogo(fileName);

        member.setFlag(Constant.FLAG_FINISH);

        Member m = memberServiceImpl.updateStep(member);
        
        request.getSession().setAttribute("member", m);

        return result(true, fileName);
    }

    private String getFileName()
    {
        // 文件保存路径
        String path = ServletActionContext.getServletContext().getRealPath("/attach/productpic");

        String[] fileNames = null;

        File[] uploadFiles = null;

        MultiPartRequestWrapper multiWrapper = (MultiPartRequestWrapper) request;

        Enumeration<String> enu = multiWrapper.getFileParameterNames();

        String filename = "";

        String ext = "";

        File file = null;

        while (enu.hasMoreElements())
        {
            // 对每一个文件域进行遍历
            String controlName = (String) enu.nextElement();

            fileNames = multiWrapper.getFileNames(controlName);

            uploadFiles = multiWrapper.getFiles(controlName);

            for (int i = 0; i < uploadFiles.length; i++)
            {
                ext = fileNames[i].substring(fileNames[i].indexOf("."), fileNames[i].length());// 获取文件扩展名

                filename = UUID.randomUUID().toString() + ext.toLowerCase();

                file = new File(path + File.separator + filename);

                try
                {
                    AverageImageScale.resizeFix(uploadFiles[i], file, 49, 49);
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }

        return filename;
    }

    public String updateMember()
    {
        String fileName = getFileName();

        if (StringUtils.isNotEmpty(fileName))
        {

            member.setLogo(fileName);
        }
        else
        {
            fileName = member.getLogo();
        }
        
        member.setFlag(Constant.FLAG_FINISH);

        memberServiceImpl.update(member);

        // Member member =
        // (Member)request.getSession().getAttribute("member");

        request.getSession().setAttribute("member", member);

        return result(true, fileName);

    }

    public String myspace()
    {
        logger.debug("enter myspace");

        Member member = (Member) request.getSession().getAttribute("member");

        if (null == member)
        {
            return ERROR;
        }

        request.setAttribute("memberid", member.getId());

        logger.debug("exit myspace");

        return SUCCESS;
    }

    public String myspacemenu()
    {
        logger.debug("enter partmessage");

        Member sessmember = (Member) request.getSession().getAttribute("member");

        if (null == sessmember)
        {
            return ERROR;
        }

        String title = request.getParameter("title");

        String typeid = request.getParameter("typeid");

        String strid = request.getParameter("id");

        int id = NumberUtils.toInt(strid, 0);

        request.setAttribute("title", title);

        request.setAttribute("memid", strid);

        member = memberServiceImpl.getInfoById(id);
        
        if ("1".equals(typeid))
        {
            listDictBuss = dictBussImplService.listDictBuss(4);
            request.setAttribute("memid", strid);
            return "tobowen";
        }
        if ("2".equals(typeid))
        {
           
            request.setAttribute("memid", strid);
            return "topads";
        }

        if ("3".equals(typeid))
        {
            listDictBuss = dictBussImplService.listDictBuss(1);

            listDictBusstype = dictBussImplService.listDictBuss(16);

            return "baseinfo";
        }
        if ("4".equals(typeid))
        {
            request.setAttribute("id", member.getId());
            request.setAttribute("username", member.getUserName());
            return "changepass";
        }
        if ("5".equals(typeid))
        {

            prodcutsort = dictBussImplService.listDictBuss(15);
            return "productmana";
        }
        if ("6".equals(typeid))
        {
            request.setAttribute("memid", strid);
            typelist = dictBussImplService.listDictBuss(18);
            return "heyue";
        }
        if ("7".equals(typeid))
        {
            Map map = new HashMap();
            map.put("typeid", 0);
            map.put("coopid", id);
            content = memberServiceImpl.getInfoByTypeCoop(map);
            return "us";
        }
        if ("8".equals(typeid))
        {
            Map map = new HashMap();
            map.put("typeid", 1);
            map.put("coopid", id);
            content = memberServiceImpl.getInfoByTypeCoop(map);
            return "us";
        }

        logger.debug("exit partmessage");

        return SUCCESS;
    }
    
    
    public String getAgreementAjaxData()
    {


        response.setHeader("Cache-Control", "no-cache");

        String strpage = request.getParameter("page");

        String strrows = request.getParameter("rows");
        
        String coopid = request.getParameter("coopid");

        int rows = Integer.parseInt(strrows);

        int offset = (Integer.parseInt(strpage) - 1) * rows;
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String state = request.getParameter("state");
        title = StringUtils.isBlank(title) ? null : "%" + title + "%";
        type = ("").equals(type) ? null : type;
        state = ("").equals(state) ? null : state;

        Map conditionMap = new HashMap();
        conditionMap.put("coopid", coopid);
        conditionMap.put("title", title);
        conditionMap.put("type", type);
        conditionMap.put("state", state);
        
        conditionMap.put("offset", offset);
        conditionMap.put("rows", rows);

        String jsonData = agreementServiceImpl.getList(conditionMap);

        return toJsonData(jsonData);
    }


    public String updateContent()
    {
        logger.debug("enter toLoadList");

        manacontServiceImpl.updateContent(content);

        logger.debug("exit toLoadList");

        return success();
    }

    public String checkIsFinish()
    {
      
        String sid = request.getParameter("memberid");
		int id = NumberUtils.toInt(sid, 0);
		int falg = memberServiceImpl.checkIsFinish(id);
		try 
		{
			response.getWriter().println(falg);
		} 
		catch (IOException e) {
			logger.error("getResponse().getWriter().println error.", e);
		}

		return null;
    }

    public String savePass()
    {
        logger.debug("enter savePass");

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        Member m = memberServiceImpl.getInfoById(id);
        String username = request.getParameter("username");
        String oldpassword = request.getParameter("oldpass");
        String newpassword = request.getParameter("newpass");

        String res = "0";

        if (!MD5.MD5Encode(username + oldpassword).equals(m.getPassword()))
        {
            res = "2";
        }

        else
        {

            String pass = MD5.MD5Encode(username + newpassword);
            Map conditionMap = new HashMap();
            conditionMap.put("id", id);
            conditionMap.put("password", pass);
            memberServiceImpl.resetPass(conditionMap);
        }

        try
        {

            response.getWriter().println("{\"res\":" + res + "}");
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);

        }

        logger.debug("exit savePass");

        return null;
    }

    @SuppressWarnings("unchecked")
    public String company()
    {
        String strid = request.getParameter("id");
        int memid = NumberUtils.toInt(strid, 0);
        Member m = memberServiceImpl.getInfoById(memid);
        
        //不存在,或没有,返回主页
        if(0==memid || null==m)
        {
            return ERROR;
        }

        Map map = new HashMap();
        map.put("typeid", 0);
        map.put("coopid", memid);
        Content aboutus = memberServiceImpl.getInfoByTypeCoop(map);
        map.put("typeid", 1);
        map.put("coopid", memid);
        Content conus = memberServiceImpl.getInfoByTypeCoop(map);
        List<Ads> listAds = adsServiceImpl.getAllInfo2(memid);
        
        //商家页面展示的是上架的商品,下架的不展示,不限制MMPro审核.
        //在MMPro平台上展示,需要审核通过的.
        List<Product> list = productServiceImpl.getAllProductToPage(memid);
        List<Product> hotlist = new ArrayList<Product>();
        if (null == list || list.size() == 0)
        {
            list = new ArrayList<Product>();
            Product p = null;
            for (int i = 0; i < 4; i++)
            {
                p = new Product();
                p.setName("暂无产品");
                p.setTypeimg("prdefault.jpg");
                list.add(p);
            }
            hotlist = list;
        }
        else
        {
            if (list.size() > 8)
            {
                hotlist = list.subList(0, 7);
            }
            else
            {
                hotlist = list;

            }
        }
        request.setAttribute("aboutus", null==aboutus?"":aboutus.getContent());
        request.setAttribute("conus", null==conus?"":conus.getContent());
        request.setAttribute("member", m);
        request.setAttribute("list", list);
        request.setAttribute("memid", memid);
        request.setAttribute("hotlist", hotlist);
        request.setAttribute("listAds", listAds);
        

        return SUCCESS;

    }

    public String memLogin()
    {

        logger.debug("enter memLogin");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");

        Member mem = memberServiceImpl.checkMem(username, password);
        String sessCode = (String) request.getSession().getAttribute("GLY_VERIRY_CODE");
        String res = "0";

        if (!code.equals(sessCode))
        {
            res = "1";
        }

        else if (null == mem)
        {
            res = "2";
        }
        else
        {
            //审核不通过
            if (mem.getState() == 2)
            {
                res = "3";
            }
            else
            {
                Map<String, String> tempMap = new HashMap<String, String>();
                tempMap.put("username", username);
                tempMap.put("password", password);
                request.getSession().setAttribute("tempMap", tempMap);
                request.getSession().setAttribute("member", mem);
            }

        }

        try
        {

            response.getWriter().println("{\"res\":" + res + "}");
        }
        catch (IOException e)
        {
            logger.error("getResponse().getWriter().println error.", e);

        }

        logger.debug("exit memLogin");

        return null;

    }

    public String getProductDetail()
    {
        
        return SUCCESS;
    }
    
    public String logout()
    {

        logger.debug("enter logout");

        response.setHeader("Cache-Control", "no-cache");

        request.getSession().removeAttribute("member");
        request.getSession().removeAttribute("tempMap");
        // request.getSession().invalidate();

        logger.debug("exit logout");

        return success();
    }
    
    
    @SuppressWarnings("unchecked")
    public String getAgreementInfoById()
    {

        logger.debug("enter getInfoById");

        String sid = request.getParameter("id");
        
        String type = request.getParameter("type");
        
        request.setAttribute("cooparatype", type);
        
        
        
        int id = Integer.parseInt(sid);
        String opt = request.getParameter("opt");
        request.setAttribute("opt",opt);
        try
        {
            agreement = agreementServiceImpl.getInfoById(id);

        }
        catch (Exception e)
        {
            logger.debug("getInfoById()", e);

        }
        
        if("print".equals(opt))
        {
            return "printcaigou";
        }
 
        //采购合同
        if("1".equals(type))
        {
            return "viewcaigou";                
        }
        return SUCCESS;

    }

    public String error()
    {
        return SUCCESS;
    }

    public List<DictBuss> getListDictBussxu()
    {
        return listDictBussxu;
    }

    public void setListDictBussxu(List<DictBuss> listDictBussxu)
    {
        this.listDictBussxu = listDictBussxu;
    }

    public Member getMember()
    {
        return member;
    }

    public void setMember(Member member)
    {
        this.member = member;
    }

    public List<DictBuss> getHotword()
    {
        return hotword;
    }

    public void setHotword(List<DictBuss> hotword)
    {
        this.hotword = hotword;
    }

    public List<DictBuss> getProdcutsort()
    {
        return prodcutsort;
    }

    public void setProdcutsort(List<DictBuss> prodcutsort)
    {
        this.prodcutsort = prodcutsort;
    }

    public Agreement getAgreement()
    {
        return agreement;
    }

    public void setAgreement(Agreement agreement)
    {
        this.agreement = agreement;
    }

}
