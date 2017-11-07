package com.david.emd_ssm_tools.demo1.pojo;
/**
 * 查询的vo
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * 1. 导入pageTotal.jar包
	2. 构造Page对象填充下列属性:
	int total     		查询的总记录数
	int page   		当前页
	int size		每页显示记录条数
	List<T> rows		显示的数据集合
	3. jsp页面引入下面的标签:
	<%@ taglib prefix="itcast" uri="http://itcast.cn/common/"%>
	4. 在jsp页面中使用分页:
	<itcast:page url="${pageContext.request.contextPath }/customer/list.action" />
 */
public class QueryVo {
	// 客户姓名
	private String custName;
	// 客户来源
	private String custSource;
	// 所属行业
	private String custIndustry;
	// 客户级别
	private String custLevel;
	// 当前页
	private Integer page = 1;
	// 没用到此字段
	private Integer start;
	// 每页显示记录数
	private Integer size = 10;


	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	
	
}
