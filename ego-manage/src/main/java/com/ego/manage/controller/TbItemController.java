package com.ego.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.TbItemService;

@Controller
public class TbItemController {

	@Autowired
	private TbItemService tbServiceImpl;

	/**
	 * 商品查询
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("item/list")
	@ResponseBody
	public EasyUIDataGrid show(int page, int rows) {
		return tbServiceImpl.show(page, rows);
	}

	/**
	 * 显示商品修改页面
	 * 
	 * @return
	 */
	@RequestMapping("rest/page/item-edit")
	public String showItemEdit() {
		return "item-edit";
	}

	/**
	 * 商品删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("rest/item/delete")
	@ResponseBody
	public EgoResult delete(String ids) {
		int result = 0;
		EgoResult egoResult = new EgoResult();
		result = tbServiceImpl.update(ids, (byte) 3);
		if (result == 1) {
			egoResult.setStatus(200);
		}
		return egoResult;
	}

	/**
	 * 商品下架
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("rest/item/instock")
	@ResponseBody
	public EgoResult instock(String ids) {
		int result = 0;
		EgoResult egoResult = new EgoResult();
		result = tbServiceImpl.update(ids, (byte) 2);
		if (result == 1) {
			egoResult.setStatus(200);
		}
		return egoResult;
	}

	/**
	 * 商品上架
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("rest/item/reshelf")
	@ResponseBody
	public EgoResult reshelf(String ids) {
		int result = 0;
		EgoResult egoResult = new EgoResult();
		result = tbServiceImpl.update(ids, (byte) 1);
		if (result == 1) {
			egoResult.setStatus(200);
		}
		return egoResult;
	}
}
