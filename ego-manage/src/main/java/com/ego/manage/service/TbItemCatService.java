package com.ego.manage.service;

import java.util.List;

import com.ego.commons.pojo.EasyUiTree;
import com.ego.pojo.TbItemCat;

public interface TbItemCatService {

	List<EasyUiTree> show(long pid);
}
