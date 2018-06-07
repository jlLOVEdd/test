package com.wdd.test.bean;

import org.apache.ibatis.session.RowBounds;

public class PageRowBounds extends RowBounds
{

	private PageParameter	pageParameter;

	public PageRowBounds(PageParameter pageParameter)
	{
		this.pageParameter = pageParameter;
	}

	public PageParameter getPageParameter()
	{
		return this.pageParameter;
	}
}
