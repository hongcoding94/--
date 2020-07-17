package hide.freeBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.freeBoard.model.service.FreeService;
import hide.freeBoard.model.vo.FreeBoard;

@WebServlet("/fUpView.do")
public class freeBoardUpView extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public freeBoardUpView() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fno = Integer.parseInt(request.getParameter("Fno"));
		
		FreeService fs = new FreeService();
		
		
		try {
			FreeBoard fb = fs.updateView(fno);
			
			request.setAttribute("FreeBoard", fb);
			request.getRequestDispatcher("views/freeBoard/freeBoardUpdate.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "자유게시판 수정 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
