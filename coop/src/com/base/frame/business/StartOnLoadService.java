package com.base.frame.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.frame.business.service.SysService;
import com.base.frame.model.SysConfig;
import com.base.frame.system.PagerModel;
import com.cantodo.content.bgimg.service.BgImgService;

@Service("startOnLoadService")
public class StartOnLoadService {
	
	
	

	@Autowired
	private SysService sysService;
	
	@Autowired
    private BgImgService bgimgServiceImpl;

	public void loadData() {
		
		PagerModel pm = sysService.getList();
		
		List d = pm.getDatas();
		
		SysConfig sc = null;
		
		for(int i=0;i<d.size();i++)
		{
			sc = (SysConfig)d.get(i);
			Init.getMap().put(sc.getKeyword(), sc.getValue());
		}
		String url = bgimgServiceImpl.getUsedBgImg(1);
		Init.imgmap.put(1, url);
		url = bgimgServiceImpl.getUsedBgImg(2);
		Init.imgmap.put(2, url);
	
		
	}


}
