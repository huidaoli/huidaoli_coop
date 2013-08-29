package com.base.frame.persistence;

import com.base.frame.domain.Test;


/**
 * 
 * [¼òÒªÃèÊö]:<br/>
 * [ÏêÏ¸ÃèÊö]:<br/>
 *
 * @author tangdingyi
 * @version 1.0, Sep 9, 2011
 */
public interface TestMapper {
	
	
	  Test getTestByname(String username);

	  void insertTest(Test Test);
	  
	  void updateTest(Test Test);

}
