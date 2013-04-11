package com.lcm.jnode.config;

import org.json.JSONException;
import org.json.JSONObject;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.StringKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.lcm.jnode.controller.AdminController;
import com.lcm.jnode.controller.BlogController;
import com.lcm.jnode.controller.IndexController;
import com.lcm.jnode.controller.LoginController;
import com.lcm.jnode.controller.UserController;
import com.lcm.jnode.interceptor.CookieLoginInterceptor;
import com.lcm.jnode.model.User;
import com.lcm.jnode.utils.ConfigUtil;

/**
 * jfinal web config
 * @author chunmeng.lu
 *
 */
public class JFWebConfig extends JFinalConfig {

	/**
	 * 常量配置
	 */
	@Override
	public void configConstant(Constants me) {
		// 加载配置文件 静态到hashmap中
		ConfigUtil.loadConfig(loadPropertyFile("config.properties"));
		me.setDevMode(getPropertyToBoolean("devMode", Boolean.parseBoolean(ConfigUtil.get("devMode"))));
		me.setBaseViewPath("WEB-INF/pages/");
		me.setError404View("/error/404.html");
		me.setError500View("/error/500.html");
	}

	/**
	 * 路由配置
	 */
	@Override
	public void configRoute(Routes me) {
		me.add("/", IndexController.class);
		me.add("/user", UserController.class);
		me.add("/demo", UserController.class);
		me.add("/blog", BlogController.class);
		me.add("/admin", AdminController.class);
		me.add("/login", LoginController.class);
	}

	/**
	 * 全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		// 更改为cookie登陆认证  并添加到 request中
		// me.add(new CookieLoginInterceptor());
	}

	/**
	 * 配置处理器
	 */
	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("path"));
	}
	
	/**
	 * 配置插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		// 配置Druid数据库连接池插件
		DruidPlugin dp = null;
		// appfog 数据库连接方式 https://docs.appfog.com/services/mysql
		
		String VCAP_SERVICES = System.getenv("VCAP_SERVICES");
		if(StringKit.notNull(VCAP_SERVICES)){
			try {
				JSONObject credentials = new JSONObject(VCAP_SERVICES)
					.getJSONArray("mysql-5.1").getJSONObject(0).getJSONObject("credentials");
				
				StringBuffer jdbcUrl = new StringBuffer("jdbc:mysql://");
				jdbcUrl.append(credentials.getString("host")).append(":")
					.append(credentials.getString("port")).append("/")
					.append(credentials.getString("name")).append("?")
					.append("characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
				
				String userName = credentials.getString("username");
				String password = credentials.getString("password");
				
				dp = new DruidPlugin(jdbcUrl.toString(), userName, password);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
			dp = new DruidPlugin(getProperty("jdbcUrl"),getProperty("user"), getProperty("password"));
		} 
		 
		dp.addFilter(new StatFilter());
		WallFilter wall = new WallFilter();
		wall.setDbType("mysql");
		dp.addFilter(wall);
		me.add(dp);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp).setShowSql(true);
		me.add(arp);
		
		// 添加表匹配
		//arp.addMapping("user_info", User.class);
		// 添加EhCache
		me.add(new EhCachePlugin());
	}
	
	public static void main(String[] args) {		
		com.jfinal.core.JFinal.start("WebContent", 8080, "/", 5);
	}
}
