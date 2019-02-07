package com.ego.dubbo.service;

import java.util.List;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbContent;

public interface TbContentDubboService {

	/**
	 * 分页查询内容
	 * 
	 * @param categoryId
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid selContentByPage(long categoryId, int page, int rows);

	/**
	 * 新增
	 * 
	 * @param content
	 * @return
	 */
	int insContent(TbContent content);

	/**
	 * 查询出最近前n个大广告
	 * 
	 * @param count
	 * @param isSort
	 * @return
	 */
	List<TbContent> selByContent(int count, boolean isSort);
}
