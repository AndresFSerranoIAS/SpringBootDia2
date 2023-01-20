package com.tarea2.PracticaAPIREST.repository.entity;

import com.tarea2.PracticaAPIREST.dto.SubjectDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUBJECT_ID",unique = true)
    private Integer subjectId;

    @Column(name="SUBJECT_NAME",nullable = false)
    private String subjectName;

    @Column(name = "SCHEDULE",nullable = false)
    private String schedule;

    @Column(name = "TOPIC", nullable = true)
    private String topic;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    //Constructores
    public Subject() {
    }

    public Subject(Integer subjectId, String subjectName, String schedule, String topic, List<Student> students, Teacher teacher) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.schedule = schedule;
        this.topic = topic;
        this.students = students;
        this.teacher = teacher;
    }

    public Subject(Integer subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public Subject(SubjectDTO subjectDTO) {
        this.subjectName = subjectDTO.getSubjectName();
        this.schedule = subjectDTO.getSchedule();
        if (subjectDTO.getTopic()!=null){
            this.topic = subjectDTO.getTopic();
        }else {
            this.topic = "Materia impartida por la empresa IAS Software";
        }

        this.students = subjectDTO.getStudents();
        this.teacher = subjectDTO.getTeacher();
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
