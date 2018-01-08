package com.david.emdssmsolrjd.service;

import com.david.emdssmsolrjd.domain.ResultModel;

public interface ProductService {

	public ResultModel query(String queryString, String catalog_name, String price, String sort, Integer page);

}
