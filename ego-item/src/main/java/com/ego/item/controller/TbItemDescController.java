package com.ego.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ego.item.service.TbItemDescService;

@Controller
public class TbItemDescController {

	@Autowired
	private TbItemDescService tbItemDescServiceImpl;

	@RequestMapping(value = "item/desc/{id}.html", produces = "text/html;charset=utf-8")
	@ResponseBody
	public String desc(@PathVariable long id) {
		return tbItemDescServiceImpl.showDesc(id);
	}
}
