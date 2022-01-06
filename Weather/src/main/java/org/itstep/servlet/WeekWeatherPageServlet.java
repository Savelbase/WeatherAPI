package org.itstep.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.itstep.main.WeatherService;

import java.io.IOException;

public class WeekWeatherPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        ServletContext servletContext = req.getServletContext();
        var service = (WeatherService)servletContext.getAttribute("service");
        String name = req.getParameter("name");
        if(name!=null){
            System.out.println(name);
            service.getProvider().setCountryName(name);
        }
        req.setAttribute("weather" , service.getProvider().getWeatherOnThisDay());
        req.setAttribute("weather" , service.getProvider().getWeatherForWeek());
        req.getRequestDispatcher("/pages/weather.jsp").forward(req,resp);
    }
}
