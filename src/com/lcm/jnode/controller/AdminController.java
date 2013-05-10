package com.lcm.jnode.controller;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.codec.digest.DigestUtils;

import com.jfinal.aop.Before;
import com.jfinal.aop.ClearInterceptor;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.kit.StringKit;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.render.JsonRender;
import com.jfinal.upload.UploadFile;
import com.lcm.jnode.interceptor.AdminInterceptor;
import com.lcm.jnode.model.Blog;
import com.lcm.jnode.model.User;
import com.lcm.jnode.utils.DESUtils;

@Before(AdminInterceptor.class)
public class AdminController extends Controller{
    
    public void index() {
        Page<Blog> page = Blog.dao.adminPage(getParaToInt(0, 1), 8);
        for(Blog blog: page.getList()){
            String title = blog.getStr("title");
            blog.set("title", title != null && title.length() > 40 ? title.substring(0, 37) + "..." : title );
            blog.set("update_time", new SimpleDateFormat("yyyy年 MM月 dd日").format(blog.getTimestamp("update_time")));
        }
        setAttr("blogPage", page);
        render("index");
    }

    /**
     * 登录
     * @param     设定文件
     * @return void    返回类型
     * @throws
     */
    @ClearInterceptor
    public void session() {
        String email = getPara("email", "");
        String pwd = getPara("pwd", "");
        Integer remember = getParaToInt("remember", 0);
        User user = User.dao.login(email, DigestUtils.md5Hex(pwd));
        if(StringKit.notNull(user)) {
            if(remember == 1){
                String code = new DESUtils().encryptString(email + ":" + DigestUtils.md5Hex(pwd));
                setCookie("userId", code, 1000 * 60 * 60 * 24 * 30, "/");
            }
            setSessionAttr("user", user);
            setAttr("status", 0);
        }else {
            setAttr("status", 1);
        }
        renderJson(new String[]{"status"});
    }

    
    @Before(POST.class)
    public void editor(){
        @SuppressWarnings("deprecation")
        String path = getRequest().getRealPath("/");
        try {
            UploadFile file = getFile("imgFile", path + "/uploads" , 1024 * 1024);
            File oldFile = file.getFile();
            String oldName = file.getFileName();
            // 更名
            String newName = System.currentTimeMillis() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
            oldFile.renameTo(new File(oldFile.getParent() + "/" + newName));
            
            setAttr("error", 0);
            setAttr("url", "uploads/" + newName);
            render(new JsonRender(new String[]{"error", "url"}).forIE());
        } catch (Exception e) {
            e.printStackTrace();
            setAttr("error", 1);
            setAttr("message", "上传出错，请稍候再试！");
            render(new JsonRender(new String[]{"error", "message"}).forIE());
        }
    }
}
