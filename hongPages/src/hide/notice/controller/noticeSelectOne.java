package hide.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.notice.model.service.NoticeService;
import hide.notice.model.vo.Notice;

@WebServlet("/selectOne.do")
public class noticeSelectOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public noticeSelectOne() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mno = Integer.parseInt(request.getParameter("mno"));
		NoticeService ns = new NoticeService();
		String page = null;
		
		try {
			Notice n = ns.selectOne(mno);
			request.setAttribute("notice", n);
			page = "views/notice/noticeDetail.jsp";
			
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "공지사항 상세보기 실패");
			page = "/views/common/errorPage.jsp";
		
		}finally {
			request.getRequestDispatcher(page).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
