package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Person;
import domain.Role;

public class PersonRepositoryStub implements PersonRepository {
	private Map<String, Person> persons = new HashMap<String, Person>();

	public PersonRepositoryStub () {
		Person administrator = new Person("bib@ucll.be", "t", "Bib", "Liothekaris", Role.BIB);
		add(administrator);
		Person jan = new Person("jan@ucll.be", "t", "Jan", "Janssens", Role.LID);
		add(jan);
		Person an = new Person("an@ucll.be", "t", "an", "goosens", Role.LID);
		add(an);
		Person ron = new Person("ron@ucll.be", "t", "ron", "weasley", Role.LID);
		add(ron);
		Person harry = new Person("harry@ucll.be", "t", "harry", "potter", Role.LID);
		add(harry);
		Person hermoini = new Person("hermoini@ucll.be", "t", "hermoini", "granger", Role.LID);
		add(hermoini);
		Person albus = new Person("albus@ucll.be", "t", "albus", "dumbeldore", Role.LID);
		add(albus);
		Person remus = new Person("remus@ucll.be", "t", "remus", "lupin", Role.LID);
		add(remus);

	}

	public Person get(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		return persons.get(personId);
	}

	public List<Person> getAll(){
		return new ArrayList<Person>(persons.values());
	}

	public void add(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		if (persons.containsKey(person.getUserId())) {
			throw new IllegalArgumentException("User already exists");
		}
		persons.put(person.getUserId(), person);
	}

	public void update(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		persons.put(person.getUserId(), person);
	}

	public void delete(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		persons.remove(personId);
	}

	public Person getAuthenticatedUser(String email, String password) {
		Person person = get(email);

		if (person != null && person.isCorrectPassword(password)) {
			return person;
		}
		else {
			return null;
		}
	}
}
