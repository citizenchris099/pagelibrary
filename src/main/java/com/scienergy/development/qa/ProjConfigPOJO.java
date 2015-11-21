package com.scienergy.development.qa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProjConfigPOJO {

	private String account;
	private String school;
	private String year;
	private String project;
	private String projName;
	private String status;
	private String enrollment;
	private String dSeason;
	private String adviser;
	private String rep;
	private String ae;
	private Boolean teacher;
	private Boolean homeroom;
	private String rType;
	private String rPWord;
	private Boolean pWord;

	public ProjConfigPOJO() {

	}

	public String getrType() {
		return rType;
	}

	public void setrType(String rType) {
		this.rType = rType;
	}

	public String getrPWord() {
		return rPWord;
	}

	public void setrPWord(String rPWord) {
		this.rPWord = rPWord;
	}

	public Boolean getpWord() {
		return pWord;
	}

	public void setpWord(Boolean pWord) {
		this.pWord = pWord;
	}

	public Boolean getTeacher() {
		return teacher;
	}

	public void setTeacher(Boolean teacher) {
		this.teacher = teacher;
	}

	public Boolean getHomeroom() {
		return homeroom;
	}

	public void setHomeroom(Boolean homeroom) {
		this.homeroom = homeroom;
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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	// @Override
	// public boolean equals(Object that) {
	// FormPOJO obj = (FormPOJO) that;
	// return this.year.equals(obj.year) && this.projName.equals(obj.projName)
	// && this.status.equals(obj.status)
	// && this.enrollment.equals(obj.enrollment)
	// && this.dSeason.equals(obj.dSeason)
	// && this.adviser.equals(obj.adviser) && this.rep.equals(obj.rep)
	// && this.ae.equals(obj.ae);
	//
	// }

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ProjConfigPOJO) {
			ProjConfigPOJO other = (ProjConfigPOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.account, other.account);
			builder.append(this.school, other.school);
			builder.append(this.year, other.year);
			builder.append(this.project, other.project);
			builder.append(this.projName, other.projName);
			builder.append(this.status, other.status);
			builder.append(this.enrollment, other.enrollment);
			builder.append(this.dSeason, other.dSeason);
			builder.append(this.adviser, other.adviser);
			builder.append(this.rep, other.rep);
			builder.append(this.ae, other.ae);
			builder.append(this.teacher, other.teacher);
			builder.append(this.homeroom, other.homeroom);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(account);
		builder.append(school);
		builder.append(year);
		builder.append(project);
		builder.append(projName);
		builder.append(status);
		builder.append(enrollment);
		builder.append(dSeason);
		builder.append(adviser);
		builder.append(rep);
		builder.append(ae);
		builder.append(teacher);
		builder.append(homeroom);

		return builder.toHashCode();
	}

}
