/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.lianzhu.modules.sys.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.datasource.DataSourceHolder;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.lianzhu.modules.sys.entity.Log;
import com.lianzhu.modules.sys.entity.Log;

/**
 * 日志DAO接口
 * @author ThinkGem
 * @version 2017-03-19
 */
@MyBatisDao(dataSourceName=DataSourceHolder.DEFAULT)
public interface LogDao extends CrudDao<Log> {
	
}
