package com.cantodo.content.dto;

import java.io.Serializable;
import java.util.Date;

public class OpenClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5819103919924004602L;

	private int id;

	private String name;

	private int classType;

	private Date createDate;

	private String content;

	private int sumnum;

	private String contcode;

	public String getContcode() {
		return contcode;
	}

	public void setContcode(String contcode) {
		this.contcode = contcode;
	}

	public int getSumnum() {
		return sumnum;
	}

	public void setSumnum(int sumnum) {
		this.sumnum = sumnum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassType() {
		return classType;
	}

	public void setClassType(int classType) {
		this.classType = classType;
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

}
