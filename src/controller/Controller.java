package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import db.ChatRepository;
import db.ChatRepositoryStub;
import db.UitgavenRepositoryStub;
import domain.Person;
import domain.PersonService;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersonService model = new PersonService();
	public UitgavenRepositoryStub uitgavenmodel = new UitgavenRepositoryStub();
	private ChatRepositoryStub chats = new ChatRepositoryStub();

	private ControllerFactory controllerFactory = new ControllerFactory();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPut(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException
	{
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
		String assaction = request.getParameter("asyncAction");
        String type = request.getParameter("type");
        String destination = "index.jsp";
       // System.out.print("hij zit in de top controller");



        if (action != null) {
			if (action.equals("angular")){
				handelRequest(request, response);
			}else{
				RequestHandler handler;
				try {
					handler = controllerFactory.getController(action, model);
					destination = handler.handleRequest(request, response);
				}
				catch (NotAuthorizedException exc) {
					List<String> errors = new ArrayList<String>();
					errors.add(exc.getMessage());
					request.setAttribute("errors", errors);
					destination="index.jsp";
				}
				if(type == null) {
					System.out.print("controller verstuurt jsp pagina");
					RequestDispatcher view = request.getRequestDispatcher(destination);
					view.forward(request, response);
				}
			}

        }

        if(action == null){
			if(type == null) {
				System.out.print("controller verstuurt jsp pagina");
				RequestDispatcher view = request.getRequestDispatcher(destination);
				view.forward(request, response);
			}
		}

	}
	public void handelRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("er word een angular request gedaan");
		String action = request.getParameter("asyncAction");

		if (action != null)
			switch (action)
			{
				case "getUser":
					getUser(request, response);
					break;
				case "getAllUsers":
					getAllUser(request, response);
					break;
				case "updateUser":
					putUser(request, response);
					break;
			}

	}

	public String toJSON(Object object) throws JsonProcessingException
	{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}

	private String removeQuotationMarks(JsonNode node, String path)
	{
		String temp = node.path(path).toString();
		StringBuilder sb = new StringBuilder(temp);
		sb.deleteCharAt(temp.length() - 1);
		sb.deleteCharAt(0);

		return sb.toString();
	}

	private void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String userId = request.getParameter("username");
		if (!(model.getPerson(userId) == null) || !userId.isEmpty())
		{
			String userJSON = this.toJSON(model.getPerson(userId));
			response.setContentType("application/json");
			response.getWriter().write(userJSON);
		}
	}

	private void getAllUser(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		System.out.println("en deze request is GET-ALL-USERS ");
		String userJSON = this.toJSON(model.getPersons());
		System.out.println("en deze request is GET-ALL-USERS  = " + userJSON);
		response.setContentType("application/json");
		response.getWriter().write(userJSON);
	}


	private void putUser(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		System.out.println("en deze request is PUT-USER ");

		String JSONdata = "";
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader reader = request.getReader();
		String line;
		while ((line = reader.readLine()) != null)
		{
			JSONdata += line;
		}

		JsonNode root = mapper.readTree(JSONdata);
		String username = removeQuotationMarks(root, "userId");
		String firstName = removeQuotationMarks(root, "firstName");
		String lastName = removeQuotationMarks(root, "lastName");

		Person updPerson = model.getPerson(username);
		System.out.println("selected user : " + updPerson.getFirstName() + updPerson.getLastName());
		updPerson.setFirstName(firstName);
		updPerson.setLastName(lastName);
		System.out.println("updated user : " + updPerson.getFirstName() + updPerson.getLastName());

		model.updatePersons(updPerson);
	}


}
