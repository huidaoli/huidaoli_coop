package com.base.frame.model;

import java.util.Set;

/**
 * [¼òÒªÃèÊö]:<br/> 
 * [ÏêÏ¸ÃèÊö]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 15, 2011
 */
public class Module
{

    private int id;

    private String name;
    
    private int moduleType;

    private String url;

    private int orderNo;

    private String sn;

    private Module parent;

    private Set<Module> children;


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

    public Module getParent()
    {
        return parent;
    }

    public void setParent(Module parent)
    {
        this.parent = parent;
    }

    public Set<Module> getChildren()
    {
        return children;
    }

    public void setChildren(Set<Module> children)
    {
        this.children = children;
    }
}
