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

@WebServlet("/ese/login")
public class EseLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final Logger log = LogManager.getLogger(EseLogin.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String user = request.getParameter("user");  //chiedo se c'è un parametro user, altrimenti torna un parametro associato
		if (user == null || user.isBlank()) {    //controllo che non ci siano spazi bianchi e non sia nulla
			user = "Unknown";
		}
		log.trace("User is: {" + user + "}");       //loggo il valore associato all'user (lo vedo qui sotto)
		request.setAttribute("user", user);    //requesto è la request attributo
		
		String colour = request.getParameter("colour");   //se l'utente passa uno dei colore che vogliamo ok, altrimenti
		switch (colour) {
		case "blue":
		case "green":         //questi nomi devono essere uguali al value che c'è in html
		case "yellow":
			log.trace("the chosen colour is: " + colour);
			break;
			default:                    //se non seceglie rifiliamo questo
				colour = "Rosa";
				break;
		}
		
		request.setAttribute("colour", colour);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("logged.jsp");   //passo il controllo alla logged.jsp che dice ciao
        rd.forward(request, response); 
	}
}
