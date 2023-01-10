package com.uniyaz.servlet;

import com.google.gson.Gson;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import com.uniyaz.city.service.CityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CountryJsonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CityService cityService = new CityService();

        CityQueryFilterDto cityQueryFilterDto = new CityQueryFilterDto();

        String countryString = req.getParameter("country");
        cityQueryFilterDto.setCountryName(countryString);

        List<City> allByQueryFilterDto = cityService.findAllByQueryFilterDto(cityQueryFilterDto);

        Gson gson = new Gson();
        String cityListAsGson = gson.toJson(allByQueryFilterDto);

        resp.setContentType("application/json");
        resp.getWriter().write(cityListAsGson);
    }
}
