package com.lcm.jnode.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StringKit;
import com.lcm.jnode.utils.AESDecrypt;
import com.lcm.jnode.utils.ConfigUtil;

public class CookieLoginInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		Controller controller = ai.getController();
		
		System.out.println("secret：" + ConfigUtil.get("secret"));
		
		
		// 检查是否有cookie
		String userCookie = controller.getCookie("jnodeid");
		if(StringKit.isBlank(userCookie)){
			controller.redirect("/login", true);
		}else{
			// 解密校验cookie 
			try {
				String cookieString = AESDecrypt.decrypt(userCookie, ConfigUtil.get("secret"));
				// -------------------
				// 将用户信息 传递到 request中
				controller.setAttr("", "");
				ai.invoke();
			} catch (Exception e) {
				e.printStackTrace();
				controller.redirect("/login", true);
			}
		}
		
	}
}
