package com.tarea2.PracticaAPIREST.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Teacher {
    @Id
    @Column(name = "TEACHER_ID",unique = true)
    private Integer teacherId;

    @Column(name="TEACHER_FIRST_NAME",nullable = false)
    private String teacherFirstName;

    @Column(name = "TEACHER_LAST_NAME",nullable = false)
    private String teacherLastName;

    @Column(name= "TEACHER_IDDOCUMENT",nullable = false)
    private Integer teacherIdDocument;

    @Column(name = "TEACHER_AGE", nullable = false)
    private Integer teacherAge;


    @OneToOne
    private Subject subject;

    //Constructores
    public Teacher() {
    }

    public Teacher(Integer teacherId, String teacherFirstName, String teacherLastName, Integer teacherIdDocument, Integer teacherAge, Subject subject) {
        this.teacherId = teacherId;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.teacherIdDocument = teacherIdDocument;
        this.teacherAge = teacherAge;
        this.subject = subject;
    }

    public Teacher(Integer teacherId, String teacherFirstName) {
        this.teacherId = teacherId;
        this.teacherFirstName = teacherFirstName;
    }

    //Getter y Setters
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public Integer getTeacherIdDocument() {
        return teacherIdDocument;
    }

    public void setTeacherIdDocument(Integer teacherIdDocument) {
        this.teacherIdDocument = teacherIdDocument;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
