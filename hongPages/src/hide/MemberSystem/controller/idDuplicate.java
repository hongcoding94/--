package hide.MemberSystem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import hide.MemberSystem.model.sevice.MemberService;

@WebServlet("/idDup.do")
public class idDuplicate extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public idDuplicate() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId");
		MemberService ms = new MemberService();
		
		int result = ms.idDupCheck(id);
		new Gson().toJson(result, response.getWriter());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
