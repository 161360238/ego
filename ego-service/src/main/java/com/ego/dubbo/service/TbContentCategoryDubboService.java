package com.ego.dubbo.service;

import java.util.List;

import com.ego.commons.pojo.EgoResult;
import com.ego.pojo.TbContentCategory;

public interface TbContentCategoryDubboService {

	/**
	 * 根据父id查询所有子类目
	 * 
	 * @param id
	 * @return
	 */
	List<TbContentCategory> selByPid(long id);

	/**
	 * 新增
	 * 
	 * @param cate
	 * @return
	 */
	int insTbContextCategory(TbContentCategory cate);

	/**
	 * 修改isparent 通过id
	 * 
	 * @param cate
	 * @return
	 */
	int updateParentById(TbContentCategory cate);

	/**
	 * 通过id查询内容类目详细信息
	 * 
	 * @param id
	 * @return
	 */
	TbContentCategory selById(long id);

}
