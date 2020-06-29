package hide.freeBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.freeBoard.model.service.FreeService;
import hide.freeBoard.model.vo.FreeBoard;

@WebServlet("/fUpdate.do")
public class freeBoardupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public freeBoardupdate() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tilte = request.getParameter("Ftitle");
		String content = request.getParameter("Fcontent");
		int Fno = Integer.parseInt(request.getParameter("Fno"));
		
		FreeBoard fb = new FreeBoard();
		
		fb.setFno(Fno);
		fb.setFcontent(content);
		fb.setFtitle(tilte);
		
		try {
			new FreeService().updateFreeBoard(fb);
			response.sendRedirect("selectFree.do");
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "게시판 수정 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
