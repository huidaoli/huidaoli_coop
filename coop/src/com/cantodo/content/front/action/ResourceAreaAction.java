package com.cantodo.content.front.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
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
import com.cantodo.content.dto.Resource;
import com.cantodo.content.front.tool.PageUtil;
import com.cantodo.content.manacont.service.ManacontService;
import com.cantodo.content.resource.service.ResourceService;

/**
 * @author tdy 资源专区
 */
@Controller("resourceAreaAction")
@Scope("prototype")
public class ResourceAreaAction extends BaseAction {

	/**
     * 
     */
	private static final long serialVersionUID = 7820211454620497107L;

	private Log logger = LogFactory.getLog(ResourceAreaAction.class);

	@Autowired
	private ManacontService manacontServiceImpl;

	private Content content;

	@Autowired
	private AdsService adsServiceImpl;

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	/**
	 * @return
	 */
	public String toResourceArea() {

		content = manacontServiceImpl.getInfoById(6);
		
		List<Ads> list1 = adsServiceImpl.getAllInfo2(1);

		List<Ads> list2 = adsServiceImpl.getAllInfo2(2);

		request.setAttribute("list1", list1);

		request.setAttribute("list2", list2);

		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String toResourceProject() {

		logger.debug("enter toResourceProject");

		logger.debug("exit toResourceProject");

		return SUCCESS;
	}

}
