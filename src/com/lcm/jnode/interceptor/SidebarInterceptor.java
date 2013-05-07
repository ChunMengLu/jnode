package com.lcm.jnode.interceptor;

import java.text.SimpleDateFormat;
import java.util.List;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.lcm.jnode.model.Blog;

/**
 * 侧边栏
 * @author L.cm
 * @date 2013-5-7 下午4:02:19
 */
public class SidebarInterceptor implements Interceptor {

    @Override
    public void intercept(ActionInvocation ai) {
        ai.invoke();
        List<Blog> lateBlogs = Blog.dao.findLateList();
        for (Blog blog : lateBlogs) {
            blog.set("update_time", new SimpleDateFormat("yyyy年 MM月 dd日").format(blog.getTimestamp("update_time")));
        }
        ai.getController().setAttr("lateBlogs", lateBlogs);
    }
}
