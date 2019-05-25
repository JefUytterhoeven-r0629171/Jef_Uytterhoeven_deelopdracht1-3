package db;

import domain.Student;

import java.util.ArrayList;

public class StudentenRepositoryStub {
    private ArrayList<Student> studenten = new ArrayList();

    public StudentenRepositoryStub() {
        Student  newstudent = new Student("jef", "web4","16/08/1996" , "9");
        studenten.add(newstudent);
    }

    public ArrayList<Student> getStudenten() {
        return studenten;
    }

    public void addStudent(Student student){
        studenten.add(student);
    }
}
