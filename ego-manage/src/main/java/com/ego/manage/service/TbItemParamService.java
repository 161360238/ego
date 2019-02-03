package com.ego.manage.service;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.pojo.TbItemParam;

public interface TbItemParamService {
	EasyUIDataGrid showPage(int page,int rows);
	int delByIds(String ids)throws Exception;
	EgoResult selByCatid(long Catid);
	EgoResult save(TbItemParam param);
}
