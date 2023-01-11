package com.uniyaz.servlet;

import com.google.gson.Gson;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.service.CityService;
import com.uniyaz.country.domain.Country;
import com.uniyaz.country.service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CityServlet extends HttpServlet {
   /* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CityService cityService = new CityService();
        List<City> cityList = cityService.findAll();
        String html = "<table>";
        for (City city : cityList) {
            html += "<tr>" +
                    "<td>" + city.getId() + "</td>" +
                    "<td>" + city.getCity() + "</td>" +
                    "<td>" + city.getCountry() + "</td>" +
                    "</tr>";
        }
        html += "</table>";
        resp.getWriter().write(html);

    }*/


}
