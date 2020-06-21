package hide.MemberSystem.controller;

import java.io.Serializable;

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
		String userPwd = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String gender = request.getParameter("gender");
		int age = Integer.parseInt(request.getParameter("age"));
		
		String Phone = request.getParameter("tel1") + "-"
						+ request.getParameter("tel2") + "-"
						+ request.getParameter("tel3");
		
		String address = request.getParameter("zipCode") + ", "
					+ request.getParameter("address1") + ", "
					+ request.getParameter("address2");
		
		Member m = new Member(userId, userPwd, userName, gender, Phone, age, address);
		
		System.out.println("가입 정보 확인합니다 : " + m);
		
		MemberService ms = new MemberService();
		
		try {
			ms.insertMember(m);
			System.out.println("회원가입이 성공하셨습니다!");
			response.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			
			System.out.println("회원가입이 실패하셨습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/eerorPage.jsp");
			
			request.setAttribute("error-msg", "회원가입 실패하였습니다.");
			request.setAttribute("exception", e);
			
			view.forward(request, response);
		}
		
	}
		
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
