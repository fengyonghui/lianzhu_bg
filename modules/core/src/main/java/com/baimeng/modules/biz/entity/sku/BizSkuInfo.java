/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.baimeng.modules.biz.entity.sku;

import com.jeesite.common.entity.BaseEntity;
import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;
import com.jeesite.common.entity.BaseDataEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * biz_sku_infoEntity
 * @author liuying
 * @version 2019-01-09
 */
@Table(name="biz_sku_info",  alias="a", columns={
		@Column(includeEntity=DataEntity.class),
		@Column(name="id", attrName="id", label="id", isPK=true ,isInsert=false),
		@Column(name="name", attrName="name", label="name", queryType=QueryType.LIKE),
		@Column(name="base_price", attrName="basePrice", label="base_price"),
		@Column(name="item_no", attrName="itemNo", label="item_no"),
		@Column(name="img_url", attrName="imgUrl", label="img_url"),
		@Column(name="u_version", attrName="uVersion", label="u_version"),
	}, orderBy="a.id DESC"
)
public class BizSkuInfo extends BaseDataEntity<BizSkuInfo> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private Double basePrice;		// base_price
	private Long itemNo;		// item_no
	private String imgUrl;		// img_url

	
	public BizSkuInfo() {
		this(null);
	}

	public BizSkuInfo(String id){
		super(id);
	}
	
	@NotBlank(message="name不能为空")
	@Length(min=0, max=255, message="name长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull(message="base_price不能为空")
	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}
	
	@NotNull(message="item_no不能为空")
	public Long getItemNo() {
		return itemNo;
	}

	public void setItemNo(Long itemNo) {
		this.itemNo = itemNo;
	}
	
	@Length(min=0, max=255, message="img_url长度不能超过 255 个字符")
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	
}