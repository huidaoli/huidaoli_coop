package com.base.frame.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.frame.domain.Test;
import com.base.frame.persistence.TestMapper;

@Component("testServiceImpl")
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestMapper testMapper;

	@Override
	public Test getTestByname(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertTest(Test test) {
		
		testMapper.insertTest(test);
		
	}

}
