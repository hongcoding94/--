package hide.maiBoard.controller;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.maiBoard.model.service.NoticeService;

import static hide.common.JDBCTemplate.*;

@WebServlet("/nDelete.do")
public class deleteNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public deleteNotice() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mno = Integer.parseInt(request.getParameter("mno"));
		NoticeService ns = new NoticeService();
		
		try {
			ns.deleteNotice(mno);
			response.sendRedirect("selectList.do");
			
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "공지사항 삭제 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
