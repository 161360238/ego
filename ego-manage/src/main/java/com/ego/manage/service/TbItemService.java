package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDataGrid;

public interface TbItemService {
	
	/**
	 * 查询商品
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid show(int page, int rows);
	
	/**
	 * 批量修改商品状态
	 * @param id
	 * @param status
	 * @return
	 */
	int update(String ids,byte status);

}
