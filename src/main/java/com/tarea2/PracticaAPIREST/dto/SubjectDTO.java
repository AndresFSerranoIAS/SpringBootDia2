package com.tarea2.PracticaAPIREST.dto;

import com.tarea2.PracticaAPIREST.repository.entity.Student;
import com.tarea2.PracticaAPIREST.repository.entity.Subject;
import com.tarea2.PracticaAPIREST.repository.entity.Teacher;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class SubjectDTO {
    private Integer id;
    private String subjectName;
    private String schedule;
    private String topic;
    private List<Student> students;
    private Teacher teacher;

    public SubjectDTO() {
    }

    public SubjectDTO(Integer id, String subjectName, String schedule, String topic, List<Student> students, Teacher teacher) {
        this.id = id;
        this.subjectName = subjectName;
        this.schedule = schedule;
        this.topic = topic;
        this.students = students;
        this.teacher = teacher;
    }

    public SubjectDTO(Subject subject) {
        this.id = subject.getSubjectId();
        this.subjectName = subject.getSubjectName();
        this.schedule = subject.getSchedule();
        if (subject.getTopic()!=null){
            this.topic = subject.getTopic();
        }else {
            this.topic = "Materia impartida por la empresa IAS Software";
        }
        this.students = subject.getStudents();
        this.teacher = subject.getTeacher();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        for (Student student: students){
            student.setStudentAge(ageCalculator(student.getStudentBirthDate()));
            student.setSubject(new Subject(this));
        }
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public Integer ageCalculator(LocalDate birthDate){
        LocalDate curDate = LocalDate.now();
        return Period.between(birthDate, curDate).getYears();
    }
}
