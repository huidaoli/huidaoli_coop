package com.base.frame.model;

import java.util.Set;

/**
 * 
 * [¼òÒªÃèÊö]:<br/>
 * [ÏêÏ¸ÃèÊö]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
public class Organization
{

    private int id;

    private String name;

    private String description;

    private Organization parent;

    private Set<Organization> children;

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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Organization getParent()
    {
        return parent;
    }

    public void setParent(Organization parent)
    {
        this.parent = parent;
    }

    public Set<Organization> getChildren()
    {
        return children;
    }

    public void setChildren(Set<Organization> children)
    {
        this.children = children;
    }

}
