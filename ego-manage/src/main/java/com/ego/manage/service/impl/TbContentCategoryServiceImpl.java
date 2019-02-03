package com.ego.manage.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUiTree;
import com.ego.commons.pojo.EgoResult;
import com.ego.commons.utils.IDUtils;
import com.ego.dubbo.service.TbContentCategoryDubboService;
import com.ego.manage.service.TbContentCategoryService;
import com.ego.pojo.TbContentCategory;

@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService {

	@Reference
	private TbContentCategoryDubboService tbContentCategoryDubboServiceImpl;

	@Override
	public List<EasyUiTree> showCategory(long id) {
		List<EasyUiTree> listTree = new ArrayList<>();
		List<TbContentCategory> list = tbContentCategoryDubboServiceImpl.selByPid(id);
		for (TbContentCategory cate : list) {
			EasyUiTree tree = new EasyUiTree();
			tree.setId(cate.getId());
			tree.setText(cate.getName());
			tree.setState(cate.getIsParent() ? "closed" : "open");
			listTree.add(tree);
		}
		return listTree;
	}

	@Override
	public EgoResult create(TbContentCategory cate) {
		EgoResult er = new EgoResult();
		// 判断当前节点名称是否已经存在
		List<TbContentCategory> children = tbContentCategoryDubboServiceImpl.selByPid(cate.getParentId());
		for (TbContentCategory child : children) {
			if (child.getName().equals(cate.getName())) {
				er.setData("该分列已经存在");
				return er;
			}
		}
		Date date = new Date();
		cate.setCreated(date);
		cate.setUpdated(date);
		cate.setStatus(1);
		cate.setSortOrder(1);
		cate.setIsParent(false);
		long id = IDUtils.genItemId();
		cate.setId(id);
		int index = tbContentCategoryDubboServiceImpl.insTbContextCategory(cate);
		if (index > 0) {
			TbContentCategory parent = new TbContentCategory();
			parent.setId(cate.getParentId());
			parent.setIsParent(true);
			tbContentCategoryDubboServiceImpl.updateParentById(parent);
		}
		er.setStatus(200);
		Map<String, Long> map = new HashMap<>();
		map.put("id", id);
		er.setData(map);
		return er;
	}

	@Override
	public EgoResult update(TbContentCategory cate) {
		EgoResult er = new EgoResult();
		// 查询当前节点信息
		TbContentCategory cateSelect = tbContentCategoryDubboServiceImpl.selById(cate.getId());
		// 查询当前节点父节点所有子节点信息
		List<TbContentCategory> children = tbContentCategoryDubboServiceImpl.selByPid(cateSelect.getParentId());
		// 遍历有没有出现重复
		for (TbContentCategory child : children) {
			if (child.getName().equals(cate.getName())) {
				er.setData("该分类已经存在");
				return er;
			}
		}
		int index = tbContentCategoryDubboServiceImpl.updateParentById(cate);
		if (index > 0) {
			er.setStatus(200);
		}
		return er;
	}

	@Override
	public EgoResult delete(TbContentCategory cate) {
		EgoResult er = new EgoResult();
		cate.setStatus(0);
		int index = tbContentCategoryDubboServiceImpl.updateParentById(cate);
		if (index > 0) {
			TbContentCategory curr = tbContentCategoryDubboServiceImpl.selById(cate.getId());
			List<TbContentCategory> list = tbContentCategoryDubboServiceImpl.selByPid(curr.getParentId());
			if (list == null || list.size() == 0) {
				TbContentCategory parent = new TbContentCategory();
				parent.setId(curr.getParentId());
				parent.setIsParent(false);
				int result = tbContentCategoryDubboServiceImpl.updateParentById(parent);
				if (result > 0) {
					er.setStatus(200);
				}
			} else {
				er.setStatus(200);
			}
		}
		return er;
	}

}
