package com.ego.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/")
	public String welcom(){
		return "index";
	}
	@RequestMapping("{page}")
	public String showPage(String page){
		return "page";
	}
}
