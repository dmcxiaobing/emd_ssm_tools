package com.david.test.solrj;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * 用来管理测试solr的
 * @Author ：David
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class IndexManagerTest {
	@Test
	public void testIndexCreate() throws Exception{
		//创建和Solr服务端连接
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr");
		
		//创建solr文档对象
		SolrInputDocument doc = new SolrInputDocument();
		//域要先定义后使用,还有注意必须要有id主键域
		//solr中没有专用的修改方法, 会自动根据id进行查找,如果找到了则删除原来的将新的加入就是修改,如果没找到,将新的直接加入则就是新增
		doc.addField("id", "a001");
		doc.addField("product_name", "台灯1`111");
		doc.addField("product_price", "12.5");
		
		//将文档加入solrServer对象中
		solrServer.add(doc);
		
		//提交
		solrServer.commit();
	}
	
	@Test
	public void testIndexDel() throws Exception{
		//创建和Solr服务端连接
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr");
		
		//根据主键id进行删除
		//solrServer.deleteById("a001");
		
		//根据查询删除,这里是删除所有*:*
		solrServer.deleteByQuery("*:*");
		//提交
		solrServer.commit();
	}
}
