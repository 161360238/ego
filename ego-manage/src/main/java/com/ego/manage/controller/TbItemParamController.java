package com.ego.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.TbItemParamService;

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
}
