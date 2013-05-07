package com.lcm.jnode.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * blog 实体
 * @author L.cm
 * @date 2013-5-7 上午9:30:18
 */
public class Blog extends Model<Blog> {

	private static final long serialVersionUID = -2208881735662609833L;
	
	public static final Blog dao = new Blog();

	/**
	 * 分页查找
	 * @param @param pageNum
	 * @param @param pageSize
	 * @param @return    设定文件
	 * @return Page<Blog>    返回类型
	 * @throws
	 */
    public Page<Blog> page(Integer pageNum, int pageSize) {
        String select = "SELECT b.*, u.nick_name, u.url";
        String sqlOutSelect = "FROM blog AS b ,user_info AS u WHERE b.user_id = u.id AND b.del_status = 0 AND u.del_status = 0 ORDER BY id DESC";
        return dao.paginate(pageNum, pageSize, select, sqlOutSelect);
    }

    /**
     * 根据id查找blog相关信息
     * @param @param paraToInt
     * @param @return    设定文件
     * @return Blog    返回类型
     * @throws
     */
    public Blog findFallById(Integer blogId) {
        String sql = "SELECT b.*, u.nick_name, u.url, u.head_photo, u.signature FROM blog AS b ,user_info AS u WHERE b.id = ? AND b.user_id = u.id AND b.del_status = 0 AND u.del_status = 0";
        return dao.findFirst(sql, blogId);
    }

    /**
     * 最近的5条
     * @param @return    设定文件
     * @return List<Blog>    返回类型
     * @throws
     */
    public List<Blog> findLateList() {
        String sql = "SELECT b.id, b.title, b.update_time FROM blog AS b WHERE b.del_status = 0 ORDER BY id DESC LIMIT 5";
        return dao.find(sql);
    }
}
