package com.example.jees.s15;

import java.time.LocalTime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebListener
public class MyContextListener implements ServletContextListener {    //viene invocata da tomcat automaticamente quando ha completato la sua operazione
    private static final Logger log = LogManager.getLogger(MyContextListener.class);

    public void contextInitialized(ServletContextEvent sce) {     //facciamo anche il set di un attributo, lo settiamo a livello di servlet (attributo start)
        log.trace("called");
        sce.getServletContext().setAttribute("start", LocalTime.now());
    }
}
