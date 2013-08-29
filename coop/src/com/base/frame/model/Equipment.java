package com.base.frame.model;

import java.util.Set;

/**
 * [¼òÒªÃèÊö]:<br/> 
 * [ÏêÏ¸ÃèÊö]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 15, 2011
 */
public class Equipment
{

    private int id;

    private String name;
    
    private int moduleType;

    private String url;

    private int orderNo;

    private String sn;

    private Equipment parent;

    private Set<Equipment> children;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getModuleType()
    {
        return moduleType;
    }

    public void setModuleType(int moduleType)
    {
        this.moduleType = moduleType;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public int getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(int orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getSn()
    {
        return sn;
    }

    public void setSn(String sn)
    {
        this.sn = sn;
    }

    public Equipment getParent()
    {
        return parent;
    }

    public void setParent(Equipment parent)
    {
        this.parent = parent;
    }

    public Set<Equipment> getChildren()
    {
        return children;
    }

    public void setChildren(Set<Equipment> children)
    {
        this.children = children;
    }
}
