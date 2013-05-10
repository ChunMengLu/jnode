package com.lcm.jnode.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;
import com.lcm.jnode.model.User;

public class AdminInterceptor implements Interceptor {

    @Override
    public void intercept(ActionInvocation ai) {
        Controller controller = ai.getController();
        User user = controller.getSessionAttr("user");
        if(null == user){
            controller.redirect("/sign_in");
        } else {
            ai.invoke();
        }
    }
    
}
