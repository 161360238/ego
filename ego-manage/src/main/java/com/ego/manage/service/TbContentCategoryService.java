package com.ego.manage.service;

import java.util.List;

import com.ego.commons.pojo.EasyUiTree;
import com.ego.commons.pojo.EgoResult;
import com.ego.pojo.TbContentCategory;

public interface TbContentCategoryService {

	/**
	 * 查询所有类目，并转换为easyuitree的属性要求
	 * 
	 * @param id
	 * @return
	 */
	List<EasyUiTree> showCategory(long id);

	/**
	 * 类目新增
	 * 
	 * @param cate
	 * @return
	 */
	EgoResult create(TbContentCategory cate);

	/**
	 * 类目重命名
	 * 
	 * @param cate
	 * @return
	 */
	EgoResult update(TbContentCategory cate);

	/**
	 * 删除类目
	 * 
	 * @param cate
	 * @return
	 */
	EgoResult delete(TbContentCategory cate);
}
