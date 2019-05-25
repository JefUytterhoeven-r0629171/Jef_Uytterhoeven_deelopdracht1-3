package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Users extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.print(" \n getperson controller is called");
        String destination = "index.jsp";
        PersonService personService = super.getPersonService();
        try {
            String personenJSON = this.toJSON((ArrayList<Person>) personService.getPersons());
            response.setContentType("application/json");
            response.getWriter().write("dit is een test");

        } catch (JsonProcessingException e) {
            System.out.print(" \n ERROR ERROR user controller");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.print(" \n ERROR ERROR user controller");
            e.printStackTrace();
        }

        return destination;
    }

    public String toJSON (ArrayList<Person> persons) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(persons);
    }
}
