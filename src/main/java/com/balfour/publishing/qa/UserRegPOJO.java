package com.balfour.publishing.qa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class UserRegPOJO {

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
	private String statement;
	private String db_url;
	private String db_username;
	private String db_pword;
	private String db_reg_key;
	private String msg;
	private String oMsg;
	private String reg_pword;
	private String role;
	private String project;
	private String key;
	private Boolean emailSearch;

	public UserRegPOJO() {

	}

	public Boolean getEmailSearch() {
		return emailSearch;
	}

	public void setEmailSearch(Boolean emailSearch) {
		this.emailSearch = emailSearch;
	}

	public String getoMsg() {
		return oMsg;
	}

	public void setoMsg(String oMsg) {
		this.oMsg = oMsg;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getReg_pword() {
		return reg_pword;
	}

	public void setReg_pword(String reg_pword) {
		this.reg_pword = reg_pword;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getDb_url() {
		return db_url;
	}

	public void setDb_url(String db_url) {
		this.db_url = db_url;
	}

	public String getDb_username() {
		return db_username;
	}

	public void setDb_username(String db_username) {
		this.db_username = db_username;
	}

	public String getDb_pword() {
		return db_pword;
	}

	public void setDb_pword(String db_pword) {
		this.db_pword = db_pword;
	}

	public String getDb_reg_key() {
		return db_reg_key;
	}

	public void setDb_reg_key(String db_reg_key) {
		this.db_reg_key = db_reg_key;
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
		if (obj instanceof UserRegPOJO) {
			UserRegPOJO other = (UserRegPOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.uName, other.uName);
			builder.append(this.email, other.email);
			builder.append(this.fName, other.fName);
			builder.append(this.lName, other.lName);
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