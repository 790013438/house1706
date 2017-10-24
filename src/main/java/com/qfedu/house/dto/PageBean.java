package com.qfedu.house.dto;

import java.util.List;

/**
 * 分页器
 * @author 骆昊
 *
 * @param <T> 泛型参数
 */
public class PageBean<T> {
	private List<T> dataModel;
	private int totalPage;
	private int currentPage;
	private int pageSize;

	public PageBean(List<T> dataModel, int totalPage, int currentPage, int pageSize) {
		this.dataModel = dataModel;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public List<T> getDataModel() {
		return dataModel;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

}
