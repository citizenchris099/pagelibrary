package com.scienergy.development;

import java.util.Map;

public class Test_Environment {

	private String environment = "http://tasking.scienergydev.com/";
	private String login = "/login/";
	private String profile = "/profile/";
	private String oco = "/sales-orders/oncampus/";
	private String ocoNew = "/sales-orders/oncampus/?action=config&orderid=New";
	private String school_list = "/book-status/admin/school-admin/";
	private String school_view = "/book-status/school/";
	private String school_view_dynamic = "/book-status/admin/school-admin/?school_num=%s";
	private String school_config = "/book-status/admin/school-admin/?action=config&school_num=50061";
	private String school_config_dynamic = "/book-status/admin/school-admin/?action=config&school_num=%s";
	private String project_list = "/book-status/admin/project-admin/";
	private String project_view = "/book-status/admin/project-admin/?project_num=Y50061";
	private String project_view_dynamic = "/book-status/admin/project-admin/?project_num=";
	private String project_config = "/book-status/admin/project-admin/?action=config&project_num=Y50061";
	private String project_config_dynamic = "/book-status/admin/project-admin/?action=config&project_num=%s";
	private String shop = "/shop/";
	private String user_admin = "/book-status/admin/user-admin/";
	private String project_users = "/book-status/project/?action=user&project_num=Y50061";
	private String project_users_dynamic = "/book-status/project/?action=user&project_num=%s";
	private String home = "";
	private String wpAdminProfile = "/wp-admin/profile.php";
	private String prod001 = "/product/flying-ninja/";
	private String pwrdNonce_dynamic = "/login/?act=resetPassword&key=%s";
	private String nReg_dynamic = "/register/?act=invite&key=%s";
	private String register = "/register/";
	private String enfold = "http://10.90.31.54:8000%s";
	Test_EnvironmentPOJO te0;

	public Test_Environment() {
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			if (envName.equals("sb_test_url"))
				environment = env.get(envName);
		}
	}

	public Test_EnvironmentPOJO slugNAction() {

		te0 = new Test_EnvironmentPOJO();
		te0.setHome(home);
		te0.setLogin(login);
		te0.setOco(oco);
		te0.setProfile(profile);
		te0.setProject_config(project_config);
		te0.setProject_list(project_list);
		te0.setSchool_config(school_config);
		te0.setSchool_list(school_list);
		te0.setShop(shop);
		te0.setUser_admin(user_admin);
		te0.setSchool_view(school_view);
		te0.setOcoNew(ocoNew);
		te0.setWpAdminProfile(wpAdminProfile);
		te0.setProject_config_dynamic(project_config_dynamic);
		te0.setProject_view(project_view);
		te0.setProject_view_dynamic(project_view_dynamic);
		te0.setSchool_view_dynamic(school_view_dynamic);
		te0.setSchool_config_dynamic(school_config_dynamic);
		te0.setProd001(prod001);
		te0.setPwrdNonce_dynamic(pwrdNonce_dynamic);
		te0.setnReg_dynamic(nReg_dynamic);
		te0.setEnfold(enfold);
		te0.setProject_users(project_users);
		te0.setProject_users_dynamic(project_users_dynamic);
		te0.setRegister(register);
		return te0;
	}

	public String envUrl(String slug) {
		return environment + slug;
	}
}