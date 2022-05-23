package com.example.jees.ese;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		String[] colours = request.getParameterValues("colour");   //se l'utente passa uno dei colore che vogliamo ok, altrimenti (getPratameterValues torna array, getParameter torna solo un valore) 
		String colour = colours != null? colours[0] : "pink";    //operatore ternario se il colore non è null prendi il primo, se l'utente non me ne ha scelto nemmeno uno allore è pink perchè in css lo legge in inglese
		log.trace("the chosen colour is: " + colour);
		
		
//		switch (colour) {
//		case "blue":          //questo lo abbiamo usato prima, quando ho usato il select option
//		case "green":         //questi nomi devono essere uguali al value che c'è in html
//		case "yellow":
//			log.trace("the chosen colour is: " + colour);
//			break;
//			default:                    //se non sceglie rifiliamo questo
//				colour = "pink";
//				break;
//		}
		
		request.setAttribute("colour", colour);  //anche questo gestisce il colore
		
		List<String> favs = new ArrayList<>();
		if (colours != null) {
			for (int i = 0; i < colours.length; i++) {
				favs.add(colours[i]);
			}
		}
		request.setAttribute("colours", favs);
		RequestDispatcher rd = request.getRequestDispatcher("logged.jsp");   //passo il controllo alla logged.jsp che dice ciao
        rd.forward(request, response); 
	}
}
