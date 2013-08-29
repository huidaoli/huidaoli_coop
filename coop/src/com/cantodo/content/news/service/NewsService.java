package com.cantodo.content.news.service;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.News;

public interface NewsService {
	
     String searchNewsInfo(Map param);
     
     String searchNewsInfo2(Map param);

     void addNews(News news,String path,String datePath);
	 
	 void updateNews(News news,String path, String datePath);
	 
	 News findNews(int id);
	 
	 void deleteNews(String id);
	 
	 List<News> getAllList(Map param);
	 
	 List<News> getAllInfo(Map pata);
	 
	 List<News> getAllNews2(Map param);
	 
	 int getCounts22(Map param);
	 
	 int getCounts2();

	void stateOpt(String idarr, int state);

	void setTop(String idarr, int state);

}
