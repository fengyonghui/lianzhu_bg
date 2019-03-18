/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.baimeng.modules.sys.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.datasource.DataSourceHolder;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.baimeng.modules.sys.entity.EmpUser;
import com.baimeng.modules.sys.entity.EmpUser;

/**
 * 员工管理DAO接口
 * @author ThinkGem
 * @version 2017-03-25
 */
@MyBatisDao(dataSourceName=DataSourceHolder.DEFAULT)
public interface EmpUserDao extends CrudDao<EmpUser> {

}