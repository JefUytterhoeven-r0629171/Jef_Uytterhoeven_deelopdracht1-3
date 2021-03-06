package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ChatRepository;
import db.ChatRepositoryStub;
import domain.PersonService;
import domain.Person;
import domain.Role;

public abstract class RequestHandler {
	
	private PersonService personService;
	private ChatRepositoryStub chatRepository;


	public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response);
	
	public void setModel (PersonService personService) {
		this.personService = personService;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public ChatRepositoryStub getChatRepository() {
		return chatRepository;
	}

	protected boolean isFromUserWithRole (HttpServletRequest request, Role role) {
		Person person = (Person) request.getSession().getAttribute("user");
		if (person != null && person.getRole().equals(role)) {
			return true;
		}
		return false;
	}

}
