package com.tarea2.PracticaAPIREST.repository.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @Column(name = "SUBJECT_ID",unique = true)
    private Integer subjectId;

    @Column(name="SUBJECT_NAME",nullable = false)
    private String subjectName;

    @Column(name = "SCHEDULE",nullable = false)
    private String schedule;

    @Column(name = "TOPIC")
    private String topic;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "subject")
    private List<Teacher> teachers = new ArrayList<>();

    //Constructores
    public Subject() {
    }

    public Subject(Integer subjectId, String subjectName, String schedule, String topic, List<Student> students, List<Teacher> teachers) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.schedule = schedule;
        this.topic = topic;
        this.students = students;
        this.teachers = teachers;
    }

    public Subject(Integer subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    //Getter y Setters
    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
