package com.lcm.jnode.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * 将session传递到request中
 * @author chunmenglu
 *
 */
public class SessionInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		ai.invoke();
		HttpSession session = ai.getController().getSession();
		Enumeration<String> sessionKeys = session.getAttributeNames();
		while(sessionKeys.hasMoreElements()){
			String key = sessionKeys.nextElement();
			Object value = session.getAttribute(key);
			ai.getController().setAttr(key, value);
		}
	}
}
