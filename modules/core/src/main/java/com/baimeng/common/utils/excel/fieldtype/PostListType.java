/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.baimeng.common.utils.excel.fieldtype;

import java.util.List;

import com.baimeng.modules.sys.entity.Post;
import com.baimeng.modules.sys.service.PostService;
import org.springframework.core.NamedThreadLocal;

import com.baimeng.common.collect.ListUtils;
import com.baimeng.common.lang.StringUtils;
import com.jeesite.common.utils.SpringUtils;

/**
 * 字段类型转换
 * @author ThinkGem
 * @version 2018-08-11
 * @example fieldType = PostListType.class
 */
public class PostListType {

	private static PostService postService = SpringUtils.getBean(PostService.class);
	private static ThreadLocal<List<Post>> cache = new NamedThreadLocal<>("PostListType");

	/**
	 * 获取对象值（导入）
	 */
	public static Object getValue(String val) {
		List<Post> postList = ListUtils.newArrayList();
		List<Post> cacheList = cache.get();
		if (cacheList == null){
			cacheList = postService.findList(new Post());
			cache.set(cacheList);
		}
		for (String s : StringUtils.split(val, ",")) {
			for (Post e : cacheList) {
				if (StringUtils.trimToEmpty(s).equals(e.getPostName())) {
					postList.add(e);
				}
			}
		}
		return postList.size() > 0 ? postList : null;
	}

	/**
	 * 设置对象值（导出）
	 */
	public static String setValue(Object val) {
		if (val != null) {
			@SuppressWarnings("unchecked")
			List<Post> postList = (List<Post>) val;
			return ListUtils.extractToString(postList, "postName", ", ");
		}
		return "";
	}
	
	/**
	 * 清理缓存
	 */
	public static void clearCache(){
		cache.remove();
	}
}
