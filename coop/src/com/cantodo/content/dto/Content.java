package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;

public class Content implements Serializable
{

    /**
     * [¼òÒªÃèÊö]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = 7748256375558800663L;
    
    private int id;
    
    private String content;
    
    private Date createdate;
    
    private int typeid;
    
    private int coopid;

    public int getCoopid()
    {
        return coopid;
    }

    public void setCoopid(int coopid)
    {
        this.coopid = coopid;
    }

    public int getTypeid()
    {
        return typeid;
    }

    public void setTypeid(int typeid)
    {
        this.typeid = typeid;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Date getCreatedate()
    {
        return createdate;
    }

    public void setCreatedate(Date createdate)
    {
        this.createdate = createdate;
    }


}
