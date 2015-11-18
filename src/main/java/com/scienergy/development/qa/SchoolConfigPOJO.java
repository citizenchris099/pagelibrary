package com.balfour.publishing.qa;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SchoolConfigPOJO {

	private String sANum;
	private String sName;
	private String cont0;
	private String cont1;
	private String bAdd1;
	private String bAdd2;
	private String bCity;
	private String bState;
	private String bZip;
	private String bCountry;
	private String sAdd1;
	private String sAdd2;
	private String sCity;
	private String sState;
	private String sZip;
	private String sCountry;
	private String region;
	private String sOffice;
	private String grade01;
	private String grade02;
	private String grade03;
	private String grade04;
	private String grade05;
	private String grade06;
	private String grade07;
	private String grade08;
	private String grade09;
	private String grade10;

	private Boolean sAB;

	public SchoolConfigPOJO() {

	}

	public String getGrade06() {
		return grade06;
	}

	public void setGrade06(String grade06) {
		this.grade06 = grade06;
	}

	public String getGrade07() {
		return grade07;
	}

	public void setGrade07(String grade07) {
		this.grade07 = grade07;
	}

	public String getGrade08() {
		return grade08;
	}

	public void setGrade08(String grade08) {
		this.grade08 = grade08;
	}

	public String getGrade09() {
		return grade09;
	}

	public void setGrade09(String grade09) {
		this.grade09 = grade09;
	}

	public String getGrade10() {
		return grade10;
	}

	public void setGrade10(String grade10) {
		this.grade10 = grade10;
	}

	public String getGrade01() {
		return grade01;
	}

	public void setGrade01(String grade01) {
		this.grade01 = grade01;
	}

	public String getGrade02() {
		return grade02;
	}

	public void setGrade02(String grade02) {
		this.grade02 = grade02;
	}

	public String getGrade03() {
		return grade03;
	}

	public void setGrade03(String grade03) {
		this.grade03 = grade03;
	}

	public String getGrade04() {
		return grade04;
	}

	public void setGrade04(String grade04) {
		this.grade04 = grade04;
	}

	public String getGrade05() {
		return grade05;
	}

	public void setGrade05(String grade05) {
		this.grade05 = grade05;
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

	public String getsANum() {
		return sANum;
	}

	public void setsANum(String sANum) {
		this.sANum = sANum;
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

	public String getbAdd2() {
		return bAdd2;
	}

	public void setbAdd2(String bAdd2) {
		this.bAdd2 = bAdd2;
	}

	public String getbCity() {
		return bCity;
	}

	public void setbCity(String bCity) {
		this.bCity = bCity;
	}

	public String getbState() {
		return bState;
	}

	public void setbState(String bState) {
		this.bState = bState;
	}

	public String getbZip() {
		return bZip;
	}

	public void setbZip(String bZip) {
		this.bZip = bZip;
	}

	public String getbCountry() {
		return bCountry;
	}

	public void setbCountry(String bCountry) {
		this.bCountry = bCountry;
	}

	public String getsAdd1() {
		return sAdd1;
	}

	public void setsAdd1(String sAdd1) {
		this.sAdd1 = sAdd1;
	}

	public String getsAdd2() {
		return sAdd2;
	}

	public void setsAdd2(String sAdd2) {
		this.sAdd2 = sAdd2;
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}

	public String getsState() {
		return sState;
	}

	public void setsState(String sState) {
		this.sState = sState;
	}

	public String getsZip() {
		return sZip;
	}

	public void setsZip(String sZip) {
		this.sZip = sZip;
	}

	public String getsCountry() {
		return sCountry;
	}

	public void setsCountry(String sCountry) {
		this.sCountry = sCountry;
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

	public Boolean getsAB() {
		return sAB;
	}

	public void setsAB(Boolean sAB) {
		this.sAB = sAB;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SchoolConfigPOJO) {
			SchoolConfigPOJO other = (SchoolConfigPOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.sANum, other.sANum);
			builder.append(this.sName, other.sName);
			builder.append(this.bAdd1, other.bAdd1);
			builder.append(this.bAdd2, other.bAdd2);
			builder.append(this.bCity, other.bCity);
			builder.append(this.bState, other.bState);
			builder.append(this.bZip, other.bZip);
			builder.append(this.bCountry, other.bCountry);
			builder.append(this.sAdd1, other.sAdd1);
			builder.append(this.sAdd2, other.sAdd2);
			builder.append(this.sCity, other.sCity);
			builder.append(this.sState, other.sState);
			builder.append(this.sZip, other.sZip);
			builder.append(this.sCountry, other.sCountry);
			builder.append(this.region, other.region);
			builder.append(this.sOffice, other.sOffice);
			builder.append(this.sAB, other.sAB);
			builder.append(this.cont0, other.cont0);
			builder.append(this.cont1, other.cont1);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(sANum);
		builder.append(sName);
		builder.append(bAdd1);
		builder.append(bAdd2);
		builder.append(bCity);
		builder.append(bState);
		builder.append(bZip);
		builder.append(bCountry);
		builder.append(sAdd1);
		builder.append(sAdd2);
		builder.append(sCity);
		builder.append(sState);
		builder.append(sZip);
		builder.append(sCountry);
		builder.append(region);
		builder.append(sOffice);
		builder.append(sAB);
		builder.append(cont0);
		builder.append(cont1);

		return builder.toHashCode();
	}

}
