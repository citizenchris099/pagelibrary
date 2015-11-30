package com.scienergy.development.qa.pages.spec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import com.scienergy.development.qa.pages.Page;

/**
 * special utility class whose method are used to generate random string. x *
 * 
 * @author cmanning
 * 
 */
public class RndStringUtil {

	/**
	 * used to generate random string
	 * 
	 * @param rng
	 *            : instance of random
	 * @param characters
	 *            : characters to be used in random string
	 * @param length
	 *            : of random string
	 * @return
	 */
	public static String generateString(Random rng, String characters, int length) {
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}

	/**
	 * generates a random "fake" email address
	 * 
	 * @return : string "fake" email address
	 */
	public String randomPass() {

		Random rng = new Random();
		String characters = "ABCDEFGHIJKLMNopqrstuvwxyz1234567890";
		int length = 10;
		return RndStringUtil.generateString(rng, characters, length);
	}

	/**
	 * generates random string
	 * 
	 * @param num
	 *            : int length of the string
	 * @return
	 */
	public String RandomString(int num) {

		Random rng = new Random();
		String characters = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = num;
		return RndStringUtil.generateString(rng, characters, length);
	}

	/**
	 * used to generate a random "username"
	 * 
	 * @return
	 */
	public String RandomUName() {

		Random rng = new Random();
		String characters = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ_";
		int length = 20;
		return generateString(rng, characters, length);
	}

	public String Random2Word() {

		Random rng = new Random();
		String characters = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = 6;
		return generateString(rng, characters, length) + " " + generateString(rng, characters, length);
	}

	/**
	 * used to generate a random name
	 * 
	 * @param num
	 *            : int length of the string
	 * @return
	 */
	public String RandomName(int num) {

		Random rng = new Random();
		String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
		int length = num;
		return generateString(rng, characters, length);
	}

	/**
	 * used to generate a random 10 digit phone number
	 * 
	 * @return
	 */
	public String RandomPhone() {

		Random rng = new Random();
		String characters = "1234567890";
		int length = 10;
		return generateString(rng, characters, length);
	}

	public String curDate() {
		Date today = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("MMM dd");
		String reportDate = df.format(today);
		return reportDate.trim();
	}

	public String date(int days) {
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_YEAR, days);
		Date tomorrow = cal.getTime();
		DateFormat df = new SimpleDateFormat("M/d/yyyy");
		String reportDate = df.format(tomorrow);
		return reportDate.trim();
	}
}
