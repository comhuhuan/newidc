package com.act.framework.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

/**
 * <p>Title:PageResult
 * <p>Description:分页集
 * @author FMJ
 * @date 2018/2/7 14:54
 */
public class PageResult<T> {
    /**
     *  每页第一行 index,从0开始
     */
	private Integer pageIndex;
    /**
     * 每页记录数
     */
	private Integer pageSize;
    /**
     * 当前页结果集
     */
	private List<T> rows = new ArrayList<>();
    /**
     * 总记录数
     */
	private long total;
    /**
     * 总页数
     */
	private int totalPageCount;

	public PageResult() {

	}

	public PageResult(List<T> rows, int pageIndex, int pageSize,
			int totalPageCount, long total) {
		Assert.notNull(rows);
		this.rows.addAll(rows);
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalPageCount = totalPageCount;
		this.total = total;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}


}
