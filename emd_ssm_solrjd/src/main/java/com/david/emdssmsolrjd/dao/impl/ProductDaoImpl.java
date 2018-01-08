package com.david.emdssmsolrjd.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.david.emdssmsolrjd.dao.ProductDao;
import com.david.emdssmsolrjd.domain.ProductModel;
import com.david.emdssmsolrjd.domain.ResultModel;


/**
 * 持久层查询
 * 
 * @Author ：David
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SolrServer solrServer;

	/**
	 * 统一获取solr的查询结果
	 */
	public ResultModel queryProducts(SolrQuery solrQuery) {
		// 创建返回结果对象
		ResultModel resultModel = new ResultModel();
		try {
			// 查询并获取响应结果
			QueryResponse response = solrServer.query(solrQuery);
			// 从响应中获取查询结果集
			SolrDocumentList documentList = response.getResults();
			List<ProductModel> productList = new ArrayList<ProductModel>();
			if (documentList != null) {
				//获取总记录数
				resultModel.setRecordCount(documentList.getNumFound());
				for (SolrDocument document : documentList) {
					ProductModel productModel = new ProductModel();
					productModel.setPid((String) document.get("id"));

					// 获取高亮
					Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
					if (highlighting != null) {
						List<String> list = highlighting.get(document.get("id")).get("product_name");
						if (list != null && list.size() > 0) {
							productModel.setName(list.get(0));
						} else {
							productModel.setName(String.valueOf(document.get("product_name")));
						}
					} else {
						productModel.setName(String.valueOf(document.get("product_name")));
					}

					if (document.get("product_price") != null && !"".equals(document.get("product_price"))) {
						productModel.setPrice(Float.valueOf(document.get("product_price").toString()));
					}
					productModel.setCatalog_name(String.valueOf(document.get("product_catalog_name")));
					productModel.setPicture(String.valueOf(document.get("product_picture")));
					productList.add(productModel);
				}
			}
			resultModel.setProductList(productList);
			return resultModel;
		} catch (SolrServerException e) {
			e.printStackTrace();
		}

		return resultModel;
	}

}
