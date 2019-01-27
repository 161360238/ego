package com.ego.dubbo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemDubboService;
import com.ego.mapper.TbItemMapper;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TbItemDubboServiceImpl implements TbItemDubboService {

	@Autowired
	private TbItemMapper tbItemMapper;

	@Override
	public EasyUIDataGrid show(int page, int rows) {
		PageHelper.startPage(page, rows);
		// 查詢全部
		List<TbItem> list = tbItemMapper.selectByExample(new TbItemExample());
		// 分页代码
		// 设置分页条件
		PageInfo<TbItem> pi = new PageInfo<>(list);

		// 放入到实体类
		EasyUIDataGrid datagrid = new EasyUIDataGrid();
		datagrid.setRows(pi.getList());
		datagrid.setTotal(pi.getTotal());
		return datagrid;
	}

}
