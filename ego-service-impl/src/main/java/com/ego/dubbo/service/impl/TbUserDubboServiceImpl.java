package com.ego.dubbo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ego.dubbo.service.TbUserDubboService;
import com.ego.mapper.TbUserMapper;
import com.ego.pojo.TbUser;
import com.ego.pojo.TbUserExample;

public class TbUserDubboServiceImpl implements TbUserDubboService{

	@Autowired
	private TbUserMapper tbUserMapper; 
	@Override
	public TbUser selByUser(TbUser user) {
		TbUserExample example=new TbUserExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername())
		.andPasswordEqualTo(user.getPassword());
		List<TbUser> list=tbUserMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
