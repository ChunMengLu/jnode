package com.lcm.jnode.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

/**
 * 博客标签
 * @author L.cm
 * @date 2013-5-14 上午11:24:17
 */
public class BlogType extends Model<BlogType> {

    private static final long serialVersionUID = -2208881735662609833L;
    public static final BlogType dao = new BlogType();

    /**
     * 博客分类
     * @param @return    设定文件
     * @return List<BlogType>    返回类型
     * @throws
     */
    public List<BlogType> findAll() {
        String sql = "SELECT bt.* FROM `blog_type` bt WHERE bt.del_status = 0 ORDER BY bt.sort_id ASC";
        return dao.find(sql);
    }
}
