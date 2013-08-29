package com.base.frame.model;

import java.util.Date;

public class LoginMess
{
    private int id;

    private String username;

    private String preLoginIp;

    private Date preLoginDate;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPreLoginIp()
    {
        return preLoginIp;
    }

    public void setPreLoginIp(String preLoginIp)
    {
        this.preLoginIp = preLoginIp;
    }

    public Date getPreLoginDate()
    {
        return preLoginDate;
    }

    public void setPreLoginDate(Date preLoginDate)
    {
        this.preLoginDate = preLoginDate;
    }

}
