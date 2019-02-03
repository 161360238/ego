package com.ego.dubbo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemParamDubboService;
import com.ego.mapper.TbItemParamMapper;
import com.ego.pojo.TbItemParam;
import com.ego.pojo.TbItemParamExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class TbItemParamDubboServiceImpl implements TbItemParamDubboService {

	@Autowired
	private TbItemParamMapper tbItemParamMapperImpl;

	@Override
	public EasyUIDataGrid showPage(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<TbItemParam> list = tbItemParamMapperImpl.selectByExampleWithBLOBs(new TbItemParamExample());
		PageInfo<TbItemParam> pi = new PageInfo<>(list);

		EasyUIDataGrid dataGrid = new EasyUIDataGrid();
		dataGrid.setRows(pi.getList());
		dataGrid.setTotal(pi.getTotal());
		return dataGrid;
	}

	@Override
	public int delByIds(String ids) throws Exception {
		String[] idStr = ids.split(",");
		int index = 0;
		for (String id : idStr) {
			index += tbItemParamMapperImpl.deleteByPrimaryKey(Long.parseLong(id));
		}
		if (index == idStr.length) {
			return 1;
		} else {
			throw new Exception("删除失败，可能原因：资源已经被删除");
		}
	}

	@Override
	public TbItemParam selectById(long catId) {
		TbItemParamExample example = new TbItemParamExample();
		example.createCriteria().andItemCatIdEqualTo(catId);
		List<TbItemParam> list = tbItemParamMapperImpl.selectByExampleWithBLOBs(example);
		if (list.size() > 0 && list != null) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public int insParam(TbItemParam param) {
		return tbItemParamMapperImpl.insertSelective(param);
	}

}
