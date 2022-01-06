package org.itstep.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.itstep.main.WeatherService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String realPath = sce.getServletContext().getRealPath("/");
        String configLocation = realPath + "/WEB-INF/config/application.xml";
        var applicationContext = new FileSystemXmlApplicationContext(configLocation);
        var service = applicationContext.getBean(WeatherService.class);
        ServletContext context = sce.getServletContext();
        context.setAttribute("service" , service);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
