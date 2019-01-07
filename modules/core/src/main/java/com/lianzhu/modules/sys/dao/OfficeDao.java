/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.lianzhu.modules.sys.dao;

import com.jeesite.common.dao.TreeDao;
import com.jeesite.common.datasource.DataSourceHolder;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.lianzhu.modules.sys.entity.Office;
import com.lianzhu.modules.sys.entity.Office;

/**
 * 组织机构DAO接口
 * @author ThinkGem
 * @version 2017-03-23
 */
@MyBatisDao(dataSourceName=DataSourceHolder.DEFAULT)
public interface OfficeDao extends TreeDao<Office> {
	
}
