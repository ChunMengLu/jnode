package com.jfinal.render;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.kit.PathKit;

import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.FileTemplateLoader;
import de.neuland.jade4j.template.JadeTemplate;
import de.neuland.jade4j.template.TemplateLoader;

/**
 * 返回jade 模板 jade 用习惯了
 * @ClassName: JadeRender
 * @author L.cm
 * @date 2013-5-6 上午11:51:27
 */
public class JadeRender extends Render {

	private static final long serialVersionUID = -2136462553700833496L;
	private transient static final String encoding = getEncoding();
	private transient static final String contentType = "text/html; charset=" + encoding;
	private transient static final JadeConfiguration config = new JadeConfiguration();

	public JadeRender(String view) {
		this.view = view;
	}
	
	public static JadeConfiguration getConfiguration() {
		return config;
	}
	
	static void init() {
		TemplateLoader loader = new FileTemplateLoader(PathKit.getWebRootPath(), encoding);
		config.setTemplateLoader(loader);
		config.setPrettyPrint(true);
		config.setCaching(true);
	}
	
	public void render() {
		response.setContentType(contentType);
        Enumeration<String> attrs = request.getAttributeNames();
		Map model = new HashMap();
		while (attrs.hasMoreElements()) {
			String attrName = attrs.nextElement();
			model.put(attrName, request.getAttribute(attrName));
		}
		
		PrintWriter writer = null;
        try {
        	JadeTemplate template = config.getTemplate(view);
        	writer = response.getWriter();
			Jade4J.render(template, model, writer);
		} catch (Exception e) {
			throw new RenderException(e);
		}
		finally {
			if (writer != null)
				writer.close();
		}
	}
}
