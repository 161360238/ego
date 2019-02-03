package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbContent;

public interface TbContentService {

	/**
	 * 分页显示内容信息
	 * 
	 * @param categoryId
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid showContent(long categoryId, int page, int rows);

	/**
	 * 新增内容
	 * 
	 * @param content
	 * @return
	 */
	int save(TbContent content);
}
