package com.ego.order.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ego.commons.pojo.EgoResult;
import com.ego.commons.pojo.TbItemChild;
import com.ego.order.pojo.MyOrderParam;

public interface TbOrderService {

	/**
	 * 确认定单信息包含的商品
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	List<TbItemChild> showOrderCart(List<Long> id, HttpServletRequest request);

	/**
	 * 创建定单
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	EgoResult create(MyOrderParam param, HttpServletRequest request);
}
