package controller;

import domain.Person;
import domain.PersonService;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response) {
        String destination = "index.jsp";

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");

        System.out.println(email + " "+ password + " " + firstName + " " + lastName);

        PersonService personService = super.getPersonService();
        Person nieuw = new Person(email, password, firstName, lastName, Role.LID);
        nieuw.setGeslacht(gender);
        nieuw.setLeeftijd(Integer.parseInt(age));
        personService.addPerson(nieuw);
        return destination;
    }
}
