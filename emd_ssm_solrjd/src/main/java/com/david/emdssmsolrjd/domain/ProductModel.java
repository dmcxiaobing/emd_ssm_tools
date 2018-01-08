package com.david.emdssmsolrjd.domain;

import java.io.Serializable;

/**
 * 索引库中存在的商品数据model
 * @Author ：David
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class ProductModel implements Serializable{

	// 商品编号
	private String pid;

	// 商品名称
	private String name;
	
	// 商品分类名称
	private String catalog_name;
	
	// 价格
	private float price;
	
	// 商品描述
	private String description;
	
	// 图片名称
	private String picture;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatalog_name() {
		return catalog_name;
	}

	public void setCatalog_name(String catalog_name) {
		this.catalog_name = catalog_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}





}
