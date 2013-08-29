package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6674904325080759536L;
	
	private int id;
	
	private int type;
	
	private String name;
	
	private Date createDate;
	
	private String contcode;
	
	private String content;
	
	private String htmlpath;
	
	private int state;
	
	private int coopid;
	
	private Date optddtime;
	
	private int zhiding;
	
	
	//-------------------------
	
	private String typename;
	
	private String coopname;
	

    public Date getOptddtime() {
		return optddtime;
	}

	public void setOptddtime(Date optddtime) {
		this.optddtime = optddtime;
	}

	public int getState()
    {
        return state;
    }

    public void setState(int state)
    {
        this.state = state;
    }

    public int getCoopid()
    {
        return coopid;
    }

    public void setCoopid(int coopid)
    {
        this.coopid = coopid;
    }

    public String getCoopname()
    {
        return coopname;
    }

    public void setCoopname(String coopname)
    {
        this.coopname = coopname;
    }

    public String getHtmlpath() {
		return htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContcode() {
		return contcode;
	}

	public void setContcode(String contcode) {
		this.contcode = contcode;
	}

    public String getTypename()
    {
        return typename;
    }

    public void setTypename(String typename)
    {
        this.typename = typename;
    }

	public int getZhiding() {
		return zhiding;
	}

	public void setZhiding(int zhiding) {
		this.zhiding = zhiding;
	}



}
