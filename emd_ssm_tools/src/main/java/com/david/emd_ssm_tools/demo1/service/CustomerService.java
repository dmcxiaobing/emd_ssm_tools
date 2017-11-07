package com.david.emd_ssm_tools.demo1.service;

import java.util.List;

import com.david.emd_ssm_tools.demo1.pojo.BaseDict;
import com.david.emd_ssm_tools.demo1.pojo.Customer;
import com.david.emd_ssm_tools.demo1.pojo.QueryVo;

public interface CustomerService {

	List<BaseDict> findDictByCode(String source);

	List<Customer> findCustomerByVo(QueryVo vo);

	Integer findCustomerByVoCount(QueryVo vo);

}
