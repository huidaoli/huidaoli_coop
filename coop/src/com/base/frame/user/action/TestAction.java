package com.base.frame.user.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.base.frame.domain.Test;
import com.base.frame.user.service.TestService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * test
 * 
 * @author tangdingyi
 * 
 */
@Component("test")
@Scope("prototype")
public class TestAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8578476395963936930L;
	
	
	private TestService testService;
	
	public TestService getTestService() {
		return testService;
	}

	@Resource(name="testServiceImpl")
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	public String getTest()
	{
		System.out.println("ddddddddddddddddd");
		Test test = new Test();
		test.setId(10001);
		test.setName("name");
		test.setAddress("dddddddddd");
		testService.insertTest(test);
		
		return SUCCESS;
	}

	


	
	

}
