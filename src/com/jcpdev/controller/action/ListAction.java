package com.jcpdev.controller.action;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jcpdev.dao.FreeboardDao;
import com.jcpdev.dto.Freeboard;
import com.jcpdev.dto.PageDto;

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		//비지니스 로직을 처리하는 jsp 파일
		FreeboardDao dao = FreeboardDao.getInstance();
		//페이지 번호는 파라미터로 전달됩니다.
		int pageNo;
		if(request.getParameter("page")==null) pageNo=1;
		else pageNo = Integer.parseInt(request.getParameter("page"));   //page=1,2,3,4,.....

		int pageSize =15;		//ui로 변경하도록 구현할 수 있습니다.
//		int startNo=(pageNo-1)*pageSize;
		
		PageDto pageDto = new PageDto(pageNo,dao.getCount(),pageSize);  //페이지처리에 필요한객체(값) 생성

		Map<String,Integer> map = new HashMap<>();
		map.put("pageSize",pageSize);
		map.put("startNo",pageDto.getStartNo());
		List<Freeboard> list = dao.getList(map);

		request.setAttribute("today", LocalDate.now());
		request.setAttribute("pageDto", pageDto);     //페이지처리에 필요한 값들
		request.setAttribute("list", list);
//		pageContext.forward("listView.jsp");
		
		forward.isRedirect=false;
		forward.url="list.jsp";
		return forward;
	}

}