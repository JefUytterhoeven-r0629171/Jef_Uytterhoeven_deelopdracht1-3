package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.UitgavenRepositoryStub;
import domain.Person;
import domain.PersonService;
import domain.Uitgaven;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class getuitgaven  extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        PersonService personService = super.getPersonService();
        UitgavenRepositoryStub uitgavenmodel = personService.getUitgavenrep();

        try {
            String uitgavenJSON = this.toJSON(uitgavenmodel.getAll());
            response.setContentType("application/json");
            response.getWriter().write(uitgavenJSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "uitgaven.jsp";
    }

    public String toJSON (List<Uitgaven> uitgaven) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(uitgaven);
    }
}
