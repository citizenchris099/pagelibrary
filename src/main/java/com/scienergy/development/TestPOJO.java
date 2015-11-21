package com.scienergy.development;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class TestPOJO {

	private String adminUName;
	private String adminPword;
	private String miscUname001;
	private String miscPword001;
	private String miscUname002;
	private String miscPword002;
	private String specHomeURL;

	public TestPOJO() {
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

	public String getMiscUname001() {
		return miscUname001;
	}

	public void setMiscUname001(String miscUname001) {
		this.miscUname001 = miscUname001;
	}

	public String getMiscPword001() {
		return miscPword001;
	}

	public void setMiscPword001(String miscPword001) {
		this.miscPword001 = miscPword001;
	}

	public String getMiscUname002() {
		return miscUname002;
	}

	public void setMiscUname002(String miscUname002) {
		this.miscUname002 = miscUname002;
	}

	public String getMiscPword002() {
		return miscPword002;
	}

	public void setMiscPword002(String miscPword002) {
		this.miscPword002 = miscPword002;
	}

	public String getSpecHomeURL() {
		return specHomeURL;
	}

	public void setSpecHomeURL(String specHomeURL) {
		this.specHomeURL = specHomeURL;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TestPOJO) {
			TestPOJO other = (TestPOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			// builder.append(this.login, other.login);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		// builder.append(login);
		return builder.toHashCode();
	}
}
