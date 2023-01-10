package com.uniyaz.servlet;

import com.uniyaz.actor.domain.Actor;
import com.uniyaz.actor.service.ActorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ActorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Actor actor = new Actor();
        ActorService actorService = new ActorService();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        Date date = new Date();


        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        actor.setLastUpdate(date);

        actorService.save(actor);
        resp.getWriter().write("Success");
    }
}
