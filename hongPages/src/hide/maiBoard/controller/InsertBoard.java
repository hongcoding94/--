package hide.maiBoard.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.maiBoard.model.service.NoticeService;
import hide.maiBoard.model.vo.Notice;

/**
 * Servlet implementation class InsertBoard
 */
@WebServlet("/minsertboard.do")
public class InsertBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public InsertBoard() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mtilte = request.getParameter("tilte");
		String writer= request.getParameter("userId");
		String content = request.getParameter("content");
		
		String date = request.getParameter("date");
		System.out.println("날짜 값 확인 : " +date);
		Date writeDate = new Date(new GregorianCalendar().getTimeInMillis());
		
		if(date !=  null && ! date.equals("")) {
			String[] dateArr = date.split("-");
			int[] intArr = new int[dateArr.length];
			
			for(int i=0; i<dateArr.length; i++) {
				intArr[i] = Integer.parseInt(dateArr[i]);
				
			writeDate = new Date(new GregorianCalendar(
					intArr[0], intArr[1] - 1, intArr[2]
							).getTimeInMillis());
			}
			Notice m = new Notice();
			
			m.setMtitle(mtilte);
			m.setMcontent(content);
			m.setMwriter(writer);
			m.setMdate(writeDate);
			
			NoticeService ns = new NoticeService();	
	
			try {
				ns.inserNotice(m);
				response.sendRedirect("selectList.do");
				
			} catch (Exception e) {
				request.setAttribute("exception",  e);
				request.setAttribute("error-msg", "공지사항실패");
				
				request.getRequestDispatcher("views/common/errorPage/jsp").forward(request, response);
			}
		}
		
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}