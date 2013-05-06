package com.lcm.jnode.controller;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.ext.render.CaptchaRender;
import com.jfinal.render.JsonRender;
import com.jfinal.upload.UploadFile;
import com.lcm.jnode.model.Blog;
import com.lcm.jnode.utils.HtmlFilter;


public class IndexController extends Controller{

	public void index() {
		List<Blog> list = Blog.dao.find("SELECT b.id, b.title, b.content, b.update_time, u.nick_name, u.url FROM blog AS b ,user_info AS u WHERE b.user_id = u.id AND b.del_status = 0 AND u.del_status = 0 ORDER BY id DESC LIMIT 0, 5");
		for(Blog blog: list){
			String content = HtmlFilter.getText(blog.getStr("content"));
			blog.set("content", content != null && content.length() > 400 ? content.substring(0, 397) + "..." : content );
			//blog.set("update_time", new SimpleDateFormat("YYYY年 MM月 DD日").format(blog.getTimestamp("update_time")));
		}
		setAttr("title", "DreamLu");
		setAttr("blogs", list);
		render("index");
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
