package com.tarea2.PracticaAPIREST.repository.entity;
import com.tarea2.PracticaAPIREST.dto.SubjectDTO;
import com.tarea2.PracticaAPIREST.dto.TeacherDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name ="TEACHER")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "teacher")
    private List<Subject> subjects = new ArrayList<>();

    //Constructores
    public Teacher() {
    }

    public Teacher(Integer teacherId, String teacherFirstName, String teacherLastName, Integer teacherIdDocument, Integer teacherAge, List<Subject> subjects) {
        this.teacherId = teacherId;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.teacherIdDocument = teacherIdDocument;
        this.teacherAge = teacherAge;
        this.subjects = subjects;
    }

    public Teacher(TeacherDTO teacherDTO) {
        this.teacherId = teacherDTO.getId();
        this.teacherFirstName = teacherDTO.getFirstName();
        this.teacherLastName = teacherDTO.getLastName();
        this.teacherIdDocument = teacherDTO.getIdDocument();
        this.teacherAge = teacherDTO.getAge();
        this.subjects = teacherDTO.getSubjects();
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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
