package com.balfour.publishing.qa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SchoolListPOJO {

	private String sNum;
	private String sName;
	private String city;
	private String sState;
	private String country;
	private String salesO;

	public SchoolListPOJO() {

	}

	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return sState;
	}

	public void setState(String state) {
		this.sState = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSalesO() {
		return salesO;
	}

	public void setSalesO(String salesO) {
		this.salesO = salesO;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SchoolListPOJO) {
			SchoolListPOJO other = (SchoolListPOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.sNum, other.sNum);
			builder.append(this.sName, other.sName);
			builder.append(this.city, other.city);
			builder.append(this.sState, other.sState);
			builder.append(this.country, other.country);
			builder.append(this.salesO, other.salesO);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(sNum);
		builder.append(sName);
		builder.append(city);
		builder.append(sState);
		builder.append(country);
		builder.append(salesO);

		return builder.toHashCode();
	}

}
