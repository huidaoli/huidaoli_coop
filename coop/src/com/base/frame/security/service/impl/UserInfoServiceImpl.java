package com.base.frame.security.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.PropertyFilter;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.frame.common.MD5;
import com.base.frame.common.SystemException;
import com.base.frame.dao.DictBussManager;
import com.base.frame.dao.RoleManager;
import com.base.frame.dao.UserInfoManager;
import com.base.frame.model.DictBuss;
import com.base.frame.model.Organization;
import com.base.frame.model.UserInfo;
import com.base.frame.model.UsersRoles;
import com.base.frame.security.service.UserInfoService;
import com.base.frame.system.PagerModel;

/**
 * [ºÚ“™√Ë ˆ]:<br/>
 * [œÍœ∏√Ë ˆ]:<br/>
 * 
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	private Log logger = LogFactory.getLog(UserInfoServiceImpl.class);

	@Autowired
	private UserInfoManager userInfoManager;

	@Autowired
	private RoleManager roleManager;

	@Autowired
	private DictBussManager dictBussManager;

	/**
	 * 
	 * [ºÚ“™√Ë ˆ]:<br/>
	 * [œÍœ∏√Ë ˆ]:<br/>
	 * 
	 * @author tangdingyi
	 * @param user
	 * @param roleIds
	 * @exception
	 * @see com.base.frame.security.service.UserInfoService#addUserInfo(com.base.frame.model.UserInfo,
	 *      java.lang.String[])
	 */
	@Override
	@Transactional
	public void addUserInfo(UserInfo user, String[] roleIds) {
		user.setPassword(MD5.MD5Encode(user.getUsername() + user.getPassword()));
		userInfoManager.addUserInfo(user);
		UsersRoles ur = null;
		for (String roleId : roleIds) {
			ur = new UsersRoles();
			ur.setUsers(user);
			ur.setRoles(roleManager.findRole(Integer.parseInt(roleId)));
			userInfoManager.addUsersRoles(ur);
		}

	}

	public List<DictBuss> listDictBuss(int type) {
		return dictBussManager.listDictBuss(type);
	}

	/**
	 * 
	 * [ºÚ“™√Ë ˆ]:<br/>
	 * [œÍœ∏√Ë ˆ]:<br/>
	 * 
	 * @author tangdingyi
	 * @param userId
	 * @exception
	 * @see com.base.frame.security.service.UserInfoService#delUserInfo(int)
	 */
	@Override
	@Transactional
	public void delUserInfo(int userId) {
		userInfoManager.delUserInfo(userId);

	}

	/**
	 * 
	 * [ºÚ“™√Ë ˆ]:<br/>
	 * [œÍœ∏√Ë ˆ]:<br/>
	 * 
	 * @author tangdingyi
	 * @param userId
	 * @return
	 * @exception
	 * @see com.base.frame.security.service.UserInfoService#searchUserRoles(int)
	 */
	public List searchUserRoles(int userId) {
		return userInfoManager.searchUserRoles(userId);
	}

	/**
	 * 
	 * [ºÚ“™√Ë ˆ]:<br/>
	 * [œÍœ∏√Ë ˆ]:<br/>
	 * 
	 * @author tangdingyi
	 * @param userId
	 * @return
	 * @exception
	 * @see com.base.frame.security.service.UserInfoService#getRolesByUserId(int)
	 */
	public List<UsersRoles> getRolesByUserId(int userId) {
		return userInfoManager.getRolesByUserId(userId);
	}

	/**
	 * 
	 * [ºÚ“™√Ë ˆ]:<br/>
	 * [œÍœ∏√Ë ˆ]:<br/>
	 * 
	 * @author tangdingyi
	 * @param userId
	 * @return
	 * @exception
	 * @see com.base.frame.security.service.UserInfoService#roleIdsByUserId(int)
	 */
	public String roleIdsByUserId(int userId) {
		List<Integer> tempList = new ArrayList<Integer>();

		List<UsersRoles> urs = searchUserRoles(userId);

		for (UsersRoles ur : urs) {
			tempList.add(ur.getRoles().getId());
		}

		return JSONArray.fromObject(tempList).toString();
	}

	/**
	 * [ºÚ“™√Ë ˆ]:<br/>
	 * [œÍœ∏√Ë ˆ]:<br/>
	 * 
	 * @author tangdingyi
	 * @param strids
	 * @exception
	 * @see com.base.frame.security.service.RoleService#delRole(java.lang.String)
	 */
	@Override
	@Transactional
	public void delUserInfo(String strids) {

		JSONArray jsonArray = JSONArray.fromObject(strids);

		int[] ids = (int[]) JSONArray.toArray(jsonArray, int.class);

		for (int id : ids) {
			List<UsersRoles> list = userInfoManager.searchUserRoles(id);
			for (UsersRoles ur : list) {
				userInfoManager.delUserRole(ur);
			}
			delUserInfo(id);
		}

	}

	@Override
	public UserInfo findUserInfo(int userId) {
		return userInfoManager.findUser(userId);
	}

	/**
	 * 
	 * [ºÚ“™√Ë ˆ]:<br/>
	 * [œÍœ∏√Ë ˆ]:<br/>
	 * 
	 * @author tangdingyi
	 * @param param
	 * @param offset
	 * @param pagesize
	 * @return
	 * @exception
	 * @see com.base.frame.security.service.UserInfoService#searchRoles(java.lang.Object,
	 *      int, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public String searchUserInfos(Object param, int offset, int pagesize) {

		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				// ∫ˆ¬‘Organization Ù–‘
				if (value != null
						&& Organization.class.isAssignableFrom(value.getClass())) {
					return true;
				}
				return false;
			}
		});

		// ¥¶¿Ì Ù–‘Œ™Date¿‡–Õ
		jsonConfig.registerJsonValueProcessor(Date.class,
				new JsonValueProcessor() {
					public Object processArrayValue(Object value,
							JsonConfig jsonConfig) {
						if (value == null) {
							return "";
						}
						return value;
					}

					public Object processObjectValue(String key, Object value,
							JsonConfig jsonConfig) {

						if (key.equals("createDate")) {
							SimpleDateFormat sdf = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss.S");
							if (null == value) {
								return "";
							}
							String res = "";
							try {
								Date d = sdf.parse(value.toString());
								res = DateFormatUtils.format(d,
										"yyyy-MM-dd HH:mm:ss");
							} catch (ParseException e) {
								logger.error("ParseException", e);
							}

							return res;
						}

						return value;

					}

				});

		jsonConfig.registerJsonValueProcessor(int.class,
				new JsonValueProcessor() {
					public Object processArrayValue(Object value,
							JsonConfig jsonConfig) {
						if (value == null) {
							return "";
						}
						return value;
					}

					public Object processObjectValue(String key, Object value,
							JsonConfig jsonConfig) {

						if (key.equals("sex")) {
							if (null == value) {
								return "";
							}
							String res = "";
							List<DictBuss> listDictBuss = listDictBuss(1);
							for (DictBuss db : listDictBuss) {
								if (db.getDictId() == Integer.parseInt(value
										.toString())) {
									return db.getDictName();
								}
							}

							return res;
						}

						return value;

					}

				});
		Map result = new HashMap();
		PagerModel pm = userInfoManager
				.searchUserInfos(param, offset, pagesize);
		List<UserInfo> datas = pm.getDatas();

		int totals = pm.getTotal();
		result.put("total", totals);
		result.put("rows", datas);
		String s = "";
		try {
			s = JSONObject.fromObject(result, jsonConfig).toString();
		} catch (DataAccessException e) {
			logger.error("JSONObject.fromObject(result,jsonConfig).toString()",
					e);
		}
		return s;

	}
	
	@Transactional
	public void updateUserInfo(UserInfo user)
	{
		user.setPassword(MD5.MD5Encode(user.getUsername() + user.getPassword()));
		userInfoManager.updateUserInfo(user);
	}

	/**
	 * [ºÚ“™√Ë ˆ]:<br/>
	 * [œÍœ∏√Ë ˆ]:<br/>
	 * 
	 * @author tangdingyi
	 * @param user
	 * @param roleIds
	 * @exception
	 * @see com.base.frame.security.service.UserInfoService#updateUserInfo(com.base.frame.model.UserInfo,
	 *      java.lang.String[])
	 */
	@Override
	@Transactional
	public void updateUserInfo(UserInfo user, String[] roleIds) {
		List<UsersRoles> list = userInfoManager.searchUserRoles(user.getId());
		for (UsersRoles ur : list) {
			userInfoManager.delUserRole(ur);
		}

		UsersRoles ur = null;
		for (String roleId : roleIds) {
			ur = new UsersRoles();
			ur.setUsers(user);
			ur.setRoles(roleManager.findRole(Integer.parseInt(roleId)));
			userInfoManager.addUsersRoles(ur);
		}

		UserInfo userinfo = userInfoManager.findUser(user.getId());
		user.setCreateDate(new Date());
		String pa = userinfo.getPassword();
		Date cd = userinfo.getCreateDate();

		try {
			/**
			 * a different object with the same identifier value was already
			 * associated with the session “ª∏ˆsession»Áπ˚¥Ê‘⁄2∏ˆUserInfo∂‘œÛ,
			 */
			BeanUtils.copyProperties(userinfo, user);
			userinfo.setPassword(pa);
			userinfo.setCreateDate(cd);
			userInfoManager.updateUserInfo(userinfo);
		} catch (Exception e) {
			logger.error("updateUserInfo(UserInfo user,String [] roleIds)", e);
		}

	}

	/**
	 * 
	 * [ºÚ“™√Ë ˆ]:<br/>
	 * [œÍœ∏√Ë ˆ]:<br/>
	 * 
	 * @author tangdingyi
	 * @param username
	 * @param password
	 * @return
	 * @exception
	 * @see com.base.frame.security.service.UserInfoService#login(java.lang.String,
	 *      java.lang.String)
	 */

	public UserInfo login(String username, String password) {
		UserInfo user = userInfoManager.login(username, password);
		if (null == user) {
			throw new SystemException("1", "not this user");
		} else if (!user.getPassword().equals(
				MD5.MD5Encode(username + password))) {
			throw new SystemException("2", "username or password is error");
		}

		return user;

	}

	@Override
	public boolean findUserInfoByName(String username) {
		UserInfo user = userInfoManager.findUserInfo(username);
		if (null == user) {
             return false;
		}
		return true;
	}

}
