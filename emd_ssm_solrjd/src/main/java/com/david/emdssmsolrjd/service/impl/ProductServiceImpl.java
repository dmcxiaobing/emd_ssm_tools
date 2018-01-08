package com.david.emdssmsolrjd.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.emdssmsolrjd.dao.ProductDao;
import com.david.emdssmsolrjd.domain.ResultModel;
import com.david.emdssmsolrjd.service.ProductService;


/**
 * 商品的service
 * 
 * @Author ：David
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
@Service
public class ProductServiceImpl implements ProductService {
	/**
	 * 设置每页显示数量
	 */
	private static final Integer PAGE_SIZE = 60;
	/**
	 * 因为最后获取到的结果数据时一样的，所以dao中负责封装
	 */
	@Autowired
	private ProductDao productDao;

	/**
	 * 查询数据 queryString 查询条件 catalog_name 分类名称 price 价格 sort 排序 page 当前页
	 */
	public ResultModel query(String queryString, String catalog_name, String price, String sort, Integer page) {

		// 创建查询条件
		SolrQuery solrQuery = new SolrQuery();
		// 设置默认搜索域
		solrQuery.set("df", "product_keywords");
		// 设置查询关键字
		if (StringUtils.isNotBlank(queryString)) {
			solrQuery.setQuery(queryString);
		} else {
			// 查询所有
			solrQuery.setQuery("*:*");
		}

		// 设置过滤条件按照分类名称进行过滤
		if (StringUtils.isNotBlank(catalog_name)) {
			solrQuery.addFilterQuery("product_catalog_name:" + catalog_name);
		}
		// 设置过滤条件，按照价格进行过滤。因为价格是区间。所以处理不同
		if (StringUtils.isNotBlank(price)) {
			// 以-进行分割，取出最大数和最小数
			String[] split = price.split("-");
			if (split != null && split.length > 1) {
				solrQuery.addFilterQuery("product_price:[" + split[0] + " TO " + split[1] + "]");
			}

		}

		// 设置排序
		if ("1".equals(sort)) {
			solrQuery.addSort("produce_price", ORDER.asc);
		} else {
			solrQuery.addSort("product_price", ORDER.desc);
		}

		// 设置分页
		if (page == null) {
			page = 1;
		}
		
		// 设置从第几条记录开始查
		Integer start = (page-1)*PAGE_SIZE;
		solrQuery.setStart(start);
		// 设置每页显示多少条
		solrQuery.setRows(PAGE_SIZE);
		// 设置高亮显示
		solrQuery.setHighlight(true);
		// 设置高亮显示的域
		solrQuery.addHighlightField("product_name");
		// 设置高亮前缀
		solrQuery.setHighlightSimplePre("<span style=\"color:red\">");
		// 设置高亮后缀
		solrQuery.setHighlightSimplePost("</span>");
		// 设置返回结果
		ResultModel resultModel = productDao.queryProducts(solrQuery);
		// 设置当前页
		resultModel.setCurPage(Long.parseLong(page+""));
		// 设置总页数
		//计算总页数
		Long pageCount = resultModel.getRecordCount() / PAGE_SIZE;
		if(resultModel.getRecordCount() % PAGE_SIZE > 0){
			pageCount ++;
		}
		return resultModel;
	}

}
