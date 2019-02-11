package com.ego.search.service;

import java.io.IOException;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;

public interface TbitemService {
	/**
	 * 初始化数据
	 * 
	 * @throws SolrServerException
	 * @throws IOException
	 */
	void init() throws SolrServerException, IOException;

	/**
	 * 查询商品
	 * @param query
	 * @param page
	 * @param rows
	 * @return
	 * @throws SolrServerException
	 * @throws IOException
	 */
	Map<String, Object> selByQuery(String query, int page, int rows) throws SolrServerException, IOException;

	/**
	 * 新增
	 * 
	 * @param map
	 * @param desc
	 * @return
	 * @throws SolrServerException
	 * @throws IOException
	 */
	int add(Map<String, Object> map, String desc) throws SolrServerException, IOException;

}
