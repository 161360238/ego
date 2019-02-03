package com.ego.manage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.dubbo.service.TbItemCatDubboService;
import com.ego.dubbo.service.TbItemParamDubboService;
import com.ego.manage.pojo.TbItemParamChild;
import com.ego.manage.service.TbItemParamService;
import com.ego.pojo.TbItemParam;

@Service
public class TbItemParamServiceImpl implements TbItemParamService {

	@Reference
	private TbItemParamDubboService tbItemParamDubboServiceImpl;
	@Reference
	private TbItemCatDubboService tbItemCatDubboServiceImpl;

	@Override
	public EasyUIDataGrid showPage(int page, int rows) {
		EasyUIDataGrid dataGrid = tbItemParamDubboServiceImpl.showPage(page, rows);
		List<TbItemParam> list = (List<TbItemParam>) dataGrid.getRows();
		List<TbItemParamChild> listChild = new ArrayList<TbItemParamChild>();
		for (TbItemParam param : list) {
			TbItemParamChild child = new TbItemParamChild();

			child.setCreated(param.getCreated());
			child.setId(param.getId());
			child.setItemCatId(param.getItemCatId());
			child.setParamData(param.getParamData());
			child.setUpdated(param.getUpdated());
			// child.setItemCatName(tbItemCatDubboServiceImpl.selectById(child.getId()).getName());
			child.setItemCatName(tbItemCatDubboServiceImpl.selectById(child.getItemCatId()).getName());
			listChild.add(child);
		}
		dataGrid.setRows(listChild);
		return dataGrid;
	}

	@Override
	public int delByIds(String ids) throws Exception {

		return tbItemParamDubboServiceImpl.delByIds(ids);
	}

	@Override
	public EgoResult selByCatid(long Catid) {
		EgoResult er = new EgoResult();
		TbItemParam param = tbItemParamDubboServiceImpl.selectById(Catid);
		if (param != null) {
			er.setStatus(200);
			er.setData(param);
		}
		return er;
	}

	@Override
	public EgoResult save(TbItemParam param) {
		Date date = new Date();
		param.setCreated(date);
		param.setUpdated(date);
		EgoResult er = new EgoResult();
		int index = tbItemParamDubboServiceImpl.insParam(param);
		if (index > 0) {
			er.setStatus(200);
		}
		return er;
	}

}
