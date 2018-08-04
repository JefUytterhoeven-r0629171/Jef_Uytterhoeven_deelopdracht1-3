package controller;

import db.UitgavenRepositoryStub;
import domain.PersonService;
import domain.Uitgaven;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adduitgaven extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        PersonService personService = super.getPersonService();
        UitgavenRepositoryStub uitgavenmodel = personService.getUitgavenrep();

        String naam = request.getParameter("naam");
        String bedrag = request.getParameter("bedrag");
        String datum = request.getParameter("datum");

        Uitgaven uitgaven = new Uitgaven(naam , bedrag , datum);
        uitgavenmodel.add(uitgaven);

        return "uitgaven.jsp";
    }
}
