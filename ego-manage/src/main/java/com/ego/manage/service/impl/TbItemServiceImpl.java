package com.ego.manage.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemDubboService;
import com.ego.manage.service.TbItemService;
import com.ego.pojo.TbItem;

@Service
public class TbItemServiceImpl implements TbItemService {

	@Reference
	private TbItemDubboService tbItemDubboServiceImpl;

	@Override
	public EasyUIDataGrid show(int page, int rows) {
		// TODO Auto-generated method stub
		return tbItemDubboServiceImpl.show(page, rows);
	}

	@Override
	public int update(String ids, byte status) {
		int index = 0;
		TbItem tbItem = new TbItem();
		String[] idsStr = ids.split(",");
		for (String idStr : idsStr) {
			tbItem.setId(Long.parseLong(idStr));
			tbItem.setStatus(status);
			index += tbItemDubboServiceImpl.update(tbItem);
		}
		if (index == idsStr.length) {
			return 1;
		}
		return 0;
	}

}
