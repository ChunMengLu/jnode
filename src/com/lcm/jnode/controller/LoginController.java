package com.lcm.jnode.controller;

import weibo4j.model.WeiboException;

import com.jfinal.core.Controller;
import com.qq.connect.QQConnectException;

public class LoginController extends Controller {

	public void sina() {
		try {
			redirect(new weibo4j.Oauth().authorize("code", "sina"));
		} catch (WeiboException e) {
			redirect("/");
		}
	}

	public void callback_sina() {

	}

	public void qq() {
		try {
			redirect(new com.qq.connect.oauth.Oauth()
					.getAuthorizeURL(getRequest()));
		} catch (QQConnectException e) {
			redirect("/");
		}
	}

	public void callback_qq() {
		try {
			String accessToken = (new com.qq.connect.oauth.Oauth()).getAccessTokenByRequest(getRequest()).getAccessToken();
			String openID = null;
			com.qq.connect.api.qzone.UserInfo qzoneUserInfo = new com.qq.connect.api.qzone.UserInfo(accessToken, openID);
			com.qq.connect.javabeans.qzone.UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
		} catch (QQConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
