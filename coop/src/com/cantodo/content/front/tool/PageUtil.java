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
        //int pagesize = 6;//ÿҳ��ʾ��¼�� 
        //int liststep = 5;//�����ʾ��ҳҳ��

        int pagescount = (int) Math.ceil((double) count / pagesize);//����ҳ����ceil��num��ȡ����С��num
        if (pagescount < pages)
        {
            pages = pagescount;//�����ҳ��������ҳ�����򽫷�ҳ�������Ϊ��ҳ��
        }
        if (pages < 1)
        {
            pages = 1;//�����ҳ����С�ڣ�,�򽫷�ҳ������Ϊ��
        }
        int listbegin = (pages - (int) Math.ceil((double) liststep / 2));//�ӵڼ�ҳ��ʼ��ʾ��ҳ��Ϣ
        if (listbegin < 1)
        {
            listbegin = 1;
        }
        int listend = pages + liststep / 2;//��ҳ��Ϣ��ʾ���ڼ�ҳ
        if (listend > pagescount)
        {
            listend = pagescount + 1;
        }

        //��ʾ���ݲ���
        int recordbegin = (pages - 1) * pagesize;//��ʼ��¼
        
        
        type = null == type?"":type;

        if (pages > 1)
        {
            sb.append("<a href='javascript:void(0)' onclick='goPage"+type+"("+ (pages - 1) +")' >��һҳ</a>");
        }
        //>��ʾ��һҳ
        //<��ʾ��ҳ��
        for (int i = listbegin; i < listend; i++)
        {
            if (i != pages)
            {//���i�����ڵ�ǰҳ
                sb.append("<a href='javascript:void(0)' onclick='goPage"+type+"("+ i + ")'>" + i + "</a>");
            }
            else
            {
                if(pagescount!=1)
                {
                    sb.append("<span class='active_smk_link'>" + i + "</span>");
                }
                
            }
        }//��ʾ��ҳ��>
        //<��ʾ��һҳ
        if (pages != pagescount && pagescount!=0)
        {
            sb.append("<a href='javascript:void(0)' onclick='goPage"+type+"(" + (pages + 1) + ")' >��һҳ</a>");
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
        //int pagesize = 6;//ÿҳ��ʾ��¼�� 
        //int liststep = 5;//�����ʾ��ҳҳ��

        int pagescount = (int) Math.ceil((double) count / pagesize);//����ҳ����ceil��num��ȡ����С��num
        if (pagescount < pages)
        {
            pages = pagescount;//�����ҳ��������ҳ�����򽫷�ҳ�������Ϊ��ҳ��
        }
        if (pages < 1)
        {
            pages = 1;//�����ҳ����С�ڣ�,�򽫷�ҳ������Ϊ��
        }
        int listbegin = (pages - (int) Math.ceil((double) liststep / 2));//�ӵڼ�ҳ��ʼ��ʾ��ҳ��Ϣ
        if (listbegin < 1)
        {
            listbegin = 1;
        }
        int listend = pages + liststep / 2;//��ҳ��Ϣ��ʾ���ڼ�ҳ
        if (listend > pagescount)
        {
            listend = pagescount + 1;
        }

        //��ʾ���ݲ���
        int recordbegin = (pages - 1) * pagesize;//��ʼ��¼
        
        
        type = null == type?"":type;

        if (pages > 1)
        {
            sb.append("<span class='inactive'><a href='javascript:void(0)' onclick='goPage"+type+"("+ (pages - 1) +")' >��һҳ</a></span>");
        }
        //>��ʾ��һҳ
        //<��ʾ��ҳ��
        for (int i = listbegin; i < listend; i++)
        {
            if (i != pages)
            {//���i�����ڵ�ǰҳ
                sb.append("<span class='inactive'><a href='javascript:void(0)' onclick='goPage"+type+"("+ i + ")'>" + i + "</a></span>");
            }
            else
            {
                if(pagescount!=1)
                {
                    sb.append("<span class='selected'><a href='javascript:void(0)'>" + i + "</a></span>");
                }
                
            }
        }//��ʾ��ҳ��>
        //<��ʾ��һҳ
        if (pages != pagescount && pagescount!=0)
        {
            sb.append("<span class='inactive'><a href='javascript:void(0)' onclick='goPage"+type+"(" + (pages + 1) + ")' >��һҳ</a></span>");
        }
        
        res.put("pageHtml", sb.toString()); 
        res.put("recordbegin", recordbegin);
        res.put("pagesize", pagesize);
        
        return res;
        
    }

}
