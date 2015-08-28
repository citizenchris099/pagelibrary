package com.balfour.publishing.qa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProfilePOJO {

	private String uName;
	private String email;
	private String fName;
	private String lName;
	private String phone;
	private String dName;
	private String fBook;
	private String google;
	private String yahoo;
	private String twitter;
	private String linkedin;
	private String pinterest;
	private String instagram;
	private String pword;
	private String msg;
	private String bio;

	public ProfilePOJO() {

	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getfBook() {
		return fBook;
	}

	public void setfBook(String fBook) {
		this.fBook = fBook;
	}

	public String getGoogle() {
		return google;
	}

	public void setGoogle(String google) {
		this.google = google;
	}

	public String getYahoo() {
		return yahoo;
	}

	public void setYahoo(String yahoo) {
		this.yahoo = yahoo;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getPinterest() {
		return pinterest;
	}

	public void setPinterest(String pinterest) {
		this.pinterest = pinterest;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ProfilePOJO) {
			ProfilePOJO other = (ProfilePOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.fName, other.fName);
			builder.append(this.lName, other.lName);
			builder.append(this.phone, other.phone);
			builder.append(this.fBook, other.fBook);
			builder.append(this.google, other.google);
			builder.append(this.yahoo, other.yahoo);
			builder.append(this.twitter, other.twitter);
			builder.append(this.linkedin, other.linkedin);
			builder.append(this.pinterest, other.pinterest);
			builder.append(this.instagram, other.instagram);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(email);
		builder.append(fName);
		builder.append(lName);
		builder.append(phone);
		builder.append(fBook);
		builder.append(google);
		builder.append(yahoo);
		builder.append(twitter);
		builder.append(linkedin);
		builder.append(pinterest);
		builder.append(instagram);
		return builder.toHashCode();
	}
}