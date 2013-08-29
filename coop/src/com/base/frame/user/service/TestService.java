package com.base.frame.user.service;

import com.base.frame.domain.Test;

public interface TestService {

	public Test getTestByname(String username);

	public void insertTest(Test test);

}
