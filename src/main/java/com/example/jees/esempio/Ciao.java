package com.example.jees.esempio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ciao
 */
@WebServlet("/esempio/ciao")
public class Ciao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		boolean logged = "Miriam".equals(user) && "password".equals(password);
		
		HttpSession session = request.getSession();
		if (logged) {
			session.setAttribute("user", user);
		}
		else {
			session.setAttribute("user", null);
			request.setAttribute("wrong", user);
		}
		String url = logged? "ciao.jsp" : "index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url); 
        rd.forward(request, response); 
	}
}
