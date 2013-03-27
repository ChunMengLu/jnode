package com.lcm.jnode.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class MailTest {
	public void sendTest(){
		HtmlEmail mail = new HtmlEmail();
		//取得freemarker配置实例
		Configuration configuration = new Configuration();
		try {
			//设置模版所在文件夹
			configuration.setDirectoryForTemplateLoading(new File("template"));
			//取得我们模版文件
			Template temp = configuration.getTemplate("template.ftl");
			Map<String, Object> rootMap = new HashMap<String, Object>();
			rootMap.put("user", "张三");
			rootMap.put("account", "1234546");
			StringWriter writer = new StringWriter();
			temp.process(rootMap, writer);
			mail.addTo("xxx@xx.com");
			mail.setFrom("xxx@xx.com");
			mail.setSubject("注册成功");
			mail.setMsg(writer.toString());
			mail.send();
		} catch (EmailException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}

 