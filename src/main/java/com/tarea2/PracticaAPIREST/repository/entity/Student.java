package com.tarea2.PracticaAPIREST.repository.entity;

import com.tarea2.PracticaAPIREST.dto.StudentDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Entity
public class Student {
    @Id
    @Column (name = "STUDENT_ID",unique = true)
    private Integer studentId;
    @Column(name="STUDENT_FIRST_NAME",nullable = false)
    private String studentFirstName;
    @Column(name="STUDENT_LAST_NAME",nullable = false)
    private String studentLastName;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name= "STUDENT_BIRTH_DATE",nullable = false)
    private Date studentBirthDate;
    @Column(name="STUDENT_IDDOCUMENT",nullable = false)
    private Integer studentIdDocument;
    @Formula("YEAR(CURRENT_DATE) - YEAR(birth_date) - (RIGHT(CURRENT_DATE, 5) < RIGHT(birth_date, 5))")
    @Column(name = "AGE",nullable = false)
    private Integer studentAge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    //Constructores
    public Student() {
    }

    public Student(Integer studentId, String studentFirstName, String studentLastName, Date studentBirthDate, Integer studentIdDocument, Integer studentAge, Subject subject) {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentBirthDate = studentBirthDate;
        this.studentIdDocument = studentIdDocument;
        this.studentAge = studentAge;
        this.subject = subject;
    }

    public Student(Integer studentId, String studentFirstName) {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
    }

    public Student(StudentDTO studentDTO) {
        this.studentId = studentDTO.getId();
        this.studentFirstName = studentDTO.getFirstName();
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

    public Date getStudentBirthDate() {
        return studentBirthDate;
    }

    public void setStudentBirthDate(Date studentBirthDate) {
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
}
