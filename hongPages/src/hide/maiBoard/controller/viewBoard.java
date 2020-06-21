package hide.maiBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.maiBoard.model.service.NoticeService;
import hide.maiBoard.model.vo.Notice;

@WebServlet("/nUpView.do")
public class viewBoard extends HttpServlet {
	private static final long serialVersionUID = 123L;
       
    public viewBoard() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mno = Integer.parseInt(request.getParameter("mno"));
		
		Notice m= new NoticeService().viewBoard(mno);
		
		String page ="";
		
		if(m != null) {
			request.setAttribute("notice", m);
			page = "views/notice/updateNotice.jsp";
		} else {
			request.setAttribute("error-msg", "게시글 수정 페이지 이동 실패했습니다.");
			page = "views/common/errorPage.jsp";
		}
		request.getRequestDispatcher(page).forward(request, response);
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
