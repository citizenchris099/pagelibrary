package com.balfour.publishing.qa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PwrdUpdatePOJO {

	private String pword;
	private String msg;

	public PwrdUpdatePOJO() {

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PwrdUpdatePOJO) {
			PwrdUpdatePOJO other = (PwrdUpdatePOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.msg, other.msg);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(msg);

		return builder.toHashCode();
	}

}
