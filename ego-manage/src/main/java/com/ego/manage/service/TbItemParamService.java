package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDataGrid;

public interface TbItemParamService {
	EasyUIDataGrid showPage(int page,int rows);
	int delByIds(String ids)throws Exception;
}
