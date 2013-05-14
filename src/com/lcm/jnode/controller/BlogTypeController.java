package com.lcm.jnode.controller;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.lcm.jnode.interceptor.AdminInterceptor;
import com.lcm.jnode.model.BlogType;

@Before(AdminInterceptor.class)
public class BlogTypeController extends Controller {
    
    public void list() {
        List<BlogType> types = BlogType.dao.find("SELECT bt.* FROM `blog_type` bt ORDER BY bt.sort_id ASC");
        setAttr("types", types);
        render("type_list");
    }
}
