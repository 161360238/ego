package com.ego.passport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ego.commons.pojo.EgoResult;
import com.ego.passport.service.TbUserService;
import com.ego.pojo.TbUser;

@Controller
public class TbUserController {

	@Autowired
	private TbUserService tbUserServiceImpl;

	/**
	 * 显示登录界面
	 * 
	 * @param url
	 * @param model
	 * @return
	 */
	@RequestMapping("user/showLogin")
	public String showLogin(@RequestHeader(value = "Referer", defaultValue = "") String url, Model model,
			String interurl) {
		if (interurl != null && !interurl.equals("")) {
			// 如果点加入购物车，登录后 自动把商品添加到购物车
			model.addAttribute("redirect", interurl);
		} else if (!url.equals("")) {
			model.addAttribute("redirect", url);
		}
		return "login";
	}

	/**
	 * 登录
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("user/login")
	@ResponseBody
	public EgoResult login(TbUser user, HttpServletRequest request, HttpServletResponse response) {
		return tbUserServiceImpl.login(user, request, response);
	}

	/**
	 * 通公token获取用户信息
	 * 
	 * @param token
	 * @param callback
	 * @return
	 */
	@RequestMapping("user/token/{token}")
	@ResponseBody
	public Object getUserInfo(@PathVariable String token, String callback) {
		EgoResult er = tbUserServiceImpl.getUserInfoByToken(token);
		if (callback != null && !callback.equals("")) {
			MappingJacksonValue mjv = new MappingJacksonValue(er);
			mjv.setJsonpFunction(callback);
			return mjv;
		}
		return er;
	}

	@RequestMapping("user/logout/{token}")
	@ResponseBody
	public Object logOut(@PathVariable String token, String callback, HttpServletRequest request,
			HttpServletResponse response) {
		EgoResult er = tbUserServiceImpl.logout(token, request, response);
		if (callback != null && !callback.equals("")) {
			MappingJacksonValue mjv = new MappingJacksonValue(er);
			mjv.setJsonpFunction(callback);
			return mjv;
		}
		return er;
	}
}
