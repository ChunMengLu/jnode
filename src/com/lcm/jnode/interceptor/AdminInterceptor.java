package com.lcm.jnode.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class AdminInterceptor implements Interceptor {

    @Override
    public void intercept(ActionInvocation ai) {
        ai.invoke();
    }
    
}
