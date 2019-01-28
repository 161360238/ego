package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbItem;

public interface TbItemDubboService {
	/**
	 * 商品分页查询
	 * @param page
	 * @param row
	 * @return
	 */
	EasyUIDataGrid show(int page,int rows);
	/**
	 * 修改商品状态
	 * @param id
	 * @param status
	 * @return
	 */
	int update(TbItem tbItem );

}
