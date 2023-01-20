package com.tarea2.PracticaAPIREST.dto;

import com.tarea2.PracticaAPIREST.repository.entity.Student;
import com.tarea2.PracticaAPIREST.repository.entity.Subject;
import java.time.LocalDate;
import java.time.Period;

public class StudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Integer idDocument;
    private Integer age ;
    private Subject subject;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String firstName, String lastName, LocalDate birthDate, Integer idDocument, Integer age, Subject subject) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.idDocument = idDocument;
        this.age = ageCalculator(birthDate);
        this.subject = subject;
    }

    public StudentDTO(Student student) {
        this.id = student.getStudentId();
        this.firstName = student.getStudentFirstName();
        this.lastName = student.getStudentLastName();
        this.birthDate = student.getStudentBirthDate();
        this.idDocument = student.getStudentIdDocument();
        this.age  = ageCalculator(student.getStudentBirthDate());
        this.subject = student.getSubject();
    }

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    public Integer ageCalculator(LocalDate birthDate){
        LocalDate curDate = LocalDate.now();
        return Period.between(birthDate, curDate).getYears();
    }
}
