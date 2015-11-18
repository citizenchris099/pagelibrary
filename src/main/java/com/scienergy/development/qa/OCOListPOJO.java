package com.balfour.publishing.qa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class OCOListPOJO {

	private String orderNumber;
	private String name;
	private String balStatus;
	

	public OCOListPOJO() {

	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBalStatus() {
		return balStatus;
	}

	public void setBalStatus(String balStatus) {
		this.balStatus = balStatus;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof OCOListPOJO) {
			OCOListPOJO other = (OCOListPOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.orderNumber, other.orderNumber);
			builder.append(this.name, other.name);
			builder.append(this.balStatus, other.balStatus);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(orderNumber);
		builder.append(name);
		builder.append(balStatus);
		return builder.toHashCode();
	}

}
