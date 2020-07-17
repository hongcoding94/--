package hide.MemberSystem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hide.MemberSystem.model.sevice.MemberService;
import hide.MemberSystem.model.vo.Member;

@WebServlet("/mDelete.do")
public class deleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public deleteMember() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = ((Member)session.getAttribute("Member")).getUserId();
		System.out.println("회원 기존 아이디 : " + userId);
		MemberService ms = new MemberService();
		
		try {
			ms.deleteMember(userId);
			System.out.println("회원 탈퇴 성공!");
			session.invalidate();
			response.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			request.setAttribute("error-msg", "회원 탈퇴 수행중 에러 발생!");
			request.setAttribute("excption", e);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
