package com.lcm.jnode.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

/**
 * 玩站浏览器端缓存
 * @author chunmenglu
 *
 */
public class CacheHandler extends Handler{

	@Override
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, boolean[] isHandled) {
		// check Cache
		nextHandler.handle(target, request, response, isHandled);
		// set cache
		response.setHeader("Cache-Control", "public, max-age=" + 1000 * 60 * 60 * 24 * 30);
	}

}
