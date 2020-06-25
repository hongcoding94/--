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
		String pwd = request.getParameter("userPassword");
		int age = Integer.parseInt(request.getParameter("userAge"));
		String phone = request.getParameter("tel1") + "-" + request.getParameter("tel2") + "-" +request.getParameter("tel3");
		String address = request.getParameter("zipCode") + ", " + request.getParameter("address1") + ", " + request.getParameter("address2");
		
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
