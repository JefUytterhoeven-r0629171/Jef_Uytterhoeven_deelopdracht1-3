package controller;

import db.ChatRepositoryStub;
import domain.Chat;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChatAddMessage extends  RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        PersonService personService = super.getPersonService();
        ChatRepositoryStub chatrepo = personService.getChatRepository();
        String chatid = request.getParameter("chatid");
        String message = request.getParameter("message");
        Chat chat = null;
        for (int i = 0 ; i< chatrepo.getAll().size();i++){

            if(chatrepo.getAll().get(i).getChatId().equals(chatid)){
                chat = chatrepo.getAll().get(i);
            }
        }


        chat.addMessage(message);
        return "index.jsp";
    }
}
