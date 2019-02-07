package com.ego.manage.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.utils.JsonUtils;
import com.ego.dubbo.service.TbContentDubboService;
import com.ego.manage.service.TbContentService;
import com.ego.pojo.TbContent;
import com.ego.redis.dao.JedisDao;

@Service
public class TbContentServiceImpl implements TbContentService {

	@Reference
	private TbContentDubboService tbContentDubboServiceImpl;
	@Autowired
	private JedisDao jedisDaoImpl;
	@Value("${redis.bigpic.key}")
	private String key;

	@Override
	public EasyUIDataGrid showContent(long categoryId, int page, int rows) {
		// TODO Auto-generated method stub
		return tbContentDubboServiceImpl.selContentByPage(categoryId, page, rows);
	}

	@Override
	public int save(TbContent content) {
		Date date = new Date();
		content.setCreated(date);
		content.setUpdated(date);
		int index = tbContentDubboServiceImpl.insContent(content);
		// 判断redis中是否有缓存数据
		if (jedisDaoImpl.exits(key)) {
			String value = jedisDaoImpl.get(key);
			if (value != null && !value.equals("")) {
				// 先从redis中取出缓存数据，并转化成List，便于操作
				List<HashMap> list = JsonUtils.jsonToList(value, HashMap.class);
				// 拿到药存入缓存的数据
				HashMap<String, Object> map = new HashMap<>();
				map.put("srcB", content.getPic2());
				map.put("height", 240);
				map.put("alt", "对不起,加载图片失败");
				map.put("width", 670);
				map.put("src", content.getPic());
				map.put("widthB", 550);
				map.put("href", content.getUrl());
				map.put("heightB", 240);
				// 保证六个
				if (list.size() == 6) {
					list.remove(5);
				}
				list.add(0, map);
				jedisDaoImpl.set(key, JsonUtils.objectToJson(list));
			}
		}
		return index;
	}

}
