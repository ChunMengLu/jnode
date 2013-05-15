package com.lcm.jnode.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.kit.StringKit;

/**
 * SEO 搜索引擎title和关键字处理
 * @author L.cm
 * @date 2013-5-15 下午2:00:42
 */
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
