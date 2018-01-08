package com.david.emdssmsolrjd.domain;
/**
 * 返回给jsp前端页面的数据结构模型
 * @Author ：David
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */

import java.util.List;

public class ResultModel {

	// 商品列表数据
	private List<ProductModel> productList;
	// 商品总数
	private Long recordCount;

	// 总页数
	private Long pageCount;

	// 当前页
	private Long curPage;

	public List<ProductModel> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductModel> productList) {
		this.productList = productList;
	}


	public Long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}

	public Long getCurPage() {
		return curPage;
	}

	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}
	
}
