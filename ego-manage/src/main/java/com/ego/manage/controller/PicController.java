package com.ego.manage.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ego.manage.service.PicService;

@Controller
public class PicController {

	@Autowired
	private PicService picServiceImpl;

	/**
	 * 图片上传
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("pic/upload")
	@ResponseBody
	Map<String, Object> upload(MultipartFile uploadFile) {
		Map<String, Object> map = null;
		try {
			map = picServiceImpl.upload(uploadFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("error", 1);
			map.put("message", "上传图片时服务器异常");
		}
		return map;

	}

}
