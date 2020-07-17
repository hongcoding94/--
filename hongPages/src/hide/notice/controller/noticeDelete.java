package hide.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.notice.model.service.NoticeService;

@WebServlet("/nDelete.do")
public class noticeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public noticeDelete() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mno = Integer.parseInt(request.getParameter("mno"));
		
		NoticeService ns = new NoticeService();
		
		try {
			ns.deleteNotice(mno);
			response.sendRedirect("searchNotice.do");
			
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
