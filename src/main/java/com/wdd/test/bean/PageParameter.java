package com.wdd.test.bean;

import java.io.Serializable;

public class PageParameter implements Serializable
{

	private static final long	serialVersionUID	= 1L;
	/**
	 * 当前页第页码
	 */
	private int					page				= 1;
	/**
	 * 每页的记录数
	 */
	private int					limit				= 10;

	/**
	 * 当前页中存放的记录
	 */
	private Object				data;

	/**
	 * 总记录数
	 */
	private int					totalCount;

	/**
	 * 总页数
	 */
	private int					totalPage;

	/**
	 * 排序方式
	 */
	//private SortParameter		sort;

	/**
	 * @return the page
	 */
	public int getPage()
	{
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(int page)
	{
		this.page = page;
	}

	/**
	 * @return the limit
	 */
	public int getLimit()
	{
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(int limit)
	{
		this.limit = limit;
	}

	/**
	 * @return the data
	 */
	public Object getData()
	{
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public PageParameter setData(Object data)
	{
		this.data = data;
		return this;
	}

	/*public SortParameter getSort()
	{
		return sort;
	}

	public void setSort(SortParameter sort)
	{
		this.sort = sort;
	}*/

	/**
	 * @return the totalCount
	 */
	public int getTotalCount()
	{
		return totalCount;
	}

	/**
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(int totalCount)
	{
		this.totalCount = totalCount;
	}

	/**
	 * @param totalPage
	 *            the totalPage to set
	 */
	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage()
	{
		return totalPage;
	}

}
