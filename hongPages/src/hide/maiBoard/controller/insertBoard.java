package hide.maiBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.maiBoard.service.Board;
import hide.maiBoard.service.BoardService;




@WebServlet("/nInsert.do")
public class insertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public insertBoard() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 글 여러개를 DB에서 조회하여
				// 목록 형태로 (ArrayList) 데이터를 전달하는 서블릿
				ArrayList<Board> list = new ArrayList<Board>();
				
				BoardService ns = new BoardService();
				
				String page = null;
				try {
					list = ns.selectList();
					request.setAttribute("list", list);
					page = "views/notice/noticeList.jsp";
				
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("error-msg", "공지사항 목록 조회 실패");
					page = "views/common/errorPage.jsp";
				}
						
				request.getRequestDispatcher(page).forward(request, response);
			}
			
				// System.out.println(list);
				/*
				if(list != null) {
					request.setAttribute("list", list);
					request.getRequestDispatcher("views/notice/noticeList.jsp")
											.forward(request, response);
				}else { 
					request.setAttribute("error-msg", "공지사항 목록 조회 실패");
					request.getRequestDispatcher("views/common/errorPage.jsp")
											.forward(request, response);
				}
				*/
				// if절 부터 코드 줄이는 방법
				/*
				String page = null;
				
				if(list != null) {
					request.setAttribute("list", list);
					page = "views/notice/noticeList.jsp";
				}else { 
					request.setAttribute("error-msg", "공지사항 목록 조회 실패");
					page = "views/common/errorPage.jsp";
				}
				
				request.getRequestDispatcher(page).forward(request, response);
				*/
				

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
