package com.tarea2.PracticaAPIREST.dto;

import com.tarea2.PracticaAPIREST.repository.entity.Student;
import com.tarea2.PracticaAPIREST.repository.entity.Subject;

public class StudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer idDocument;
    private String SubjectName;

    //Constructores
    public StudentDTO(){
    }
    public StudentDTO(Student student){
        this.id = student.getStudentId();
        this.firstName = student.getStudentFirstName();
    }
    public StudentDTO(Student student, Subject subject){
        this.id = student.getStudentId();
        this.firstName = student.getStudentFirstName();
        this
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
}
