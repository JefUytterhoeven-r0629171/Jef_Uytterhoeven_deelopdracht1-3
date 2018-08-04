package controller;

import db.ChatRepositoryStub;
import domain.Chat;
import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewChat extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//        System.out.print(" new chat  controller");
        String user1name = request.getParameter("user1");
        String user2name = request.getParameter("user2");
        PersonService personService = super.getPersonService();
        ChatRepositoryStub chatrepo = personService.getChatRepository();

 //       System.out.print("\n\n\n user 1 = " + user1name +"\n user2 = " +user2name);
        Person user1 = personService.getPerson(user1name);
        Person user2 = personService.getPerson(user2name);

        Chat chat = new Chat(user1,user2);
  //      System.out.print("\n\n\n "+ chat.toString());
  //      System.out.print("\n\n\n +" +  chatrepo.toString());
        chatrepo.add(chat);

  //      System.out.print("\n\n\n new chat  controller");
        return "index.jsp";
    }
}
