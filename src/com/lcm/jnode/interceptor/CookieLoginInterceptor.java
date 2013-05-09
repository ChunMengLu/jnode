package com.lcm.jnode.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StringKit;
import com.lcm.jnode.model.User;
import com.lcm.jnode.utils.DESUtils;

/**
 * cookie 登录
 * @author L.cm
 * @date 2013-5-9 下午4:58:42
 */
public class CookieLoginInterceptor implements Interceptor {

    @Override
    public void intercept(ActionInvocation ai) {
        Controller controller = ai.getController();
        // 检查session
        User u = controller.getSessionAttr("user");
        if(null == u){
            // 检查是否有cookie
            String userCookie = controller.getCookie("userId");
            if(StringKit.notBlank(userCookie)){
                try {
                    // 解密校验cookie 
                    String cookieString = new DESUtils().decryptString(userCookie);
                    if(cookieString.indexOf("|") != -1) {
                        String[] data = cookieString.split(":");
                        User user = User.dao.login(data[0], data[1]);
                        controller.setSessionAttr("user", user);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        ai.invoke();
    }
}
