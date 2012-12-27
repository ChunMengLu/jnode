package com.lcm.jnode.controller;

import com.jfinal.core.Controller;
import com.lcm.jnode.model.User;


public class UserController  extends Controller {

	public void index() {
		setAttr("page", User.dao.paginate(getParaToInt(0, 1), 10, "select *",
				"from model order by id asc"));
		render("UserController.html");
	}

	public void add() {
		
	}

	public void save() {
		getModel(User.class).save();
		forwardAction("/model");
	}

	public void edit() {
		setAttr("model", User.dao.findById(getParaToInt()));
	}

	public void update() {
		getModel(User.class).update();
		forwardAction("/model");
	}

	public void delete() {
		User.dao.deleteById(getParaToInt());
		forwardAction("/model");
	}
}
