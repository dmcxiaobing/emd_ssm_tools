package com.david.emd_ssm_tools.demo1.dao;

import java.util.List;

import com.david.emd_ssm_tools.demo1.pojo.BaseDict;

/**
 * 字典表操作
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public interface DictMapper {
	/**
	 * 根据id，查询出客户来源、所属行业、客户级别的种类
	 */
	List<BaseDict> findDictByCode(String code);

}
