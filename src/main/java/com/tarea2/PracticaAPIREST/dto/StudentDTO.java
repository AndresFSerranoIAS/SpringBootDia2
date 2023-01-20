package com.tarea2.PracticaAPIREST.dto;
import com.tarea2.PracticaAPIREST.repository.entity.Student;
import com.tarea2.PracticaAPIREST.repository.entity.Subject;

import java.util.Date;

public class StudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer idDocument;
    private Subject subject;
    private Date birthDate;

    //Constructores
    public StudentDTO(){
    }
    public StudentDTO(Student student){
        this.id = student.getStudentId();
        this.firstName = student.getStudentFirstName();
        this.lastName = student.getStudentLastName();
        this.idDocument = student.getStudentIdDocument();
        this.subject = student.getSubject();
        this.birthDate = student.getStudentBirthDate();
    }

    //Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Integer idDocument) {
        this.idDocument = idDocument;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
