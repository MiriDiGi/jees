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

@WebFilter(urlPatterns = { "/esempio/x/*" })   
public class FilterX implements Filter {
    private static final Logger log = LogManager.getLogger(FilterX.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
       
        HttpSession session = ((HttpServletRequest) request).getSession();
        String user = (String) session.getAttribute("user");

        log.trace("Access to restricted area for " + user);
        if (user == null) {  
            // new request, the URL is _not_ relative to the current web app
            ((HttpServletResponse) response).sendRedirect("/jees/esempio/index.jsp"); 

            // in both case, remember to end here the filtering
            return;   
        }

        chain.doFilter(request, response); 
  
    }
}
