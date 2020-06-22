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

@WebServlet("/login.do")
public class loginMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public loginMember() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String originPwd = (String)request.getAttribute("userPassWord");
		
		System.out.println("원본 비밀번호 : " + userPwd);
		System.out.println("암호화 비밀번호 : " + originPwd);
		
		Member m = new Member(userId, userPwd);
				
		MemberService ms = new MemberService();
		
		try {
			m = ms.selectMember(m);
			HttpSession session = request.getSession();
			
			session.setAttribute("member", m);
			response.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			request.setAttribute("error-msg", "회원 로그인 실패!");
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
