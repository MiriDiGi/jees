package com.example.jees.s16;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter(urlPatterns = { "/s16/restricted/*" })   //filtro di sicurezza
public class FilterRestricted implements Filter {
    private static final Logger log = LogManager.getLogger(FilterRestricted.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            // put a denial message in the response and return
            response.setContentType("text/plain");
            response.setCharacterEncoding("utf-8");

            response.getWriter().println("Only HTTP requests accepted!");
            return;
        }

        HttpSession session = ((HttpServletRequest) request).getSession();
        Boolean logged = (Boolean) session.getAttribute("logged");

        log.trace("Access to restricted area is " + logged);
        if (logged == null || !logged) {    //rimando alla pagina di login
            // new request, the URL is _not_ relative to the current web app
            ((HttpServletResponse) response).sendRedirect("/jees/s16/login.html");  //posso rindirizzare ad un'altra html

            // use this to keep the original request
//                request.getRequestDispatcher("/s16/login.html").forward(request, response);

            // in both case, remember to end here the filtering
            return;   //se c'è una redirector o un forward non posso fare più nulla dopo, è obbligatorio il return
        }

        chain.doFilter(request, response);  //rimanda al filtro successivo
  
        // put your filter-out behavior here
        log.trace("Exiting restricted area");

        // here, login is valid just for one access!
        session.setAttribute("logged", false);
    }
}
