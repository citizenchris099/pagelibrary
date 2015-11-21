package com.scienergy.development.qa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class LogInPOJO {

	private String uName;
	private String userId;
	private String email;
	private String pword;
	private String statement;
	private String db_url;
	private String db_username;
	private String db_pword;
	private String db_reg_key;
	private String msg;
	private String reg_pword;

	public LogInPOJO() {

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LogInPOJO) {
			LogInPOJO other = (LogInPOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.uName, other.uName);
			builder.append(this.email, other.email);
			builder.append(this.statement, other.statement);
			builder.append(this.db_url, other.db_url);
			builder.append(this.db_username, other.db_username);
			builder.append(this.db_pword, other.db_pword);
			builder.append(this.db_reg_key, other.db_reg_key);
			builder.append(this.msg, other.msg);
			builder.append(this.reg_pword, other.reg_pword);
			builder.append(this.userId, other.userId);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(uName);
		builder.append(email);
		builder.append(statement);
		builder.append(db_url);
		builder.append(db_username);
		builder.append(db_pword);
		builder.append(db_reg_key);
		builder.append(msg);
		builder.append(reg_pword);
		builder.append(userId);

		return builder.toHashCode();
	}

}
