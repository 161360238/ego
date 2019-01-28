package com.ego.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ego.commons.pojo.EasyUiTree;
import com.ego.manage.service.TbItemCatService;

@Controller
public class TbItemCatController {

	@Autowired
	private TbItemCatService tbItemCatServiceImpl;

	/**
	 * 显示商品类目
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("item/cat/list")
	@ResponseBody
	public List<EasyUiTree> showCat(@RequestParam(defaultValue = "0") long id) {
		return tbItemCatServiceImpl.show(id);
	}
}
