/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.lianzhu.modules.biz.service.sku;

import com.lianzhu.modules.biz.dao.sku.BizSkuInfoDao;
import com.lianzhu.modules.biz.entity.sku.BizSkuInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;

/**
 * biz_sku_infoService
 * @author liuying
 * @version 2019-01-09
 */
@Service
@Transactional(readOnly=true)
public class BizSkuInfoService extends CrudService<BizSkuInfoDao, BizSkuInfo> {
	
	/**
	 * 获取单条数据
	 * @param bizSkuInfo
	 * @return
	 */
	@Override
	public BizSkuInfo get(BizSkuInfo bizSkuInfo) {
		return super.get(bizSkuInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param bizSkuInfo 查询条件
	 * @return
	 */
	@Override
	public Page<BizSkuInfo> findPage(BizSkuInfo bizSkuInfo) {
		return super.findPage(bizSkuInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param bizSkuInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(BizSkuInfo bizSkuInfo) {
		super.save(bizSkuInfo);
	}
	
	/**
	 * 更新状态
	 * @param bizSkuInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(BizSkuInfo bizSkuInfo) {
		super.updateStatus(bizSkuInfo);
	}
	
	/**
	 * 删除数据
	 * @param bizSkuInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(BizSkuInfo bizSkuInfo) {
		super.delete(bizSkuInfo);
	}
	
}