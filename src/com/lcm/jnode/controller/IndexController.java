package com.lcm.jnode.controller;
import java.io.File;

import org.apache.commons.codec.digest.DigestUtils;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.ext.render.CaptchaRender;
import com.jfinal.render.JsonRender;
import com.jfinal.upload.UploadFile;


public class IndexController extends Controller{

	public void index() {
//		System.out.println(DigestUtils.md5Hex("123123"));
//		String[] str = {"1", "2"};
//		getParaMap().put("a", str);
		
		render("index.jade");
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
