package com.tarea2.PracticaAPIREST.services;
import com.tarea2.PracticaAPIREST.dto.TeacherDTO;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface ITeacherService {
    String save(TeacherDTO teacherDTO);
    List<TeacherDTO> getAll();
    String update(TeacherDTO teacherDTO, Integer id);
    String delete(Integer id);
    String setSubject(Integer idSubject ,Integer id);
}
