package com.cantodo.content.member.service;

import java.util.List;
import java.util.Map;

import com.cantodo.content.dto.Content;
import com.cantodo.content.dto.Cooperation;
import com.cantodo.content.dto.MemClass;
import com.cantodo.content.dto.MemProject;
import com.cantodo.content.dto.Member;

public interface MemberService
{

    @SuppressWarnings("unchecked")
    String getList(Map param);

    boolean add(Member member);

    Member signup(Member member);

    boolean checkEmail(String username);

    Member checkMem(String username, String password);

    void update(Member member);
    
    Member updateStep(Member member);

    Member getInfoById(int id);

    List<Map<String, String>> getClassInfo(int memid);
    
    List<Map<String,String>> getProjectInfoList(int memid);

    void delete(String ids);


    void lockorunlock(Map param);

    void resetPass(Map param);
    
    boolean checkUserName(String userName);

    void stateOpt(String idarr, int state);

    void saveFphone(int iid, String fphone);
    
    Content getInfoByTypeCoop(Map map);

    List<Cooperation> getAllCooperation(Map conditionMap2);

    int getCounts(Map conditionMap);

    int checkIsFinish(int id);
}
