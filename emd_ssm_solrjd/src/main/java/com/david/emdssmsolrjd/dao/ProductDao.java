package com.david.emdssmsolrjd.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.david.emdssmsolrjd.domain.ResultModel;


public interface ProductDao {
	public ResultModel queryProducts(SolrQuery solrQuery);
}
