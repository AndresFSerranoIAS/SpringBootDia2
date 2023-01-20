package com.tarea2.PracticaAPIREST.services;

import com.tarea2.PracticaAPIREST.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    String save(StudentDTO studentDTO);
    List<StudentDTO> getAll();
    String update(StudentDTO studentDTO,Integer id);
    String delete(Integer id);
}
