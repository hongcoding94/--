package hide.freeBoard.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.freeBoard.model.service.FreeService;
import hide.freeBoard.model.vo.FreeBoard;

@WebServlet("/fInset.do")
public class freeBoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public freeBoardInsert() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String ftitle = request.getParameter("Ftitle");
	String fwriter = request.getParameter("userId");
	String fcontent = request.getParameter("Fcontent");
	
	String date =request.getParameter("Fdate");
	System.out.println("날짜 값 확인 : " + date );
	Date writeDate = new Date (new GregorianCalendar().getTimeInMillis());
	
	if(date != null && ! date.equals("-")) {
		String[] dateArr = date.split("-");
		int[] intArr = new int [dateArr.length];
		
		for(int i=0; i<dateArr.length; i++) {
			intArr[i] = Integer.parseInt(dateArr[i]);
		}
	writeDate = new Date(new GregorianCalendar(intArr[0], intArr[1]-1, intArr[2]).getTimeInMillis());
		}
	
	FreeBoard fb = new FreeBoard();
	
	fb.setFtitle(ftitle);
	fb.setFcontent(fcontent);
	fb.setFwriter(fwriter);
	fb.setFdate(writeDate);
	
	FreeService fs = new FreeService(); 
	
	try {
		fs.insertFree(fb);
		response.sendRedirect("selectFree.do");
		
	} catch (Exception e) {
		request.setAttribute("exception", e);
		request.setAttribute("error-msg", "게시판 입력 실패!");
		
		request.getRequestDispatcher("views/common/errorPage.jsp");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
