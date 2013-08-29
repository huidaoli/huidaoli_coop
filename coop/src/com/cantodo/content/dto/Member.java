package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 2351180554448022316L;

    // 用户id
    private int id;

    // 用户code
    private String code;

    // 手机号作为uerName
    private String userName;

    private String password;

    // 真实姓名
    private String realName;

    // 合作类型
    private int cooptype;

    // 备用号码
    private String mphone;

    //400电话
    private String fphone;
    
    // 电邮
    private String email;

    // 地址
    private String address;
    
    //地区
    private String area;

    // 性别
    private int sex;
    
    //公司或单位名称
    private String companyname;

    //创建日期
    private Date createDate;

    //备注
    private String remark;
    
    //品牌LOGO
    private String logo;

    // 用户状态
    private int state;

    // 是否完成step信息
    private int flag;

    public String getFphone()
    {
        return fphone;
    }

    public void setFphone(String fphone)
    {
        this.fphone = fphone;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getFlag()
    {
        return flag;
    }

    public void setFlag(int flag)
    {
        this.flag = flag;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getRealName()
    {
        return realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public int getSex()
    {
        return sex;
    }

    public void setSex(int sex)
    {
        this.sex = sex;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public String getMphone()
    {
        return mphone;
    }

    public void setMphone(String mphone)
    {
        this.mphone = mphone;
    }

    public int getCooptype()
    {
        return cooptype;
    }

    public void setCooptype(int cooptype)
    {
        this.cooptype = cooptype;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCompanyname()
    {
        return companyname;
    }

    public void setCompanyname(String companyname)
    {
        this.companyname = companyname;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

}
