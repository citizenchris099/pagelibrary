package com.balfour.sb4.unittests;

import java.sql.SQLException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.balfour.publishing.qa.pages.sb4.RndStringUtil;

public class string_Test {

	WebDriver driver;

	
	


	@Test
	public void stringTest001() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		
		Random rng = new Random();
		String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
		int length = 10;

		new RndStringUtil();
		String aVariable = RndStringUtil.generateString(rng, characters, length);
		String link = String
				.format("%s@fake.com",
						aVariable);
		System.out.println(link);
	}
}
