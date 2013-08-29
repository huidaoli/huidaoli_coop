package com.cantodo.content.persistence;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Cooperation;
import com.cantodo.content.dto.Member;

/**
 * 
 * @author tdy
 * 
 */
public interface MemberMapper {

	Member getInfoById(int id);
	
	
	List<Member> getAllInfo(Map pata);
	
	int getCounts(Map param);
	
	int getMemberCountByUserName(String userName);
	
	Member getMemberByUserName(String userName);
	
	Member getMem(Map<String,String>  map);

	void insert(Member member);

	void update(Member member);
	
	void updateStep(Member member);
	
	void delete(int id);
	
	List<Map<String,String>> getClassInfoList(int memid);
	
	List<Map<String,String>> getProjectInfoList(int memid);
	
	
	void lockorunlock(Map param);
	
	void resetPass(Map param);
	
	List<Member> getMemByClassId(int classid);
	
	List<Member> getMemByProjectId(int projectid);
	
	
	List<Map> getSHInfo();
	
	List<Map> getSHInfo2();


    void stateOpt(Map cmap);

    void saveFphone(Map cmap);


    List<Cooperation> getAllCooperation(Map conditionMap2);


    int getCountsByCoonType(Map conditionMap);
    
    int getIsFinish(int id);
	
	
	

}
