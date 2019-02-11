package com.ego.item.pojo;

public class ParamNode {
	private String k;
	private String v;
	public String getK() {
		return k;
	}
	public void setK(String k) {
		this.k = k;
	}
	public String getV() {
		return v;
	}
	@Override
	public String toString() {
		return "ParamNode [k=" + k + ", v=" + v + "]";
	}
	public void setV(String v) {
		this.v = v;
	}
}
