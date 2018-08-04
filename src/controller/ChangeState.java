package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeState  extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("user");
        String state = request.getParameter("state");
        PersonService personService = super.getPersonService();
        Person puser = personService.getPerson(user);
        puser.setStatus(state);
        return "index.jsp";
    }
}
