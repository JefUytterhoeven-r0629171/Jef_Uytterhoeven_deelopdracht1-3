package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ChangeState  extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("user");
        String state = request.getParameter("state");
        PersonService personService = super.getPersonService();
        Person puser = personService.getPerson(user);
        puser.setStatus(state);

        try {
            String personenJSON = this.toJSON(puser);
            response.setContentType("application/json");
            response.getWriter().write(personenJSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "index.jsp";
    }

    public String toJSON (Person persons) throws JsonProcessingException {
        // System.out.print(" \n \n \n"  +"asub1 \n");
        ObjectMapper mapper = new ObjectMapper();
        //System.out.print(" \n \n \n" + "asub2 \n" + persons.get(0).getUserId());
        return mapper.writeValueAsString(persons);
    }
}
