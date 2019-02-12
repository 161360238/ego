package com.ego.passport.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ego.commons.pojo.EgoResult;
import com.ego.pojo.TbUser;

public interface TbUserService {

	/**
	 * 登录
	 * 
	 * @param user
	 * @return
	 */
	EgoResult login(TbUser user, HttpServletRequest request, HttpServletResponse response);

	/**
	 * 根据token查询用户信息
	 * 
	 * @param token
	 * @return
	 */
	EgoResult getUserInfoByToken(String token);

	/**
	 * 实现退出功能
	 * @param token
	 * @param request
	 * @param response
	 * @return
	 */
	EgoResult logout(String token, HttpServletRequest request, HttpServletResponse response);
}
