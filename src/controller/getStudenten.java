package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.StudentenRepositoryStub;
import db.UitgavenRepositoryStub;
import domain.PersonService;
import domain.Student;
import domain.Uitgaven;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class getStudenten extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        PersonService personService = super.getPersonService();
        StudentenRepositoryStub studentenmodel = personService.getStudentenstub();

        try {
            String uitgavenJSON = this.toJSON(studentenmodel.getStudenten());
            response.setContentType("application/json");
            response.getWriter().write(uitgavenJSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "uitgaven.jsp";
    }

    public String toJSON (List<Student> studenten) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(studenten);
    }
}
