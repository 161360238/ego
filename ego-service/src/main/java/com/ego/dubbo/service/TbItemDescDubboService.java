package com.ego.dubbo.service;

import com.ego.pojo.TbItemDesc;

/**
 * 商品介绍dubbo接口
 * @author 王杰
 *
 */
public interface TbItemDescDubboService {

	/**
	 * 新增商品介绍
	 * @param itemDesc
	 * @return
	 */
	int insDesc(TbItemDesc itemDesc);
	
}
