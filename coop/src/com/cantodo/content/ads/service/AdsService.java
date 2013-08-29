package com.cantodo.content.ads.service;
import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Ads;
import com.cantodo.content.dto.FileUpload;

public interface AdsService {

	@SuppressWarnings("unchecked")
	String getList(Map pata);

	void add(Ads ads,String path,List<FileUpload> list);

	void update(Ads ads,String path,List<FileUpload> list);

	Ads getInfoById(int id);

	void delete(String ids);
	
	List<Ads> getAllInfo2(int type);

}
