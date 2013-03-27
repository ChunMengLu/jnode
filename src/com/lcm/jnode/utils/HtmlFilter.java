package com.lcm.jnode.utils;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import com.jfinal.kit.StringKit;

public class HtmlFilter {
	
	// 只有纯文本可以通过
	public static String getText(String html) {
		if (html == null)
			return null;
		return Jsoup.clean(html, Whitelist.none());
	}
	
	// 以下标签可以通过
	// b, em, i, strong, u. 纯文本 
	public static String getSimpleHtml(String html) {
		if (html == null)
			return null;
		return Jsoup.clean(html, Whitelist.simpleText());
	}
	
	// 以下标签可以通过
	//a, b, blockquote, br, cite, code, dd, dl, dt, em, i, li, ol, p, pre, q, small, strike, strong, sub, sup, u, ul
	public static String getBasicHtml(String html) {
		if (html == null)
			return null;
		return Jsoup.clean(html, Whitelist.basic());
	}
	
	//在basic基础上  增加图片通过
	public static String getBasicHtmlandimage(String html) {
		if (html == null)
			return null;
		return Jsoup.clean(html, Whitelist.basicWithImages());
	}
	// 以下标签可以通过	
	//a, b, blockquote, br, caption, cite, code, col, colgroup, dd, dl, dt, em, h1, h2, h3, h4, h5, h6, i, img, li, ol, p, pre, q, small, strike, strong, sub, sup, table, tbody, td, tfoot, th, thead, tr, u, ul
	public static String getFullHtml(String html) {
		if (html == null)
			return null;
		return Jsoup.clean(html, Whitelist.relaxed());
	}
	
	//只允许指定的html标签
	public static String clearTags(String html, String ...tags) {
		Whitelist wl = new Whitelist();
		return Jsoup.clean(html, wl.addTags(tags));
	}
	
	// zyh 2012-06-12
	public static String markKeywodsRedColor(String keywords, String target) {
		if (StringKit.notBlank(keywords)) {
			String[] arr = keywords.split(" ");
			for (String s : arr) {
				if (StringKit.notBlank(s)) {
					String temp = "<font color=\"red\">" + s + "</font>";
					if(temp!=null)
						target = target.replaceAll(s, temp);
				}
			}
		}
		return target;
	}
	
	public static void main(String[] args) {
		String test = "<a href='http://www.baidu.com' class='aaaa' style='width:800px; height:500px;' src='http://www.baidu.com.png'>aaa</a>";
		System.out.println(clearTags(test, "a"));
	}
}
