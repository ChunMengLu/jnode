package com.lcm.jnode.model;

import java.util.Date;

import com.jfinal.plugin.activerecord.Model;

/**
 * 用户表
 * @author 春梦
 *
 */
public class User extends Model<User>{

	private static final long serialVersionUID = 4049101852276240918L;
	
	public static final User dao = new User();

	// 添加用户的统一处理
	public void addUser(User user){
		user.set("reg_time", new Date()).set("head_photo", "img/icon/user-64.png").set("create_time", new Date()).set("update_time", new Date()).save();
	}
	// 更新用户的统一处理
	public void updateUser(User user){
		user.set("update_time", new Date()).update();
	}
	
	// 用户登录
	public User login(String email, String pwd){
		return User.dao.findFirst("select * from user_info where email = ? and password = ? and email_verify = 1 and del_status = 0", email, pwd);
	}
}
