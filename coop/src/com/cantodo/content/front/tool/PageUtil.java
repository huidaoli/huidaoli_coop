package com.cantodo.content.front.tool;

import java.util.HashMap;
import java.util.Map;

public class PageUtil
{
    
	/**
	 * 
	 * @param pages
	 * @param count
	 * @param pagesize
	 * @param liststep
	 * @return
	 */
	public static Map<String,Object> processPage(int pages,int count,int pagesize,int liststep)
	{
		return processPage(pages, count, pagesize, liststep, null);
	}
	
	
	/**
	 * 
	 * @param pages
	 * @param count
	 * @param pagesize
	 * @param liststep
	 * @param type
	 * @return
	 */
    public static Map<String,Object> processPage(int pages,int count,int pagesize,int liststep ,String type)
    {
        StringBuilder sb = new StringBuilder();
        Map<String,Object> res = new HashMap<String,Object>();
        //int pagesize = 6;//每页显示记录数 
        //int liststep = 5;//最多显示分页页数

        int pagescount = (int) Math.ceil((double) count / pagesize);//求总页数，ceil（num）取整不小于num
        if (pagescount < pages)
        {
            pages = pagescount;//如果分页变量大总页数，则将分页变量设计为总页数
        }
        if (pages < 1)
        {
            pages = 1;//如果分页变量小于１,则将分页变量设为１
        }
        int listbegin = (pages - (int) Math.ceil((double) liststep / 2));//从第几页开始显示分页信息
        if (listbegin < 1)
        {
            listbegin = 1;
        }
        int listend = pages + liststep / 2;//分页信息显示到第几页
        if (listend > pagescount)
        {
            listend = pagescount + 1;
        }

        //显示数据部分
        int recordbegin = (pages - 1) * pagesize;//起始记录
        
        
        type = null == type?"":type;

        if (pages > 1)
        {
            sb.append("<a href='javascript:void(0)' onclick='goPage"+type+"("+ (pages - 1) +")' >上一页</a>");
        }
        //>显示上一页
        //<显示分页码
        for (int i = listbegin; i < listend; i++)
        {
            if (i != pages)
            {//如果i不等于当前页
                sb.append("<a href='javascript:void(0)' onclick='goPage"+type+"("+ i + ")'>" + i + "</a>");
            }
            else
            {
                if(pagescount!=1)
                {
                    sb.append("<span class='active_smk_link'>" + i + "</span>");
                }
                
            }
        }//显示分页码>
        //<显示下一页
        if (pages != pagescount && pagescount!=0)
        {
            sb.append("<a href='javascript:void(0)' onclick='goPage"+type+"(" + (pages + 1) + ")' >下一页</a>");
        }
        
        res.put("pageHtml", sb.toString()); 
        res.put("recordbegin", recordbegin);
        res.put("pagesize", pagesize);
        
        return res;
        
    }
    
    
    public static Map<String,Object> processPage3(int pages,int count,int pagesize,int liststep ,String type)
    {
        StringBuilder sb = new StringBuilder();
        Map<String,Object> res = new HashMap<String,Object>();
        //int pagesize = 6;//每页显示记录数 
        //int liststep = 5;//最多显示分页页数

        int pagescount = (int) Math.ceil((double) count / pagesize);//求总页数，ceil（num）取整不小于num
        if (pagescount < pages)
        {
            pages = pagescount;//如果分页变量大总页数，则将分页变量设计为总页数
        }
        if (pages < 1)
        {
            pages = 1;//如果分页变量小于１,则将分页变量设为１
        }
        int listbegin = (pages - (int) Math.ceil((double) liststep / 2));//从第几页开始显示分页信息
        if (listbegin < 1)
        {
            listbegin = 1;
        }
        int listend = pages + liststep / 2;//分页信息显示到第几页
        if (listend > pagescount)
        {
            listend = pagescount + 1;
        }

        //显示数据部分
        int recordbegin = (pages - 1) * pagesize;//起始记录
        
        
        type = null == type?"":type;

        if (pages > 1)
        {
            sb.append("<span class='inactive'><a href='javascript:void(0)' onclick='goPage"+type+"("+ (pages - 1) +")' >上一页</a></span>");
        }
        //>显示上一页
        //<显示分页码
        for (int i = listbegin; i < listend; i++)
        {
            if (i != pages)
            {//如果i不等于当前页
                sb.append("<span class='inactive'><a href='javascript:void(0)' onclick='goPage"+type+"("+ i + ")'>" + i + "</a></span>");
            }
            else
            {
                if(pagescount!=1)
                {
                    sb.append("<span class='selected'><a href='javascript:void(0)'>" + i + "</a></span>");
                }
                
            }
        }//显示分页码>
        //<显示下一页
        if (pages != pagescount && pagescount!=0)
        {
            sb.append("<span class='inactive'><a href='javascript:void(0)' onclick='goPage"+type+"(" + (pages + 1) + ")' >下一页</a></span>");
        }
        
        res.put("pageHtml", sb.toString()); 
        res.put("recordbegin", recordbegin);
        res.put("pagesize", pagesize);
        
        return res;
        
    }

}
