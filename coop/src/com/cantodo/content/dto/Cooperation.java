package com.cantodo.content.dto;

import java.io.Serializable;

public class Cooperation implements Serializable
{

    /**
     * [¼òÒªÃèÊö]:
     * 
     * @author tangdingyi
     */
    private static final long serialVersionUID = 2239558290356532566L;

    private int id;

    private int type;

    private String name;

    private String address;

    private String phone;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

}
