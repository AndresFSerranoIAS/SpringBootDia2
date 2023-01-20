package com.tarea2.PracticaAPIREST.services;

import com.tarea2.PracticaAPIREST.dto.StudentDTO;
import com.tarea2.PracticaAPIREST.repository.entity.Student;

import java.util.List;

public interface IStudentService {
    String save(StudentDTO studentDTO);
    List<StudentDTO> getAll();
    String update(StudentDTO studentDTO,Integer id);
    String delete(Integer id);

    Student getOneStudent(Integer id);
}
