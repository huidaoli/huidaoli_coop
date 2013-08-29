package com.base.frame.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.frame.business.Init;
import com.base.frame.business.StartOnLoadService;
import com.base.frame.business.service.SysService;
import com.base.frame.dao.SysManager;
import com.base.frame.model.SysConfig;
import com.base.frame.system.PagerModel;

@Service
public class SysServiceImpl implements SysService {

	@Autowired
	private SysManager sysManager;

	@Autowired
	private StartOnLoadService startOnLoadService;

	@SuppressWarnings("unchecked")
	@Override
	public String getJsonData() {
		PagerModel pm = sysManager.getList();

		Map result = new HashMap();

		List datas = pm.getDatas();

		int totals = pm.getTotal();

		result.put("total", totals);

		result.put("rows", datas);

		return JSONObject.fromObject(result).toString();

	}

	@Override
	public SysConfig getSysConfigByKeyword(String keyword) {
		return sysManager.getSysConfigByKeyword(keyword);
	}

	@Override
	public String getPropertyValueByKeyword(String keyword) {
		return getSysConfigByKeyword(keyword).getValue();
	}

	@Override
	@Transactional
	public void save(String jsonData) {

		JSONArray jsonArray =null;
		try {
			jsonArray = JSONArray.fromObject(jsonData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SysConfig[] sysConfigs = (SysConfig[]) JSONArray.toArray(jsonArray,
				SysConfig.class);

		// System.out.println(sysConfigs);
		sysManager.save(sysConfigs);

		Init.getMap().clear();

		List d = getList().getDatas();

		SysConfig sc = null;

		for (int i = 0; i < d.size(); i++) {
			sc = (SysConfig) d.get(i);
			Init.getMap().put(sc.getKeyword(), sc.getValue());
		}

	}

	public PagerModel getList() {
		return sysManager.getList();
	}

}
