package com.balfour.publishing;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class TestPOJO {

	private String adminUName;
	private String adminPword;
	private String advUname;
	private String advPword;
	private String miscUname001;
	private String miscPword001;
	private String miscUname002;
	private String sbRegUrl;
	private String sbLogOnUrl;
	private String sbPUUrl;
	private String sbProjConf;
	private String sbUAUrl;
	
	

	public TestPOJO() {
	}


	public String getMiscPword001() {
		return miscPword001;
	}


	public void setMiscPword001(String miscPword001) {
		this.miscPword001 = miscPword001;
	}


	public String getSbUAUrl() {
		return sbUAUrl;
	}


	public void setSbUAUrl(String sbUAUrl) {
		this.sbUAUrl = sbUAUrl;
	}


	public String getSbProjConf() {
		return sbProjConf;
	}


	public void setSbProjConf(String sbProjConf) {
		this.sbProjConf = sbProjConf;
	}


	public String getAdminUName() {
		return adminUName;
	}


	public void setAdminUName(String adminUName) {
		this.adminUName = adminUName;
	}


	public String getAdminPword() {
		return adminPword;
	}


	public void setAdminPword(String adminPword) {
		this.adminPword = adminPword;
	}


	public String getAdvUname() {
		return advUname;
	}


	public void setAdvUname(String advUname) {
		this.advUname = advUname;
	}


	public String getAdvPword() {
		return advPword;
	}


	public void setAdvPword(String advPword) {
		this.advPword = advPword;
	}


	public String getMiscUname001() {
		return miscUname001;
	}


	public void setMiscUname001(String miscUname001) {
		this.miscUname001 = miscUname001;
	}


	public String getMiscUname002() {
		return miscUname002;
	}


	public void setMiscUname002(String miscUname002) {
		this.miscUname002 = miscUname002;
	}


	public String getSbRegUrl() {
		return sbRegUrl;
	}


	public void setSbRegUrl(String sbRegUrl) {
		this.sbRegUrl = sbRegUrl;
	}


	public String getSbLogOnUrl() {
		return sbLogOnUrl;
	}


	public void setSbLogOnUrl(String sbLogOnUrl) {
		this.sbLogOnUrl = sbLogOnUrl;
	}


	public String getSbPUUrl() {
		return sbPUUrl;
	}


	public void setSbPUUrl(String sbPUUrl) {
		this.sbPUUrl = sbPUUrl;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TestPOJO) {
			TestPOJO other = (TestPOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
//			builder.append(this.login, other.login);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
//		builder.append(login);
		return builder.toHashCode();
	}
}
