package com.tarea2.PracticaAPIREST.repository.entity;

import com.tarea2.PracticaAPIREST.dto.StudentDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "STUDENT_ID",unique = true)
    private Integer studentId;
    @Column(name="STUDENT_FIRST_NAME",nullable = false)
    private String studentFirstName;
    @Column(name="STUDENT_LAST_NAME",nullable = false)
    private String studentLastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name= "STUDENT_BIRTH_DATE",nullable = false)
    private LocalDate studentBirthDate;
    @Column(name="STUDENT_IDDOCUMENT",nullable = false)
    private Integer studentIdDocument;
    @Column(name = "AGE")
    private Integer studentAge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBJECT_ID",nullable = true)
    private Subject subject;

    //Constructores
    public Student() {
    }

    public Student(Integer studentId, String studentFirstName, String studentLastName, LocalDate studentBirthDate, Integer studentIdDocument, Integer studentAge, Subject subject) {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentBirthDate = studentBirthDate;
        this.studentIdDocument = studentIdDocument;
        this.studentAge = studentAge;
        this.subject = subject;
    }

    public Student(StudentDTO studentDTO)
    {
        this.studentId = studentDTO.getId();
        this.studentFirstName = studentDTO.getFirstName();
        this.studentLastName = studentDTO.getLastName();
        this.studentIdDocument = studentDTO.getIdDocument();
        this.subject = studentDTO.getSubject();
        this.studentBirthDate = studentDTO.getBirthDate();
        this.studentAge = ageCalculator(studentDTO.getBirthDate());
    }

    //Getter y Setters

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public LocalDate getStudentBirthDate() {
        return studentBirthDate;
    }

    public void setStudentBirthDate(LocalDate studentBirthDate) {
        this.studentBirthDate = studentBirthDate;
    }

    public Integer getStudentIdDocument() {
        return studentIdDocument;
    }

    public void setStudentIdDocument(Integer studentIdDocument) {
        this.studentIdDocument = studentIdDocument;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
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
