package com.david.emd_ssm_tools.demo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.emd_ssm_tools.demo1.dao.CustomerMapper;
import com.david.emd_ssm_tools.demo1.dao.DictMapper;
import com.david.emd_ssm_tools.demo1.pojo.BaseDict;
import com.david.emd_ssm_tools.demo1.pojo.Customer;
import com.david.emd_ssm_tools.demo1.pojo.QueryVo;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private DictMapper dictMapper;
	@Autowired
	private CustomerMapper customerMapper;

	/**
	 * 根据id，查询出客户来源、所属行业、客户级别的种类
	 */
	@Override
	public List<BaseDict> findDictByCode(String code) {
		return dictMapper.findDictByCode(code);
	}

	/**
	 * 根据条件查询出客户的列表
	 */
	@Override
	public List<Customer> findCustomerByVo(QueryVo vo) {
		return customerMapper.findCustomerByVo(vo);
	}

	/**
	 * 根据条件查询出数据的总数
	 */
	@Override
	public Integer findCustomerByVoCount(QueryVo vo) {
		return customerMapper.findCustomerByVoCount(vo);
	}

	/**
	 * 根据id查找客户信息
	 */
	@Override
	public Customer findCustomerById(Long id) {
		return customerMapper.findCustomerById(id);
	}

	/**
	 * 根据id删除客户
	 */
	@Override
	public void deleteCustomerById(Long id) {
		customerMapper.delCustomerById(id);
	}

	/**
	 * 修改客户信息。
	 * 
	 */
	@Override
	public void updateCustomerById(Customer customer) {
		customerMapper.updateCustomerById(customer);
	}

}
