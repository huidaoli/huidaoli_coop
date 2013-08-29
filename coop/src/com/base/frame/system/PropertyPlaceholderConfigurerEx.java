package com.base.frame.system;

import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.huawei.bme.commons.encryption.EncryptTool;

public class PropertyPlaceholderConfigurerEx extends
		PropertyPlaceholderConfigurer {

	private boolean secutiry = false;

	private EncryptTool eTool = new EncryptTool();

	protected String resolvePlaceholder(String placeholder, Properties props) {

		String placeholderValue = props.getProperty(placeholder);

		if (this.secutiry) {

			if (placeholder.equals("jdbc.password")) {
				placeholderValue = deEncrypt(placeholderValue);
			}

		}

		return placeholderValue;

	}

	public boolean isSecutiry() {

		return secutiry;

	}

	public void setSecutiry(boolean secutiry) {

		this.secutiry = secutiry;

	}

	private String deEncrypt(String miwen) {

		String mingwen = "";
		
		try {
			
			mingwen = eTool.parseEncrypt(miwen);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return mingwen;

	}

}
