package com.base.frame.dao;

import java.util.List;

import com.base.frame.model.Organization;


/**
 * 
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
public interface OrgManager {
	
	/**
	 * 添加机构信息，如果parentId为0，则添加的是顶级机构
	 * 需要自动生成机构唯一编号
	 * @param org 机构信息
	 * @param parentId 父机构标识
	 */
	public int addOrg(Organization org);
	
	/**
	 * 删除机构信息，如果机构下面有子机构或机构下面有人员信息，则不允许删除
	 * @param orgId 机构标识
	 */
	public void delOrg(int orgId);
	
	
	public void updateOrg(Organization org);
	
	/**
	 * 查询特定的机构
	 * @param orgId
	 * @return
	 */
	public Organization findOrg(int orgId);
	
	/**
	 * 根据父机构标识查询其下的子机构列表
	 * 如果parentId为0，则查询顶级机构列表
	 * @param parentId 父机构标识
	 * @return 集合的元素是Organization对象
	 */
	public List searchOrgsData(int parentId);
}
