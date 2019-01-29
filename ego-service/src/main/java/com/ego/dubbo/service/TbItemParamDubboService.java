package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDataGrid;

public interface TbItemParamDubboService {
	
	/**
	 * 分页查询数据
	 * @param page
	 * @param rows
	 * @return
	 */
	EasyUIDataGrid showPage(int page,int rows);
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	int delByIds(String ids) throws Exception; 
	

}
