package com.example.jees.s02;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")      //sarebbe richiesto che le classi servlet siano serializzabili, passate in giro
@WebServlet("/s02/timer")      //annotazione associata a questo indirizzo nome classe e indirizzo possono avere nomi diversi. tipicamente si chiama srv/timer
public class Timer extends HttpServlet {          //servlet è una classe (http servletè un classe astratta, non può essere istanziata, dentro ha costanti con tutti i metodi http che possiamo usare)                    //non c'è più il main ma solo una classe e metodi che rispondono alle request degli utenti. tomcat gestisce
    private static final Logger log = LogManager.getLogger(Timer.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   //la doget genera risposta d'errore, per non generarla devo fare un override, infatti ecco. così genera una risposta
            throws ServletException, IOException {                                    // a noi interessano solo doget e dopost ma qui abbiamo solo il doget
        log.trace("called");

        response.setContentType("text/html");   //la response passata da tomcat, dentro torno l'html codificato in utf-8
        response.setCharacterEncoding("utf-8");
        try (PrintWriter writer = response.getWriter()) {        //try with resources. prendo il metodo writer, nella response mettici tutto questo
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head><meta charset=\"utf-8\">");
            writer.println("<link rel=\"icon\" href=\"data:;base64,=\">");
            writer.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"/jees/css/simple.css\">");
            writer.println("<title>Hello Servlet</title></head>");
            writer.println("<body>");
            writer.println("<h1>" + LocalTime.now() + "</h1>");
            writer.println("<a href=\"..\">back home</a>");
            writer.println("</body></html>");
        }
    }
}
