
package controller;

import db.StudentenRepositoryStub;

import domain.PersonService;
import domain.Student;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class addstudent  extends RequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        PersonService personService = super.getPersonService();
        StudentenRepositoryStub studentenmodel = personService.getStudentenstub();

        String naam = request.getParameter("naam");
        String vak = request.getParameter("vak");
        String datum = request.getParameter("datum");
        String uur = request.getParameter("uur");



        Student nieuwestudent = new Student(naam , vak, datum , uur);
        studentenmodel.addStudent(nieuwestudent);
        System.out.println("student word toegevoegd er zijn nu " + studentenmodel.getStudenten().size() + " studenten in de database naam = " + naam);

        return "studenten.jsp";
    }

}
