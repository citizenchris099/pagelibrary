package com.balfour.publishing.qa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProjectViewPOJO {

	private String year;
	private String projName;
	private String status;
	private String enrollment;
	private String dSeason;
	private String adviser;
	private String rep;
	private String ae;
	private String rType;
	private String iLink;

	public ProjectViewPOJO() {

	}

	public String getrType() {
		return rType;
	}

	public void setrType(String rType) {
		this.rType = rType;
	}

	public String getiLink() {
		return iLink;
	}

	public void setiLink(String iLink) {
		this.iLink = iLink;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(String enrollment) {
		this.enrollment = enrollment;
	}

	public String getdSeason() {
		return dSeason;
	}

	public void setdSeason(String dSeason) {
		this.dSeason = dSeason;
	}

	public String getAdviser() {
		return adviser;
	}

	public void setAdviser(String adviser) {
		this.adviser = adviser;
	}

	public String getRep() {
		return rep;
	}

	public void setRep(String rep) {
		this.rep = rep;
	}

	public String getAe() {
		return ae;
	}

	public void setAe(String ae) {
		this.ae = ae;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ProjectViewPOJO) {
			ProjectViewPOJO other = (ProjectViewPOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.year, other.year);
			builder.append(this.projName, other.projName);
			builder.append(this.status, other.status);
			builder.append(this.enrollment, other.enrollment);
			builder.append(this.dSeason, other.dSeason);
			builder.append(this.adviser, other.adviser);
			builder.append(this.rep, other.rep);
			builder.append(this.ae, other.ae);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(year);
		builder.append(projName);
		builder.append(status);
		builder.append(enrollment);
		builder.append(dSeason);
		builder.append(adviser);
		builder.append(rep);
		builder.append(ae);

		return builder.toHashCode();
	}

}
