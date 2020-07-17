package hide.freeBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.freeBoard.model.service.FreeService;
import hide.freeBoard.model.vo.*;

@WebServlet("/fDelete.do")
public class freeBoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public freeBoardDelete() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int fno = Integer.parseInt(request.getParameter("Fno"));
	
	FreeService fb = new FreeService();
	
	
	try {
		fb.deleteFree(fno);
		response.sendRedirect("searchfreeBoard.do");

		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "게시판 삭제 실패");
			request.getRequestDispatcher("view/common/errorPage.jsp").forward(request,response);
		}
	
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
