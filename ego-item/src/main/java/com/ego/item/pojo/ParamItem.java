package com.ego.item.pojo;

import java.util.List;

public class ParamItem {

	private String group;
	private List<ParamNode> params;
	@Override
	public String toString() {
		return "ParamItem [group=" + group + "]";
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public List<ParamNode> getParams() {
		return params;
	}
	public void setParams(List<ParamNode> params) {
		this.params = params;
	}
}
