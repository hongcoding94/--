package hide.freeBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.common.PageInfo;
import hide.common.Search;
import hide.freeBoard.model.service.FreeService;
import hide.freeBoard.model.vo.FreeBoard;


@WebServlet("/searchfreeBoard.do")
public class freeBoardSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public freeBoardSearch() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<FreeBoard> list = new ArrayList<FreeBoard>();
		
		FreeService fs = new FreeService(); 
		
		String condition = request.getParameter("con");
		String keyword = request.getParameter("keyword");
		
		int startPage;
		int endPage;
		int maxPage;
		int currentPage;
		int limit;
		
		currentPage = 1;
		limit = 10;
		
		if(request.getParameter("currentPage") != null) {
			currentPage
			= Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = fs.getSelectListCount(condition, currentPage, limit, keyword);
		
		
		maxPage = (int)((double)listCount/limit + 0.9);
		
		startPage = ((int)((double)currentPage / limit + 0.9) - 1) * limit + 1;
		
		endPage = startPage + limit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		System.out.print("\n currentPage : " + currentPage + " / "); 
		System.out.print("maxPage : " + maxPage + " / " );
		System.out.println("listCount : "+ listCount);
		
		
		list = fs.searchfreeBoard(condition, keyword, currentPage, limit);
		
		String page = "views/freeBoard/freeBoardList.jsp";
		
		if(list != null) {
			
			PageInfo pi = new PageInfo(currentPage, listCount, limit,
	                   maxPage, startPage, endPage);
			
			Search s = new Search(condition, keyword);
			
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			request.setAttribute("s", s);
			
			page = "views/freeBoard/freeBoardList.jsp";
		} else {
			request.setAttribute("error-msg", "공지사항 검색 실패!");
			page = "views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
