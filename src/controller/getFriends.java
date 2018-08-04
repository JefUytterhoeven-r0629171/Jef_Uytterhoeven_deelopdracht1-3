package controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
public class getFriends  extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String destination = "index.jsp";
        ArrayList<Person> friends = new ArrayList<Person>();

        PersonService personService = super.getPersonService();

        String user = request.getParameter("user");
        Person puser = personService.getPerson(user);

        for(int i =0 ; i< puser.getFriendids().size(); i++){
            friends.add(personService.getPerson(puser.getFriendids().get(i)));
        }

        try {
             String personenJSON = this.toJSON(friends);
             response.setContentType("application/json");
            response.getWriter().write(personenJSON);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         return "index.jsp";
    }

    /*old friendlist code
    public ArrayList<Person> removeFriendlist(ArrayList<Person> persons){
        ArrayList<Person> nofriends = new ArrayList<>();
        Person test = new Person();
        for (int i = 0 ;i < persons.size() ; i++){
            nofriends.add( test.removeFriends(persons.get(i)));
        }
        return nofriends;
    }

    */

    // change object to json
    public String toJSON (ArrayList<Person> persons) throws JsonProcessingException {
       // System.out.print(" \n \n \n"  +"asub1 \n");
        ObjectMapper mapper = new ObjectMapper();
        //System.out.print(" \n \n \n" + "asub2 \n" + persons.get(0).getUserId());
        return mapper.writeValueAsString(persons);
    }
}
