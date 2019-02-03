package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbItemParam;

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
	
	/**
	 * 根据id查询规格参数
	 * @param id
	 * @return
	 */
	TbItemParam selectById(long id);
	/**
	 * 新增，支持主键自增
	 * @param param
	 * @return
	 */
	int insParam(TbItemParam param);

}
