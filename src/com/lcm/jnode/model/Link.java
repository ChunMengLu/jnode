package com.lcm.jnode.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * 玩站相关链接 
 * 1. 友情链接 2. 广告 3. 其他预设
 * @author chunmenglu
 *
 */
public class Link extends Model<BlogType>{

	private static final long serialVersionUID = -2359927723463048053L;
	
	public static final Link dao = new Link(); 
}
