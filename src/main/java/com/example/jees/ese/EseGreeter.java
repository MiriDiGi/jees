package com.example.jees.ese;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/ese/greeter")
public class EseGreeter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final Logger log = LogManager.getLogger(EseGreeter.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String user = request.getParameter("user");  //chiedo se c'è un parametro user, altrimenti torna un parametro associato
		if (user == null || user.isBlank()) {    //controllo che non ci siano spazi bianchi e non sia nulla
			user = "Unknown";
		}
		log.trace("User is: {" + user + "}");       //loggo il valore associato all'user (lo vedo qui sotto)
		request.setAttribute("user", user);    //requesto è la request attributo
		
		RequestDispatcher rd = request.getRequestDispatcher("greeter.jsp");   //passo il controllo alla logged.jsp che dice ciao
        rd.forward(request, response); 
	}
}

