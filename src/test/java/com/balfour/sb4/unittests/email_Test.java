package com.balfour.sb4.unittests;

import org.testng.annotations.Test;

import com.balfour.publishing.qa.pages.sb4.RestUtil;
import com.balfour.publishing.qa.pages.sb4.RndStringUtil;

public class email_Test {

	public String emailGen001() {

		String url = "http://10.90.31.54:8000/users?email=";
		String expected = "{\"users\": []}";

		Boolean flag = true;
		String email = null;
		while (flag = true) {

			email = new RndStringUtil().randomPass();
			String results = new RestUtil().enfoldCheckString(url, email);

			if (expected.equals(results)) {
				System.out.println("you win");
				break;
			}
			flag = true;
		}
		return email;
	}
	
	@Test
	public void printEmail(){
		String newEmail = new email_Test().emailGen001();
		System.out.println(newEmail);
	}
}
