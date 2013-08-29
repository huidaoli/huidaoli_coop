package com.cantodo.content.front.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.base.frame.common.BaseAction;
import com.base.frame.model.DictBuss;
import com.base.frame.security.service.DictBussService;
import com.cantodo.content.ads.service.AdsService;
import com.cantodo.content.dto.Ads;
import com.cantodo.content.dto.Content;
import com.cantodo.content.dto.Member;
import com.cantodo.content.dto.PracticeResult;
import com.cantodo.content.dto.PracticeSys;
import com.cantodo.content.dto.Scrollinfo;
import com.cantodo.content.front.tool.PageUtil;
import com.cantodo.content.manacont.service.ManacontService;
import com.cantodo.content.practiceresult.service.PracticeResultService;
import com.cantodo.content.practicesys.service.PracticeSysService;
import com.cantodo.content.project.service.ProjectService;
import com.cantodo.content.scrollinfo.service.ScrollinfoService;

/**
 * @author tdy 管理专区
 */
@Controller("manageAreaAction")
@Scope("prototype")
public class ManageAreaAction extends BaseAction {

	/**
     * 
     */
	private static final long serialVersionUID = 9125781734934850000L;

	private Log logger = LogFactory.getLog(ManageAreaAction.class);
	@Autowired
	private ManacontService manacontServiceImpl;

	@Autowired
	private AdsService adsServiceImpl;

	private Content content;

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	/**
	 * @return
	 */
	public String toManagee() {

		logger.debug("enter toManagee");

		content = manacontServiceImpl.getInfoById(5);

		List<Ads> list1 = adsServiceImpl.getAllInfo2(1);

		List<Ads> list2 = adsServiceImpl.getAllInfo2(2);
		
		List<Ads> list3 = adsServiceImpl.getAllInfo2(3);

		List<Ads> list4 = adsServiceImpl.getAllInfo2(4);
		
		List<Ads> list5 = adsServiceImpl.getAllInfo2(5);


		request.setAttribute("list1", list1);

		request.setAttribute("list2", list2);
		
		request.setAttribute("list3", list3);

		request.setAttribute("list4", list4);
		
		request.setAttribute("list5", list5);


		logger.debug("exit toManagee");

		return SUCCESS;
	}

}
