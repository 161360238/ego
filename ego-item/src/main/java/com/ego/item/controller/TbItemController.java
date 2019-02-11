package com.ego.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ego.item.service.TbItemService;

@Controller
public class TbItemController {

	@Autowired
	private TbItemService tbItemServiceImpl;

	@RequestMapping("item/{id}.html")
	public String show(@PathVariable long id, Model model) {
		model.addAttribute("item", tbItemServiceImpl.show(id));
		return "item";
	}

}
