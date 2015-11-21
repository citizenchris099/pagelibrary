package com.scienergy.development;

import java.util.Map;

public class Test_Environment {

	private String environment = "http://tasking.scienergydev.com/";
	private String home = "";
	Test_EnvironmentPOJO te0;

	public Test_Environment() {
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			if (envName.equals("spec_test_url"))
				environment = env.get(envName);
		}
	}

	public Test_EnvironmentPOJO slugNAction() {

		te0 = new Test_EnvironmentPOJO();
		te0.setHome(home);
		return te0;
	}

	public String envUrl(String slug) {
		return environment + slug;
	}
}