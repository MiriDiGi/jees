package com.example.jees.s03;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s03/checker")    //chi chiama checker
public class Checker extends HttpServlet {      //classe la definisco io, l'oggetto per il doget lo crea tomcat
    private static final Logger log = LogManager.getLogger(Checker.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");    //chiedo alla request se c'è un parametro che si chiama user, se sì prendilo e
        log.debug("User is {" + user + "}");           //metti il parametro nella stringa user. lo loggo

        Set<Character> set = new TreeSet<>();          //ho un set di caratteri, chiedo 
        if (user != null) {                            //accertati se l'utente mi ha passato una cosa buona
            for (char c : user.toCharArray()) {        //converte in un array di caratteri, posso scrivere:
           // for (int i = 0; i < user.length(); i++){
           // char c = user.charAt(i);
           // char low = Character.toLowerCase(c);
           // set.add(low); }
            	// oppure scrivo contratto:
           //  set.add(Character.toLowerCase(user.charAt(i))); }
                set.add(Character.toLowerCase(c));    //prendi il carattere e aggiungilo al set, non riesco ad aggiungere l'ultima lettera di bob perchè set non accetta duplicati
            }
        }
        request.setAttribute("set", set);   //set di caratteri lo metto nella request

        RequestDispatcher rd = request.getRequestDispatcher("/s03/checker.jsp");  //controllo passato a jsp dove dentro &{set} metterà i caratteri di set
        rd.forward(request, response);    //passo request e response

        // same as above, in a more compact way
        // request.getRequestDispatcher("checker.jsp").forward(request, response);
    }
}
