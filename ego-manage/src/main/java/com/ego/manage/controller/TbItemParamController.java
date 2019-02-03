package com.ego.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.TbItemParamService;
import com.ego.pojo.TbItemParam;

@Controller
public class TbItemParamController {

	@Autowired
	private TbItemParamService tbItemParamServiceImpl;

	@RequestMapping("item/param/list")
	@ResponseBody
	public EasyUIDataGrid showPage(int page, int rows) {
		return tbItemParamServiceImpl.showPage(page, rows);
	}

	@RequestMapping("item/param/delete")
	@ResponseBody
	public EgoResult delByIds(String ids) {
		EgoResult er = new EgoResult();
		try {
			int result = tbItemParamServiceImpl.delByIds(ids);
			if (result == 1) {
				er.setStatus(200);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			er.setMessage(e.getMessage());
		}
		return er;
	}

	/**
	 * 点击商品类目显示按钮，添加分类按钮 判断类目是否已经添加
	 * 
	 * @param catId
	 * @return
	 */
	@RequestMapping("item/param/query/itemcatid/{catId}")
	@ResponseBody
	public EgoResult show(@PathVariable long catId) {
		return tbItemParamServiceImpl.selByCatid(catId);
	}

	/**
	 * 商品类目新增
	 * 
	 * @param param
	 * @param catId
	 * @return
	 */
	@RequestMapping("item/param/save/{catId}")
	@ResponseBody
	public EgoResult save(TbItemParam param, @PathVariable long catId) {
		param.setItemCatId(catId);
		return tbItemParamServiceImpl.save(param);
	}
}
