package com.lcm.jnode.controller;

import com.jfinal.core.Controller;
import com.lcm.jnode.model.Admin;

public class AdminController extends Controller{
	public void index() {
		setAttr("page", Admin.dao.paginate(getParaToInt(0, 1), 10, "select *",
				"from Admin order by id asc"));
		render("AdminController.html");
	}

	public void add() {
	}

	public void save() {
		getModel(Admin.class).save();
		forwardAction("/Admin");
	}

	public void edit() {
		setAttr("Admin", Admin.dao.findById(getParaToInt()));
	}

	public void update() {
		getModel(Admin.class).update();
		forwardAction("/Admin");
	}

	public void delete() {
		Admin.dao.deleteById(getParaToInt());
		forwardAction("/Admin");
	}
}
