package com.scienergy.development;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Test_EnviornmentPOJO {

	private String login;
	private String profile;
	private String oco;
	private String ocoNew;
	private String school_list;
	private String school_view;
	private String school_view_dynamic;
	private String school_config;
	private String school_config_dynamic;
	private String project_list;
	private String project_view;
	private String project_view_dynamic;
	private String project_config;
	private String project_config_dynamic;
	private String shop;
	private String user_admin;
	private String project_users;
	private String project_users_dynamic;
	private String home;
	private String href;
	private String wpAdminProfile;
	private String prod001;
	private String pwrdNonce_dynamic;
	private String nReg_dynamic;
	private String enfold;
	private String register;
	private String salesDb;
	

	public Test_EnviornmentPOJO() {
	}

	public String getSalesDb() {
		return salesDb;
	}

	public void setSalesDb(String salesDb) {
		this.salesDb = salesDb;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getProject_users_dynamic() {
		return project_users_dynamic;
	}

	public void setProject_users_dynamic(String project_users_dynamic) {
		this.project_users_dynamic = project_users_dynamic;
	}

	public String getProject_users() {
		return project_users;
	}

	public void setProject_users(String project_users) {
		this.project_users = project_users;
	}

	public String getEnfold() {
		return enfold;
	}

	public void setEnfold(String enfold) {
		this.enfold = enfold;
	}

	public String getPwrdNonce_dynamic() {
		return pwrdNonce_dynamic;
	}

	public void setPwrdNonce_dynamic(String pwrdNonce_dynamic) {
		this.pwrdNonce_dynamic = pwrdNonce_dynamic;
	}

	public String getnReg_dynamic() {
		return nReg_dynamic;
	}

	public void setnReg_dynamic(String nReg_dynamic) {
		this.nReg_dynamic = nReg_dynamic;
	}

	public String getProd001() {
		return prod001;
	}

	public void setProd001(String prod001) {
		this.prod001 = prod001;
	}

	public String getSchool_view_dynamic() {
		return school_view_dynamic;
	}

	public void setSchool_view_dynamic(String school_view_dynamic) {
		this.school_view_dynamic = school_view_dynamic;
	}

	public String getSchool_config_dynamic() {
		return school_config_dynamic;
	}

	public void setSchool_config_dynamic(String school_config_dynamic) {
		this.school_config_dynamic = school_config_dynamic;
	}

	public String getProject_view_dynamic() {
		return project_view_dynamic;
	}

	public void setProject_view_dynamic(String project_view_dynamic) {
		this.project_view_dynamic = project_view_dynamic;
	}

	public String getProject_config_dynamic() {
		return project_config_dynamic;
	}

	public void setProject_config_dynamic(String project_config_dynamic) {
		this.project_config_dynamic = project_config_dynamic;
	}

	public String getWpAdminProfile() {
		return wpAdminProfile;
	}

	public void setWpAdminProfile(String wpAdminProfile) {
		this.wpAdminProfile = wpAdminProfile;
	}

	public String getOcoNew() {
		return ocoNew;
	}

	public void setOcoNew(String ocoNew) {
		this.ocoNew = ocoNew;
	}

	public String getSchool_view() {
		return school_view;
	}

	public void setSchool_view(String school_view) {
		this.school_view = school_view;
	}

	public String getProject_view() {
		return project_view;
	}

	public void setProject_view(String project_view) {
		this.project_view = project_view;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getOco() {
		return oco;
	}

	public void setOco(String oco) {
		this.oco = oco;
	}

	public String getSchool_list() {
		return school_list;
	}

	public void setSchool_list(String school_list) {
		this.school_list = school_list;
	}

	public String getSchool_config() {
		return school_config;
	}

	public void setSchool_config(String school_config) {
		this.school_config = school_config;
	}

	public String getProject_list() {
		return project_list;
	}

	public void setProject_list(String project_list) {
		this.project_list = project_list;
	}

	public String getProject_config() {
		return project_config;
	}

	public void setProject_config(String project_config) {
		this.project_config = project_config;
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String getUser_admin() {
		return user_admin;
	}

	public void setUser_admin(String user_admin) {
		this.user_admin = user_admin;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Test_EnviornmentPOJO) {
			Test_EnviornmentPOJO other = (Test_EnviornmentPOJO) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(this.login, other.login);
			builder.append(this.profile, other.profile);
			builder.append(this.oco, other.oco);
			builder.append(this.school_list, other.school_list);
			builder.append(this.school_config, other.school_config);
			builder.append(this.project_list, other.project_list);
			builder.append(this.project_config, other.project_config);
			builder.append(this.shop, other.shop);
			builder.append(this.user_admin, other.user_admin);
			builder.append(this.home, other.home);
			builder.append(this.ocoNew, other.ocoNew);
			builder.append(this.wpAdminProfile, other.wpAdminProfile);
			return builder.isEquals();
		}
		return false;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(login);
		builder.append(profile);
		builder.append(oco);
		builder.append(school_list);
		builder.append(school_config);
		builder.append(project_list);
		builder.append(project_config);
		builder.append(shop);
		builder.append(user_admin);
		builder.append(home);
		builder.append(ocoNew);
		builder.append(wpAdminProfile);
		return builder.toHashCode();
	}
}
