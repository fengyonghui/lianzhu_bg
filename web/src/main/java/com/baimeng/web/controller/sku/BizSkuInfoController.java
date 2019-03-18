/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.baimeng.web.controller.sku;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.file.utils.FileUploadUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.baimeng.modules.biz.entity.sku.BizSkuInfo;
import com.baimeng.modules.biz.service.sku.BizSkuInfoService;

/**
 * biz_sku_infoController
 * @author liuying
 * @version 2019-01-09
 */
@Controller
@RequestMapping(value = "${adminPath}/biz/sku/bizSkuInfo")
public class BizSkuInfoController extends BaseController {

	@Autowired
	private BizSkuInfoService bizSkuInfoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public BizSkuInfo get(Long id, boolean isNewRecord) {
		return bizSkuInfoService.get(String.valueOf(id), isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("biz:sku:bizSkuInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(BizSkuInfo bizSkuInfo, Model model) {
		model.addAttribute("bizSkuInfo", bizSkuInfo);
		return "modules/biz/sku/bizSkuInfoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("biz:sku:bizSkuInfo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<BizSkuInfo> listData(BizSkuInfo bizSkuInfo, HttpServletRequest request, HttpServletResponse response) {
		bizSkuInfo.setPage(new Page<>(request, response));
		Page<BizSkuInfo> page = bizSkuInfoService.findPage(bizSkuInfo);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("biz:sku:bizSkuInfo:view")
	@RequestMapping(value = "form")
	public String form(BizSkuInfo bizSkuInfo, Model model) {
		model.addAttribute("bizSkuInfo", bizSkuInfo);
		return "modules/biz/sku/bizSkuInfoForm";
	}

	/**
	 * 保存biz_sku_info
	 */
	@RequiresPermissions("biz:sku:bizSkuInfo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated BizSkuInfo bizSkuInfo) {
		bizSkuInfoService.save(bizSkuInfo);
		FileUploadUtils.saveFileUpload(bizSkuInfo.getId(), "bizSkuInfo_imgUrl");
		return renderResult(Global.TRUE, text("保存biz_sku_info成功！"));
	}
	
	/**
	 * 删除biz_sku_info
	 */
	@RequiresPermissions("biz:sku:bizSkuInfo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(BizSkuInfo bizSkuInfo) {
		bizSkuInfoService.delete(bizSkuInfo);
		return renderResult(Global.TRUE, text("删除biz_sku_info成功！"));
	}
	
}