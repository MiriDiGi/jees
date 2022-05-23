package com.example.jees.s10;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s10/greeter")
public class Greeter extends HttpServlet {
    private static final Logger log = LogManager.getLogger(Greeter.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("called");

        String user = request.getParameter("user");    //leggo parametro user

        HttpSession session = request.getSession();     //chiedo alla request di darmi una sessione
        String prevUser = (String) session.getAttribute("user");    //questo previous lo prendo dalla session
        if (prevUser == null) {
            prevUser = "";
        }

        if (user == null) {
            session.invalidate();       //dal bottone di reset parte la request senza parametri e questa da l'invalidate()
        } else if (user.isBlank()) {
            session.setAttribute("user", "unknown");  //se non ho passato niente user è unknown
        } else {  
            session.setAttribute("user", user);    //metto nell'attributo user il nome dato
        }

        request.setAttribute("previous", prevUser);    //metto in previus l'attributo prevuser
        request.getRequestDispatcher("greeter.jsp").forward(request, response);
    }
}
