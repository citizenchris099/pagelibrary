package com.balfour.publishing.qa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProjectListPOJO {

	private String pYear;
	private String pStatus;
	private String pNumber;
	private String pName;
	private String pAe;
	private String pAdv;
	private String pSR;

	public ProjectListPOJO() {

	}

	public String getpYear() {
		return pYear;
	}

	public void setpYear(String pYear) {
		this.pYear = pYear;
	}

	public String getpStatus() {
		return pStatus;
	}

	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}

	public String getpNumber() {
		return pNumber;
	}

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpAe() {
		return pAe;
	}

	public void setpAe(String pAe) {
		this.pAe = pAe;
	}

	public String getpAdv() {
		return pAdv;
	}

	public void setpAdv(String pAdv) {
		this.pAdv = pAdv;
	}

	public String getpSR() {
		return pSR;
	}

	public void setpSR(String pSR) {
		this.pSR = pSR;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ProjectListPOJO) {
			ProjectListPOJO other = (ProjectListPOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.pYear, other.pYear);
			builder.append(this.pStatus, other.pStatus);
			builder.append(this.pNumber, other.pNumber);
			builder.append(this.pName, other.pName);
			builder.append(this.pAe, other.pAe);
			builder.append(this.pAdv, other.pAdv);
			builder.append(this.pSR, other.pSR);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(pYear);
		builder.append(pStatus);
		builder.append(pNumber);
		builder.append(pName);
		builder.append(pAe);
		builder.append(pAdv);
		builder.append(pSR);

		return builder.toHashCode();
	}

}
