package hide.maiBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.maiBoard.model.service.NoticeService;
import hide.maiBoard.model.vo.Notice;
import static hide.common.JDBCTemplate.*;

@WebServlet("/nUpdate.do")
public class updateNotice extends HttpServlet {
	private static final long serialVersionUID = 1414L;
       
    public updateNotice() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("Mtitle");
		String content = request.getParameter("Mcontent");
		int mno = Integer.parseInt(request.getParameter("Mno"));
		
		Notice m = new Notice();
		
		m.setMno(mno);
		m.setMcontent(content);
		m.setMtitle(title);
		
		try {
			new NoticeService().updateNotice(m);
			response.sendRedirect("selectList.do");
			
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.setAttribute("msg", "공지사항 수정 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
