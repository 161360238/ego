package com.ego.commons.pojo;

import com.ego.pojo.TbItem;

public class TbItemChild extends TbItem {
	private String[] images;
	// 库存是否充足
	private Boolean enough;

	public Boolean getEnough() {
		return enough;
	}

	public void setEnough(Boolean enough) {
		this.enough = enough;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
	}

}
