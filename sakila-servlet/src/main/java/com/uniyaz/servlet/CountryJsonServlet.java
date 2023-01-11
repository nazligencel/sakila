package com.uniyaz.servlet;

import com.google.gson.Gson;
import com.uniyaz.country.domain.Country;
import com.uniyaz.country.service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CountryJsonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CountryService countryService = new CountryService();
        List<Country> countryList = countryService.findAll();

        Gson gson = new Gson();
        String countryListAsJson = gson.toJson(countryList);

        resp.setContentType("application/json");
        resp.getWriter().write(countryListAsJson);

    }
}
