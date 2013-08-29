package com.cantodo.content.dto;

import java.io.Serializable;

public class Atta implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 2145734713306960402L;

    private String attaid;

    private String attaname;

    private String newname;

    private String contcode;

    private int width;

    private int height;

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public String getContcode()
    {
        return contcode;
    }

    public void setContcode(String contcode)
    {
        this.contcode = contcode;
    }

    public String getAttaid()
    {
        return attaid;
    }

    public void setAttaid(String attaid)
    {
        this.attaid = attaid;
    }

    public String getAttaname()
    {
        return attaname;
    }

    public void setAttaname(String attaname)
    {
        this.attaname = attaname;
    }

    public String getNewname()
    {
        return newname;
    }

    public void setNewname(String newname)
    {
        this.newname = newname;
    }
}
