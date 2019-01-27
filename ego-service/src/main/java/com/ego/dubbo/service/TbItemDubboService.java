package com.ego.dubbo.service;

import java.util.List;

import com.ego.commons.pojo.EasyUIDataGrid;

public interface TbItemDubboService {
	/**
	 * 商品分页查询
	 * @param page
	 * @param row
	 * @return
	 */
	EasyUIDataGrid show(int page,int rows);

}
