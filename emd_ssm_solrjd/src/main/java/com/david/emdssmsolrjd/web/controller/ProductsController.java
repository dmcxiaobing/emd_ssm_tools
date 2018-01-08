package com.david.emdssmsolrjd.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.david.emdssmsolrjd.domain.ResultModel;
import com.david.emdssmsolrjd.service.ProductService;

/**
 * solr索引的搜索功能，京东界面
 * @Author ：David
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
@Controller
public class ProductsController {

	@Autowired
	private ProductService productService;
	
	/**
	 * 查询数据  queryString 查询条件
	 * catalog_name 分类名称
	 * price 价格
	 * sort 排序
	 * page 当前页
	 */
	@RequestMapping("/demo2/list")
	public String list(String queryString,String catalog_name,
			String price,
			String sort,
			Integer page,Model model) {
		ResultModel resultModel = productService.query(queryString,catalog_name,price,sort,page);
		
		// 将返回数据保存到域中
		model.addAttribute("result",resultModel);
		
		// 查询条件
		model.addAttribute("queryString",queryString);
		model.addAttribute("catalog_name", catalog_name);
		model.addAttribute("price", price);
		model.addAttribute("sort", sort);
		
		return "product_list";
	}
}
