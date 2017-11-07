package com.david.emd_ssm_tools.demo1.dao;

import java.util.List;

import com.david.emd_ssm_tools.demo1.pojo.Customer;
import com.david.emd_ssm_tools.demo1.pojo.QueryVo;

/**
 * 客户表操作
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public interface CustomerMapper {
	/**
	 * 根据条件查询出客户的列表
	 */
	List<Customer> findCustomerByVo(QueryVo vo);
	/**
	 * 根据条件查询出数据的总数
	 */
	Integer findCustomerByVoCount(QueryVo vo);

}
