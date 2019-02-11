package com.ego.dubbo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemDubboService;
import com.ego.mapper.TbItemDescMapper;
import com.ego.mapper.TbItemMapper;
import com.ego.mapper.TbItemParamItemMapper;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemDesc;
import com.ego.pojo.TbItemExample;
import com.ego.pojo.TbItemParamItem;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TbItemDubboServiceImpl implements TbItemDubboService {

	@Autowired
	private TbItemMapper tbItemMapper;

	@Autowired
	private TbItemParamItemMapper tbItemParamItemMapper;

	@Autowired
	private TbItemDescMapper tbItemDescMapperImpl;

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

	/**
	 * 根据id修改状态
	 */
	@Override
	public int update(TbItem tbItem) {
		return tbItemMapper.updateByPrimaryKeySelective(tbItem);
	}

	@Override
	public int insert(TbItem item) {
		return tbItemMapper.insert(item);
	}

	@Override
	public int insertTbItemDesc(TbItem item, TbItemDesc desc, TbItemParamItem paramItem) throws Exception {
		int index = 0;
		try {
			index = tbItemMapper.insertSelective(item);
			index += tbItemDescMapperImpl.insertSelective(desc);
			index += tbItemParamItemMapper.insertSelective(paramItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (index == 3) {
			return 1;
		} else {
			throw new Exception("新增失败");
		}
	}

	@Override
	public List<TbItem> selAllByStutus(byte status) {
		TbItemExample example = new TbItemExample();
		example.createCriteria().andStatusEqualTo(status);
		return tbItemMapper.selectByExample(example);
	}

	@Override
	public TbItem selById(long id) {
		// TODO Auto-generated method stub
		return tbItemMapper.selectByPrimaryKey(id);
	}
}
