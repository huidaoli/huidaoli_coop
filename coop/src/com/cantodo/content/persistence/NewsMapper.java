package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.News;

/**
 * 
 * @author tdy
 * 
 */
public interface NewsMapper {


	News getNewsById(int id);
	
	List<News> getAllNews(Map pata);
	
	int getCounts(Map param);
	
    List<News> getAllNews2(Map pata);
    
    int getCounts22(Map param);

	void insert(News news);

	void update(News news);
	
	void delete(int id);
	
	int getCounts2();
	
	void updateHtmlpath(Map pata);
	
	News getNewsByContcode(String contcode);
	
	void stateOpt(Map map);

	void setZd(Map map);

}
