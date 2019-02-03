package com.ego.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manage.service.TbContentService;
import com.ego.pojo.TbContent;

@Controller
public class TbContentController {

	@Autowired
	private TbContentService tbContentServiceImpl;

	/**
	 * 显示内容信息
	 * 
	 * @param categoryId
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("content/query/list")
	@ResponseBody
	public EasyUIDataGrid showContent(long categoryId, int page, int rows) {
		return tbContentServiceImpl.showContent(categoryId, page, rows);
	}

	@RequestMapping("content/save")
	@ResponseBody
	public EgoResult save(TbContent content) {
		EgoResult er = new EgoResult();
		int index = tbContentServiceImpl.save(content);
		if (index > 0) {
			er.setStatus(200);
		}
		return er;
	}
}
