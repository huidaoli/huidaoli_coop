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
		// ����Validate
		ValidatorResults results = null;
		try {
			results = validator.validate();
		} catch (ValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<String> errors = new ArrayList<String>();

		for (Object property : results.getPropertyNames()) {
			// �����������ȡ�����v��Ľ��r,���r������ÿ����֤�����������֤���,�����������У�������ӵ�������,��ô�����һ��
			// У����ʧ����,��ô����ľͲ���ִ����,����null������false
			ValidatorResult r = results.getValidatorResult(property.toString());

			// ��Field�е�keyȡ����
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
					// ͨ��MessageFormat�Ѵ�����Ϣ�ʹ�������к���һ��
					String error = MessageFormat.format(errorMsg, errorArg);
					errors.add(error);
				}
			}
		}
	}

}
