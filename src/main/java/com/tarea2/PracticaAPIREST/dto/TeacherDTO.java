package com.tarea2.PracticaAPIREST.dto;

import com.tarea2.PracticaAPIREST.repository.entity.Subject;
import com.tarea2.PracticaAPIREST.repository.entity.Teacher;
import java.util.List;

public class TeacherDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer idDocument;
    private Integer age;
    private Subject subject;

    //Constructores
    public TeacherDTO(){

    }

    public TeacherDTO(Teacher teacher){
        this.id = teacher.getTeacherId();
        this.firstName = teacher.getTeacherFirstName();
        this.lastName = teacher.getTeacherLastName();
        this.idDocument = teacher.getTeacherIdDocument();
        this.age= teacher.getTeacherAge();
        this.subject = teacher.getSubject();
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
