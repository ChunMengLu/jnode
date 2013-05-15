package com.lcm.jnode.controller;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.aop.ClearLayer;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.lcm.jnode.interceptor.AdminInterceptor;
import com.lcm.jnode.interceptor.SidebarInterceptor;
import com.lcm.jnode.model.Blog;
import com.lcm.jnode.model.BlogType;
import com.lcm.jnode.model.User;
import com.lcm.jnode.utils.DateUtils;

/**
 * 博文控制器
 * @author L.cm
 * @date 2013-5-14 下午5:08:12
 */
@Before(AdminInterceptor.class)
public class BlogController extends Controller{
    
    @ClearInterceptor(ClearLayer.UPPER)
    @Before(SidebarInterceptor.class)
	public void index() {
	    Blog blog = Blog.dao.findFallById(getParaToInt(0, 1));
	    blog.set("view_count", blog.getInt("view_count") + 1).update();
	    blog.set("update_time", DateUtils.formatCn(blog.getTimestamp("update_time")));
	    setAttr("blog", blog);
	    setAttr("title", blog.getStr("title"));
	    render("blog");
	}

    /**
     * 后台 blog 列表
     * @param     设定文件
     * @return void    返回类型
     * @throws
     */
    public void list() {
        Page<Blog> page = Blog.dao.adminPage(getParaToInt(0, 1), 8);
        for(Blog blog: page.getList()){
            String title = blog.getStr("title");
            blog.set("title", title != null && title.length() > 40 ? title.substring(0, 37) + "..." : title );
            blog.set("update_time", DateUtils.formatCn(blog.getTimestamp("update_time")));
        }
        setAttr("blogPage", page);
        render("admin/blog-list");
    }
    
    /**
     * 后台写博
     * @param     设定文件
     * @return void    返回类型
     * @throws
     */
	public void add() {
	    List<BlogType> types = BlogType.dao.findAll(); 
	    setAttr("types", types);
	    render("admin/blog-add");
	}

	/**
	 * 保存博客
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void save() {
	    User user = getSessionAttr("user");
	    Blog blog = getModel(Blog.class).set("user_id", user.getInt("id"));
	    setAttr("state", Blog.dao.save(blog));
		renderJson(new String[]{"state"});
	}

	/**
	 * 编辑博文
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void edit() {
	    Blog blog = Blog.dao.findById(getPara());
	    List<BlogType> types = BlogType.dao.findAll();
	    setAttr("blog", blog);
        setAttr("types", types);
        render("admin/blog-edit");
	}
	
	/**
     * 更新博文
     * @param     设定文件
     * @return void    返回类型
     * @throws
     */
    public void update() {
        setAttr("state", getModel(Blog.class).update());
        renderJson(new String[]{"state"});
    }

	/**
	 * 删除博文
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void delete() {
		Blog.dao.deleteById(getParaToInt());
		redirect("/blog/list");
	}
}
