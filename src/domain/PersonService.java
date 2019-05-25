package domain;

import java.util.List;

import db.*;

public class PersonService {
	private PersonRepository personRepository = new PersonRepositoryStub();
	private ChatRepositoryStub chatRepository = new ChatRepositoryStub();
	private UitgavenRepositoryStub uitgavenrep = new UitgavenRepositoryStub();
	private  StudentenRepositoryStub studentenstub = new StudentenRepositoryStub();
	public PersonService(){
	}

	public UitgavenRepositoryStub getUitgavenrep() {
		return uitgavenrep;
	}

	public void setUitgavenrep(UitgavenRepositoryStub uitgavenrep) {
		this.uitgavenrep = uitgavenrep;
	}

	public ChatRepositoryStub getChatRepository() {
		return chatRepository;
	}

	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}

	public StudentenRepositoryStub getStudentenstub() {
		return studentenstub;
	}

	public void setStudentenstub(StudentenRepositoryStub studentenstub) {
		this.studentenstub = studentenstub;
	}
}
