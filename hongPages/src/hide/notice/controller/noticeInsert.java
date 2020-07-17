package hide.notice.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import hide.notice.model.service.NoticeService;
import hide.notice.model.vo.Notice;


@WebServlet("/nInsert.do")
public class noticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public noticeInsert() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mtitle = request.getParameter("mtitle");
		//System.out.println(mtitle);
		String writer = request.getParameter("userId");
		//System.out.println(writer);
		String content = request.getParameter("mcontent");
		//System.out.println(content);
		
		String date = request.getParameter("date");
		System.out.println("날짜 값 확인 : " + date);
		Date writeDate = new Date(new GregorianCalendar().getTimeInMillis());
		
		if(date != null && ! date.equals("")) {
			String[] dateArr = date.split("-");
			int[] intArr = new int[dateArr.length];
			
			for(int i=0; i<dateArr.length; i++) {
				intArr[i] = Integer.parseInt(dateArr[i]);
			}
			writeDate = new Date(new GregorianCalendar(intArr[0], intArr[1]-1, intArr[2]).getTimeInMillis());
			
		}        
		
		Notice n = new Notice();
		
		n.setMtitle(mtitle);
		n.setMcontent(content);
		n.setMwriter(writer);
		n.setMdate(writeDate);
		
		NoticeService ns = new NoticeService();
		
		try {
			ns.insertNotice(n);
			response.sendRedirect("searchNotice.do");
			
		}catch(Exception e) {
			request.setAttribute("exception", e);
			request.setAttribute("error-msg", "공지사항 등록 실패!");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
