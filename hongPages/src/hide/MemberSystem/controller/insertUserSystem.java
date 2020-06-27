package hide.MemberSystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hide.MemberSystem.model.sevice.MemberService;
import hide.MemberSystem.model.vo.Member;

@WebServlet("/mInsert.do")
public class insertUserSystem extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public insertUserSystem() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; chaset=utf-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPassWord");
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("userAge"));
		
		String Phone = request.getParameter("userPhone");
		
		String address = request.getParameter("address");
		
		Member m = new Member(userId, userPwd, userName, Phone, address, age, gender);
		
		System.out.println("가입 정보 확인합니다 : " + m);
		
		MemberService ms = new MemberService();
		
		try {
			ms.insertMember(m);
			System.out.println("회원가입이 성공하셨습니다!");
			/* 성공시 로그인 페이지로 다시 돌아가기 */
			response.sendRedirect("/hongPages/views/login/loginindex.jsp");
			
		} catch (Exception e) {
			
			System.out.println("회원가입이 실패하셨습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			
			request.setAttribute("error-msg", "회원가입 실패하였습니다.");
			request.setAttribute("exception", e);
			
			view.forward(request, response);
		}
		
	}
		
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
