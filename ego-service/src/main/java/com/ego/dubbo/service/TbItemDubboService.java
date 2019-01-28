package com.ego.dubbo.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemDesc;
/**
 * 商品的dubbo接口
 * @author 王杰
 *
 */
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
	/**
	 * 新增商品
	 * @param item
	 * @return
	 */
	int insert(TbItem item);
	/**
	 * 新增商品和介绍
	 * @param item
	 * @param desc
	 * @return
	 * @throws Exception
	 */
	int insertTbItemDesc(TbItem item,TbItemDesc desc) throws Exception;

}
