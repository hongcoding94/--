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

@WebServlet("/mUpdate.do")
public class updateMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public updateMember() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd = request.getParameter("userPassWord");
		int age = Integer.parseInt(request.getParameter("userAge"));
		String phone = request.getParameter("userPhone");
		String address = request.getParameter("address");
		
		/* 회원이 누구인지 구분을 줄 수 있도록 ID 가져오기*/ 
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("member");
		
		m.setUserPassword(pwd);
		m.setUserAge(age);
		m.setUserPhone(phone);
		m.setAddress(address);
		
		System.out.println("변경한 회원 정보 확인 : " + m);
		
		MemberService ms = new MemberService();
		
		try {
			ms.updateMember(m);
			System.out.println("회원정보 수정완료!");
			response.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			request.setAttribute("error-msg", "회원정보 수정 중 에러발생!");
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
