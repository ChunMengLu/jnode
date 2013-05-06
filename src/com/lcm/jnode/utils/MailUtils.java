package com.lcm.jnode.utils;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.jfinal.kit.PathKit;

import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.template.JadeTemplate;

/**
 * 邮件发送帮助类
 * @ClassName: MailUtils
 * @author L.cm
 * @date 2013-5-6 下午1:37:49
 */
public class MailUtils {
	
	private static String HOST_NAME = "smtp.126.com";
	private static String USER = "q596392912";
	private static String PASSWORD = "6693722";
	private static String FROM = "q596392912@126.com";
	public static void config(Email email){
		email.setHostName(HOST_NAME);
		email.setAuthentication(USER, PASSWORD);
		try {
			email.setFrom(FROM);
		} catch (EmailException e) {
			e.printStackTrace();
		}
		email.setCharset("UTF-8");
	}
	
	/**
	 * email send
	 * @param subject
	 * @param msg
	 * @param receiver
	 * @throws EmailException
	 */
	public static void sendSimpleEmail(String subject , String msg , String meilTo){
		try {
			HtmlEmail email = new HtmlEmail();
			config(email);
			email.setSubject(subject);
			email.addTo(meilTo);
			email.setMsg(msg);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送jade模板邮件
	 * @Title: sendTemplateEmail
	 * @param @param subject
	 * @param @param meilTo
	 * @param @param model
	 * @param @param tempname    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void sendTemplateEmail(String subject, String meilTo, Map<String, Object> model, String tempname){
		try {
			HtmlEmail mail = new HtmlEmail();
			config(mail);
			JadeTemplate template = Jade4J.getTemplate(PathKit.getWebRootPath() + "/WEB-INF/mail_template/" + tempname);
			String html = Jade4J.render(template, model);
			mail.addTo(meilTo);
			mail.setSubject(subject);
			mail.setMsg(html);
			mail.send();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		for (int i = 1; i <= 100; i++) {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("user", "大黄");
			model.put("baseUrl", "http://dreamlu.net/");
			model.put("verifyUrl", "http://dreamlu.net/");
			new MailUtils().sendTemplateEmail("测试", "596392912@qq.com", model, "signup_send.jade");
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
