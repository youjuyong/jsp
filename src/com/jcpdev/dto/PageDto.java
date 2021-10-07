package com.jcpdev.dto;

import java.sql.Date;


import lombok.Data;


@Data
public class PageDto {
	private int currentPage;	//현재페이지
	private int totalCount;		//글의 전체갯수
	private int pageSize;		//한개페이지에 보여줄 글 갯수
	
	private int totalPage;	//전체 페이지수
	private int startPage;	
	private int endPage;
	
	private int StartNo;
	
	public PageDto(int currentPage,int totalCount,int pageSize) {
		this.currentPage=currentPage;
		this.totalCount=totalCount;
		this.pageSize = pageSize;
		
		totalPage = (totalCount-1)/pageSize +1;
		this.currentPage = (currentPage > totalPage)?totalPage:currentPage;
		this.currentPage = (currentPage < 1)? 1:currentPage;
		
		StartNo = (this.currentPage-1)*pageSize;
		
		startPage = (this.currentPage)/10 *10+1;
		endPage = startPage+9;
		endPage = endPage > totalPage ? totalPage:endPage;
	}
}
