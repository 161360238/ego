package com.ego.dubbo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ego.commons.pojo.EgoResult;
import com.ego.dubbo.service.TbContentCategoryDubboService;
import com.ego.mapper.TbContentCategoryMapper;
import com.ego.pojo.TbContentCategory;
import com.ego.pojo.TbContentCategoryExample;

public class TbContentCategoryDubboServiceImpl implements TbContentCategoryDubboService {

	@Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;

	@Override
	public List<TbContentCategory> selByPid(long id) {

		TbContentCategoryExample example = new TbContentCategoryExample();
		example.createCriteria().andParentIdEqualTo(id).andStatusEqualTo(1);
		return tbContentCategoryMapper.selectByExample(example);
	}

	@Override
	public int insTbContextCategory(TbContentCategory cate) {
		// TODO Auto-generated method stub
		return tbContentCategoryMapper.insertSelective(cate);
	}

	@Override
	public int updateParentById(TbContentCategory cate) {
		// TODO Auto-generated method stub
		return tbContentCategoryMapper.updateByPrimaryKeySelective(cate);
	}

	@Override
	public TbContentCategory selById(long id) {
		// TODO Auto-generated method stub
		return tbContentCategoryMapper.selectByPrimaryKey(id);
	}

}
