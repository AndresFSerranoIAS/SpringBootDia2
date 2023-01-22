package com.tarea2.PracticaAPIREST.repository.mappers;

import com.tarea2.PracticaAPIREST.dto.SubjectDTO;
import com.tarea2.PracticaAPIREST.repository.entity.Subject;

public class SubjectMapper {
    public static Subject toSubject(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectDTO.getSubjectName());
        subject.setSchedule(subjectDTO.getSchedule());
        subject.setSubjectId(subjectDTO.getId());
        subject.setStudents(subjectDTO.getStudents());
        subject.setTeacher(subjectDTO.getTeacher());
        subject.setTopic(subjectDTO.getTopic());
        return subject;
    }

    public static SubjectDTO toSubjectDTO(Subject subject) {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setSubjectName(subject.getSubjectName());
        return subjectDTO;
    }
}
