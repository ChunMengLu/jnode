package com.lcm.jnode.controller;
import java.io.File;
import java.text.SimpleDateFormat;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.ext.render.CaptchaRender;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.render.JsonRender;
import com.jfinal.upload.UploadFile;
import com.lcm.jnode.interceptor.SidebarInterceptor;
import com.lcm.jnode.model.Blog;
import com.lcm.jnode.utils.HtmlFilter;

/**
 * 首页
 * @author L.cm
 * @date 2013-5-7 上午9:42:21
 */
@Before(SidebarInterceptor.class)
public class IndexController extends Controller{

	public void index() {
	    Page<Blog> page = Blog.dao.page(getParaToInt(0, 1), 6);
		for(Blog blog: page.getList()){
			String content = HtmlFilter.getText(blog.getStr("content"));
			blog.set("content", content != null && content.length() > 400 ? content.substring(0, 397) + "..." : content );
			blog.set("update_time", new SimpleDateFormat("yyyy年 MM月 dd日").format(blog.getTimestamp("update_time")));
		}
		setAttr("blogPage", page);
		render("index");
	}
	
	
	
	
	public void about() {
	    render("about");
	}
	
	
	public void search() {
	    
	    render("about");
	}
	
	
	public void captcha(){
		CaptchaRender captcha = new CaptchaRender("code"); 
		render(captcha);
	}
	
	@Before(POST.class)
	public void upload(){
		String path = getRequest().getRealPath("/");
		try {
			UploadFile file = getFile("imgFile", path + "/uploads" , 1024 * 1024);
			File oldFile = file.getFile();
			String oldName = file.getFileName();
			// 更名
			String newName = System.currentTimeMillis() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
			oldFile.renameTo(new File(oldFile.getParent() + "/" + newName));
			
			setAttr("error", 0);
			setAttr("url", "uploads/" + newName);
			render(new JsonRender().forIE());
		} catch (Exception e) {
			e.printStackTrace();
			setAttr("error", 1);
			setAttr("message", "上传出错，请稍候再试！");
			render(new JsonRender().forIE());
		}
	}
}
