package com.lcm.jnode.model;

import java.util.Date;

import com.jfinal.plugin.activerecord.Model;

/**
 * Admin
 * @author chunmeng.lu
 *
 */
public class Admin extends Model<Admin>{

	private static final long serialVersionUID = 1775683588585949684L;

	public static final Admin dao = new Admin();
	
	// 管理员登录
	public Admin login(String userName, String pwd){
		return dao.findFirst("select id,username from admin where username = ? and password =? and del_status = 0", userName, pwd);
	}
	
	// 更新管理员统一处理
	public void updateAdmin(Admin admin){
		admin.set("update_time", new Date()).update();
	}
}
