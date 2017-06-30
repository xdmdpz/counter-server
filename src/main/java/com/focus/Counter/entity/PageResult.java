package com.focus.Counter.entity;
import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页返回数据包专用实体类
 * @author licher
 */
public class PageResult<t> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//总数据
	private List<t> dataList;
	//当前页
	private long pageNo;
	//页大小
	private long pageSize;
	//总记录数
	private long total;
	//总页数
	private long pages;
	private String param;

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public PageResult<t> toPagedResult(List<t> datas) {
		if (datas instanceof Page) {
			Page page = (Page) datas;
			this.setPageNo(page.getPageNum());
			this.setPageSize(page.getPageSize());
			this.setDataList(page.getResult());
			this.setTotal(page.getTotal());
			this.setPages(page.getPages());
		}
		else {
			this.setPageNo(1);
			this.setPageSize(datas.size());
			this.setDataList(datas);
			this.setTotal(datas.size());
		}
		return this;
	}
	public List<t> getDataList() {
		return dataList;
	}
	public void setDataList(List<t> dataList) {
		this.dataList = dataList;
	}
	public long getPageNo() {
		return pageNo;
	}
	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getPages() {
		return pages;
	}
	public void setPages(long pages) {
		this.pages = pages;
	}

}
