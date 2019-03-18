/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.baimeng.modules.sys.service.support;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.baimeng.modules.sys.dao.LogDao;
import com.baimeng.modules.sys.entity.Log;
import com.baimeng.modules.sys.service.LogService;

/**
 * 日志Service
 * @author ThinkGem
 * @version 2014-05-16
 */
@Transactional(readOnly=true)
public class LogServiceSupport extends CrudService<LogDao, Log>
		implements LogService{
	
	/**
	 * 查询日志记录
	 */
	@Override
	public Page<Log> findPage(Log log) {
//		// 设置默认时间范围，默认当前月
//		if (log.getCreateDate_gte() == null){
//			log.setCreateDate_gte(DateUtils.setDays(new Date(), 1));
//		}
//		if (log.getCreateDate_lte() == null){
//			log.setCreateDate_lte(DateUtils.addDays(DateUtils.addMonths(log.getCreateDate_gte(), 1), -1));
//		}
		// 普通用户看自己的，管理员看全部的。
		if (!log.getCurrentUser().isAdmin()){
			log.setCreateBy(log.getCurrentUser().getUserCode());
		}
		return super.findPage(log);
	}
	
	/**
	 * 不使用数据库事务，执行插入日志
	 */
	@Transactional(readOnly=false, propagation=Propagation.NOT_SUPPORTED)
	public void insertLog(Log entity) {
		dao.insert(entity);
	}
	
}
