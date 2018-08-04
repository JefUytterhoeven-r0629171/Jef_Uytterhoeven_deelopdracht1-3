package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.ChatRepositoryStub;
import domain.Chat;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class OpenChatWindows extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
 //       System.out.print("openchatwindow controller");
        PersonService personService = super.getPersonService();
        ChatRepositoryStub chatrepo = personService.getChatRepository();

        String user = request.getParameter("user");
 //       System.out.print(" \n \n openchatwindow controller person test" + user );
        if(user != null) {
            Person user1 = personService.getPerson(user);
            ArrayList<Chat> chats = (ArrayList<Chat>) chatrepo.getAll();
            ArrayList<Chat> userchats = new ArrayList<>();

            for (int i = 0; i < chats.size(); i++) {
                if (chats.get(i).isDeelnemer(user1)) {
                    userchats.add(chats.get(i));
                }

            }

            try {
                String chatsJSON = this.toJSON(userchats);
 //               System.out.print(chatsJSON);
                response.setContentType("application/json");
                response.getWriter().write(chatsJSON);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "index.jsp";
    }

    public String toJSON (ArrayList<Chat> chats) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(chats);
    }
}
