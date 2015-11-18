package com.scienergy.development.qa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SchoolViewPOJO {

	private String sName;
	private String status;
	private String bAdd1;
	private String sAdd1;
	private String grade;
	private String region;
	private String sOffice;
	private String number;
	private String cont0;
	private String cont1;

	public SchoolViewPOJO() {

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCont0() {
		return cont0;
	}

	public void setCont0(String cont0) {
		this.cont0 = cont0;
	}

	public String getCont1() {
		return cont1;
	}

	public void setCont1(String cont1) {
		this.cont1 = cont1;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getbAdd1() {
		return bAdd1;
	}

	public void setbAdd1(String bAdd1) {
		this.bAdd1 = bAdd1;
	}

	public String getsAdd1() {
		return sAdd1;
	}

	public void setsAdd1(String sAdd1) {
		this.sAdd1 = sAdd1;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getsOffice() {
		return sOffice;
	}

	public void setsOffice(String sOffice) {
		this.sOffice = sOffice;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SchoolViewPOJO) {
			SchoolViewPOJO other = (SchoolViewPOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.sName, other.sName);
			builder.append(this.bAdd1, other.bAdd1);
			builder.append(this.status, other.status);
			builder.append(this.grade, other.grade);
			builder.append(this.sAdd1, other.sAdd1);
			builder.append(this.region, other.region);
			builder.append(this.sOffice, other.sOffice);
			builder.append(this.number, other.number);
			builder.append(this.cont0, other.cont0);
			builder.append(this.cont1, other.cont1);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(sName);
		builder.append(bAdd1);
		builder.append(status);
		builder.append(grade);
		builder.append(sAdd1);
		builder.append(region);
		builder.append(sOffice);
		builder.append(number);
		builder.append(cont0);
		builder.append(cont1);

		return builder.toHashCode();
	}

}
