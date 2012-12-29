package com.lcm.jnode.controller;

import com.jfinal.core.Controller;
import com.lcm.jnode.model.Blog;

public class BlogController extends Controller{
	public void index() {
		setAttr("page", Blog.dao.paginate(getParaToInt(0, 1), 10, "select *",
				"from Blog order by id asc"));
		render("BlogController.html");
	}

	public void add() {
	}

	public void save() {
		getModel(Blog.class).save();
		forwardAction("/Blog");
	}

	public void edit() {
		setAttr("Blog", Blog.dao.findById(getParaToInt()));
	}

	public void update() {
		getModel(Blog.class).update();
		forwardAction("/Blog");
	}

	public void delete() {
		Blog.dao.deleteById(getParaToInt());
		forwardAction("/Blog");
	}
}
