package com.ego.dubbo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ego.dubbo.service.TbItemDescDubboService;
import com.ego.mapper.TbItemDescMapper;
import com.ego.pojo.TbItemDesc;

public class TbItemDescDubboServiceImpl implements TbItemDescDubboService {

	@Autowired
	private TbItemDescMapper tbItemDescMapperImpl;

	@Override
	public int insDesc(TbItemDesc itemDesc) {
		return tbItemDescMapperImpl.insert(itemDesc);
	}

	@Override
	public TbItemDesc selByItemid(long itemid) {
		// TODO Auto-generated method stub
		return tbItemDescMapperImpl.selectByPrimaryKey(itemid);
	}

}
