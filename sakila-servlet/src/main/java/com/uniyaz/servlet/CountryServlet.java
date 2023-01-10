package com.uniyaz.servlet;

import com.uniyaz.country.domain.Country;
import com.uniyaz.country.service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CountryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CountryService countryService = new CountryService();
        List<Country> countryList = countryService.findAll();
        String html = "<table>";
        for (Country country : countryList) {
            html += "<tr><td>" + country.getId() + "</td><td>" + country.getCountry() + "</td></tr>";
        }
        html += "</table>";
        resp.getWriter().write(html);

    }
}
