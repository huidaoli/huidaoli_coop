package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;

public class RandDSys implements Serializable {




	
	/**
     * [��Ҫ����]:
     * @author tangdingyi
     */
    private static final long serialVersionUID = 4073721268542592084L;

    private int id;
	
	private int type;
	
	private String name;
	
	private Date createDate;
	
	private String contcode;
	
	private String content;

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

}
