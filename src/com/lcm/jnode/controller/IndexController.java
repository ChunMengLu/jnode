package com.lcm.jnode.controller;

import java.io.File;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.Crypt;
import org.apache.commons.codec.digest.DigestUtils;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.ext.render.CaptchaRender;
import com.jfinal.upload.UploadFile;


public class IndexController extends Controller{

	public void index() {
		System.out.println(DigestUtils.md5Hex("123123"));
		
		render("index.html");
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
			renderJson();
		} catch (Exception e) {
			e.printStackTrace();
			setAttr("error", 1);
			setAttr("message", "上传出错，请稍候再试！");
			renderJson();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(DigestUtils.md5Hex("6693722"));
	}
}
