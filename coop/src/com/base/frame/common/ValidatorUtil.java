package com.base.frame.common;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.Arg;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.ValidatorResources;
import org.apache.commons.validator.ValidatorResult;
import org.apache.commons.validator.ValidatorResults;
import org.xml.sax.SAXException;

public class ValidatorUtil {

	public void test() {

		ValidatorResources resources = null;
		try {
			resources = new ValidatorResources(getClass()
					.getClassLoader().getResourceAsStream("VCustomer.xml"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Validator validator = new Validator(resources, "simpleValidateForm");
		validator.setParameter(Validator.BEAN_PARAM, new Object());
		// 进行Validate
		ValidatorResults results = null;
		try {
			results = validator.validate();
		} catch (ValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<String> errors = new ArrayList<String>();

		for (Object property : results.getPropertyNames()) {
			// 利用这个名字取出各项被v后的结果r,这个r包含了每个验证器对这项的验证结果,如果是有两个校验器叠加到这项上,那么如果第一个
			// 校验器失败了,那么后面的就不会执行了,返回null而不是false
			ValidatorResult r = results.getValidatorResult(property.toString());

			// 将Field中的key取出来
			Arg[] args = r.getField().getArgs("");
			Object[] errorArg = new Object[args.length];
			for (int i = 0; i < args.length; i++) {
				errorArg[i] = args[i].getKey();
			}

			for (Object o : r.getField().getDependencyList()) {
				if (!r.isValid((String) o)) {
					ValidatorAction action = resources
							.getValidatorAction((String) o);
					String errorMsg = action.getMsg();
					// 通过MessageFormat把错误信息和错误参数列和在一起
					String error = MessageFormat.format(errorMsg, errorArg);
					errors.add(error);
				}
			}
		}
	}

}
