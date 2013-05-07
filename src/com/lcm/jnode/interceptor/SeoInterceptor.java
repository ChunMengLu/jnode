package com.lcm.jnode.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.kit.StringKit;

public class SeoInterceptor implements Interceptor {

    @Override
    public void intercept(ActionInvocation ai) {
        ai.invoke();
        String title = ai.getController().getAttr("title");
        if(StringKit.isBlank(title)){
            ai.getController().setAttr("title", "DreamLu");
        }
    }
    
}
