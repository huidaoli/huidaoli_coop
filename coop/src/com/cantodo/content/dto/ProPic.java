package com.cantodo.content.dto;

import java.io.Serializable;

public class ProPic implements Serializable
{
    /**
     * [¼òÒªÃèÊö]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = -1083185598966835761L;

    private int id;

    private String productcode;

    private int priority;

    private String scaledpath;

    private String path;

    private String description;
    
    public ProPic()
    {
    }


    public ProPic(String productcode, int priority, String path, String scaledpath, String description)
    {
        this.productcode = productcode;
        this.priority = priority;
        this.scaledpath = scaledpath;
        this.path = path;
        this.description = description;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getProductcode()
    {
        return productcode;
    }

    public void setProductcode(String productcode)
    {
        this.productcode = productcode;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getScaledpath()
    {
        return scaledpath;
    }

    public void setScaledpath(String scaledpath)
    {
        this.scaledpath = scaledpath;
    }
}
