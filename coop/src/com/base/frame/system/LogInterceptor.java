package com.base.frame.system;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Pointcut("execution(public * com.base.frame.security.service..*.*(..))")
	public void method() {

	}

	@AfterThrowing(pointcut = "method()", throwing = "e")
	public void doAfterThrowing(JoinPoint jp, Throwable e) {
		System.out.println("出现异常:" + e.getMessage());
		System.out.println(e.getClass().getName());
		System.out.println("异常所在类:" + jp.getTarget().getClass().getName());
		System.out.println("" + jp.getSignature().getName() + "方法 throw exception");
		// logger.error("错误！ error级别的！！！"+e.getMessage());
		logger.error("Oops===" + jp.getTarget().getClass().getName() + "中的" + jp.getSignature().getName() + "方法抛出" + e.getClass().getName()
				+ "异常");
		System.out.println("参数:");
		if (jp.getArgs() != null && jp.getArgs().length > 0) {
			for (int i = 0; i < jp.getArgs().length; i++) {
				System.out.println(jp.getArgs()[i].toString());
				logger.error("参数：--" + jp.getArgs()[i].toString());
			}
		}
	}

	// 方法执行之前，先执行这个方法
	@Before("method()")
	public void before(JoinPoint jp) {
		String className = jp.getThis().toString();
		String methodName = jp.getSignature().getName(); // 获得方法名
		if(logger.isInfoEnabled())
		{
			logger.info("Enter "+jp.getTarget().getClass().getName() + " : " + jp.getSignature().getName());
		}
	
		System.out.println("====位于：" + className);
		System.out.println("====调用" + methodName + "方法-开始！");
		Object[] args = jp.getArgs(); // 获得参数列表
		if (args.length <= 0) {
			System.out.println("====" + methodName + "方法没有参数");
		} else {
			for (int i = 0; i < args.length; i++) {
				System.out.println("====参数  " + (i + 1) + "：" + args[i]);
			}
		}

	}

	@AfterReturning("method()")
	public void AfterReturning(JoinPoint jp) {
		
	
		System.out.println("====" + jp.getSignature().getName() + "方法-结束！");
		System.out.println("=====================================");
		
		if(logger.isInfoEnabled())
		{
			logger.info("Exit "+jp.getTarget().getClass().getName() + " : " + jp.getSignature().getName());
		}

	}
}
