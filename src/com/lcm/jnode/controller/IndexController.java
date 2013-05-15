package com.lcm.jnode.controller;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.kit.JsonKit;
import com.jfinal.kit.StringKit;
import com.jfinal.plugin.activerecord.Page;
import com.lcm.jnode.interceptor.SidebarInterceptor;
import com.lcm.jnode.model.Blog;
import com.lcm.jnode.model.User;
import com.lcm.jnode.utils.DateUtils;
import com.lcm.jnode.utils.HtmlFilter;

/**
 * 首页
 * @author L.cm
 * @date 2013-5-7 上午9:42:21
 */
@Before(SidebarInterceptor.class)
public class IndexController extends Controller{

    /**
     * 首页
     * @param     设定文件
     * @return void    返回类型
     * @throws
     */
    public void index() {
        Map<String, Object> result = Maps.newHashMap();
        result.put("type", null);
        Page<Blog> page = Blog.dao.page(getParaToInt(0, 1), 6, result);
        for(Blog blog: page.getList()){
            String content = HtmlFilter.getText(blog.getStr("content"));
            blog.set("content", content != null && content.length() > 400 ? content.substring(0, 397) + "..." : content );
            blog.set("update_time", DateUtils.formatCn(blog.getTimestamp("update_time")));
        }
        setAttr("postsby", false);
        setAttr("blogPage", page);
        render("index");
    }
    
    /**
     * 文章
     * @param     设定文件
     * @return void    返回类型
     * @throws
     */
    public void blogs() {
        Map<String, Object> result = Maps.newHashMap();
        result.put("type", 0);
        Page<Blog> page = Blog.dao.page(getParaToInt(0, 1), 6, result);
        for(Blog blog: page.getList()){
            String content = HtmlFilter.getText(blog.getStr("content"));
            blog.set("content", content != null && content.length() > 400 ? content.substring(0, 397) + "..." : content );
            blog.set("update_time", DateUtils.formatCn(blog.getTimestamp("update_time")));
        }
        setAttr("blogPage", page);
        setAttr("postsby", "文章");
        render("index");
    }
    
    /**
     * 收藏
     * @param     设定文件
     * @return void    返回类型
     * @throws
     */
    public void favorites() {
        Map<String, Object> result = Maps.newHashMap();
        result.put("type", 1);
        Page<Blog> page = Blog.dao.page(getParaToInt(0, 1), 6, result);
        for(Blog blog: page.getList()){
            String content = HtmlFilter.getText(blog.getStr("content"));
            blog.set("content", content != null && content.length() > 400 ? content.substring(0, 397) + "..." : content );
            blog.set("update_time", DateUtils.formatCn(blog.getTimestamp("update_time")));
        }
        setAttr("blogPage", page);
        setAttr("postsby", "收藏");
        render("index");
    }
    
    /**
     * 搜索
     * @param     设定文件
     * @return void    返回类型
     * @throws
     */
    public void search() {
        Map<String, Object> result = Maps.newHashMap();
        result.put("s", getPara("s"));
        Page<Blog> page = Blog.dao.page(getParaToInt(0, 1), 6, result);
        for(Blog blog: page.getList()){
            String content = HtmlFilter.getText(blog.getStr("content"));
            content = content != null && content.length() > 400 ? content.substring(0, 397) + "..." : content;
            blog.set("title",  HtmlFilter.markKeywods(getPara("s"), blog.getStr("title")));
            blog.set("content",  HtmlFilter.markKeywods(getPara("s"), content));
            blog.set("update_time", DateUtils.formatCn(blog.getTimestamp("update_time")));
            
        }
        setAttr("blogPage", page);
        setAttr("postsby", "搜索");
        render("index");
    }
    
    /**
     * 关于
     * @param     设定文件
     * @return void    返回类型
     * @throws
     */
    public void about() {
        
        render("about");
    }
    
    /**
     * 登录
     * @param     设定文件
     * @return void    返回类型
     * @throws
     */
    public void sign_in() {
        User user = getSessionAttr("user");
        if(StringKit.notNull(user)) {
            redirect("/admin");
        }else {
            render("admin/sign-in");
        }
    }
    
    /**
     * 登出
     * @param     设定文件
     * @return void    返回类型
     * @throws
     */
    public void logout() {
        removeCookie("userId");
        removeSessionAttr("user");
        redirect("sign_in");
    }
    
    /**
     * 提供给github pages jsonp跨域使用
     * @url         http://dreamlu.net/
     * @param       设定文件
     * @return void    返回类型
     * @throws
     */
    public void json() {
        List<Blog> blogs = Blog.dao.find4github();
        renderJavascript(getPara("callback") + "(" + JsonKit.listToJson(blogs, 2) + ")");
    }
}
