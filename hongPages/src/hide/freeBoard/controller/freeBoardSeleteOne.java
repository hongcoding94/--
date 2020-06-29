package hide.freeBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.freeBoard.model.service.FreeService;
import hide.freeBoard.model.vo.FreeBoard;

@WebServlet("/fSelectOne.do")
public class freeBoardSeleteOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public freeBoardSeleteOne() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fno = Integer.parseInt(request.getParameter("fno"));
		FreeService fs = new FreeService();
		String page = null;
		
		try {
			FreeBoard fb = fs.selectOne(fno);
			request.setAttribute("freeBoard", fb);
			page = "views/freeBoard/freeBoardDetail.jsp";
			
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "자유게시판 실패");
			page = "/views/common/errorPage.jsp";

		}finally {
			request.getRequestDispatcher(page).forward(request, response);
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
