package com.ego.item.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.dubbo.service.TbItemDescDubboService;
import com.ego.item.service.TbItemDescService;
import com.ego.redis.dao.JedisDao;

@Service
public class TbItemDescServiceImpl implements TbItemDescService {

	@Reference
	private TbItemDescDubboService tbItemDescDubboServiceImpl;

	@Autowired
	private JedisDao jedisDaoImpl;

	@Value("${redis.desc.key}")
	private String descKey;

	@Override
	public String showDesc(long itemId) {
		String key = descKey + itemId;
		if (jedisDaoImpl.exits(key)) {
			String json = jedisDaoImpl.get(key);
			if (json != null && !json.equals("")) {
				return json;
			}
		}
		String result = tbItemDescDubboServiceImpl.selByItemid(itemId).getItemDesc();
		jedisDaoImpl.set(key, result);
		return result;
	}

}
