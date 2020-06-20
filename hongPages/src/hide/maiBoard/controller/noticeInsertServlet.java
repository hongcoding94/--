package hide.maiBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.maiBoard.model.service.NoticeService;
import hide.maiBoard.model.vo.Notice;

@WebServlet("/mInsert.do")
public class noticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public noticeInsertServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		NoticeService ns = new NoticeService();
		
		String page = null;
		try {
			list = ns.selectList();
			request.setAttribute("list", list);
			page = "views/notice/noticeLsit.jsp";
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error-msg", "공지사항 목록 조회 실패");
			page = "views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
