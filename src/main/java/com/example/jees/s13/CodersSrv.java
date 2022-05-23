package com.example.jees.s13;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
@WebServlet("/s13/coders")
public class CodersSrv extends HttpServlet {
    private static final Logger log = LogManager.getLogger(CodersSrv.class);

    @Resource(name = "jdbc/hron")   //viene iniettata da tomcat la risorsa, il database.
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        log.trace("called");
        try (CoderDao dao = new CoderDao(ds)) {    //creo dao passo data sources e dao pensa a stabilire la connessione
            request.setAttribute("coders", dao.getAll());    //faccio la get all che torna una lista di corder, java bean (serve solo per portare in giro dati)
            request.getRequestDispatcher("coders.jsp").forward(request, response);
        }
    }
}
