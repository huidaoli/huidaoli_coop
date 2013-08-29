package com.cantodo.content.bgimg.service;
import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.BgImg;
import com.cantodo.content.dto.FileUpload;

public interface BgImgService {

	@SuppressWarnings("unchecked")
	String getList(Map pata);

	void add(BgImg ads,String path,List<FileUpload> list);

	void update(BgImg ads,String path,List<FileUpload> list);

	BgImg getInfoById(int id);

	void delete(String ids);
	
	List<BgImg> getAllInfo2(int type);
	
	void usedBgImg(int id,int type);
	
	String getUsedBgImg(int type);

}
