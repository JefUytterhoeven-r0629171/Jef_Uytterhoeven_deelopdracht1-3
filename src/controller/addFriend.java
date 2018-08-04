package controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class addFriend  extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
                                                                            System.out.print(" \n 1");
        PersonService personService = super.getPersonService();
                                                                                 System.out.print(" \n 2" );
        String user = request.getParameter("user");
                                                                        System.out.print(" \n" + user +"d");
        String friend = request.getParameter("friend");
                                                                         System.out.print(" \n 4");
        Person puser = personService.getPerson(user);
        Person pfriend = personService.getPerson(friend);
        puser.addFriend(pfriend);

        return "index.jsp";
    }

    public String toJSON (ArrayList<Person> persons) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(persons);
    }

}
