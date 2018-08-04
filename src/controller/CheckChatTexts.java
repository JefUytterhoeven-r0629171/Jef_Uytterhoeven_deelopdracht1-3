package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.ChatRepositoryStub;
import domain.Chat;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckChatTexts extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        PersonService personService = super.getPersonService();
        ChatRepositoryStub chatrepo = personService.getChatRepository();
        String chatid = request.getParameter("chatid");
        Chat chat = null;

        for (int i = 0 ; i< chatrepo.getAll().size();i++){
            if(chatrepo.getAll().get(i).getChatId().equals(chatid)){
                chat = chatrepo.getAll().get(i);
            }
        }
        try {

                String chatsJSON = this.toJSON(chat);
                response.setContentType("application/json");
                response.getWriter().write(chatsJSON);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index.jsp";
    }

    public String toJSON (Chat chats) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(chats);
    }
}
