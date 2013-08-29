package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;

public class Scrollinfo implements Serializable
{
    /**
     * [¼òÒªÃèÊö]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = -6382863052153434648L;


    private int id;

    private String imgid;
    
    private String name;
    
    private Date createDate;
    
    private String contcode;

    private String ctype;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getImgid()
    {
        return imgid;
    }

    public void setImgid(String imgid)
    {
        this.imgid = imgid;
    }

    public String getCtype()
    {
        return ctype;
    }

    public void setCtype(String ctype)
    {
        this.ctype = ctype;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public String getContcode()
    {
        return contcode;
    }

    public void setContcode(String contcode)
    {
        this.contcode = contcode;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


}
