package hide.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.notice.model.service.NoticeService;
import hide.notice.model.vo.Notice;

@WebServlet("/nUpdate.do")
public class noticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public noticeUpdate() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tilte = request.getParameter("mtitle");
		String content = request.getParameter("mcontent");
		int mno = Integer.parseInt(request.getParameter("mno"));
		
		Notice n = new Notice();
		
		n.setMno(mno);
		n.setMcontent(content);
		n.setMtitle(tilte);
		
		try {
			new NoticeService().updateNotice(n);
			response.sendRedirect("selectList.do");
			
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "공지사항 수정 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
