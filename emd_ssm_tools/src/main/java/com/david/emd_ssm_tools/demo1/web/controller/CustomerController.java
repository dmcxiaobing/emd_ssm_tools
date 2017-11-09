package com.david.emd_ssm_tools.demo1.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.david.emd_ssm_tools.demo1.pojo.BaseDict;
import com.david.emd_ssm_tools.demo1.pojo.Customer;
import com.david.emd_ssm_tools.demo1.pojo.QueryVo;
import com.david.emd_ssm_tools.demo1.service.CustomerService;

import cn.itcast.utils.Page;

/**
 * 客户的controller
 * 
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
@Controller
@RequestMapping("/demo1/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	/**
	 * 这个是使用resource中的映射进行注解
	 */
	// 客户来源，在字典表中是002
	@Value("${customer.dict.source}")
	private String source;
	// 所属行业 字典表中是001
	@Value("${customer.dict.industry}")
	private String industry;
	// 客户级别 是006
	@Value("${customer.dict.level}")
	private String level;

	/**
	 * 获取到客户的列表
	 * 
	 * @param vo
	 *            查询的实体类 return 转发到的jsp页面路径
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(QueryVo vo, Model model) throws Exception {
		// System.out.println(source+":"+industry+":"+level);
		// 查询出所有客户来源的分类
		List<BaseDict> sourceList = customerService.findDictByCode(source);
		// 查询出 所属行业的种类
		List<BaseDict> industryList = customerService.findDictByCode(industry);
		// 查询出客户的级别 种类
		List<BaseDict> levelList = customerService.findDictByCode(level);

		if (vo.getCustName() != null) {
			// 证明输入的查询的名称，这里进行一下转码
			vo.setCustName(new String(vo.getCustName().getBytes("iso8859-1"), "utf-8"));
		}

		if (vo.getPage() == null) {
			// 设置从第一页开始查询
			vo.setPage(1);
		}
		// 设置查询的起始记录条数
		vo.setStart((vo.getPage() - 1) * vo.getSize());
		// 查询数据列表和数据总数
		List<Customer> resultList = customerService.findCustomerByVo(vo);
		Integer count = customerService.findCustomerByVoCount(vo);

		// 设置page的数据。
		Page<Customer> page = new Page<>();
		page.setTotal(count);// 数据总数
		page.setSize(vo.getSize());// 每页显示条数
		page.setPage(vo.getPage());// 当前页数
		page.setRows(resultList);// 数据列表
		model.addAttribute("page", page);
		// 高级查询下拉列表数据 selet的数据填充
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		// 高级查询选中数据回显.列表中显示的数据
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		return "customer";
	}

	/**
	 * 点击修改的按钮，根据id获取到客户的详细信息
	 * 
	 * 使用@ResponseBody 注解，一定要添加Jackson的包。
	 * 
	 * @return 返回一个客户
	 */
	@ResponseBody 
	@RequestMapping("/detail")
	public Customer detail(Long id) {
		// System.out.println(customerService.findCustomerById(id));
		return customerService.findCustomerById(id);
	}

	/**
	 * 修改客户信息。
	 * 
	 */
	@RequestMapping("/update")
	public String update(Customer customer) {
		customerService.updateCustomerById(customer);
		// 操作成功，转发到列表的jsp
		return "customer";
	}

	/**
	 * 根据id删除客户
	 */
	@RequestMapping("/delete")
	public String delete(Long id) {
		customerService.deleteCustomerById(id);
		// 删除成功，转发到列表的jsp
		return "customer";
	}

}
