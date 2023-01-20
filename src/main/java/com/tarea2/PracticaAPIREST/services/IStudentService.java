package com.tarea2.PracticaAPIREST.services;

import com.tarea2.PracticaAPIREST.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    void save(StudentDTO student);
    List<StudentDTO> getAll();
    void update(StudentDTO student);
    void delete(StudentDTO student);
}
