package hide.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.notice.model.service.NoticeService;
import hide.notice.model.vo.Notice;

@WebServlet("/nUpView.do")
public class noticeUpView extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public noticeUpView() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mno = Integer.parseInt(request.getParameter("mno"));
		
		NoticeService ns = new NoticeService();
		
		try {
			Notice n = ns.updateView(mno);
			// response.sendRedirect("searchNotice.do");
			System.out.println(n);
			request.setAttribute("notice", n);
			request.getRequestDispatcher("views/notice/noticeUpdate.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "공기사항 삭제 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
