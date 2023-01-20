package com.tarea2.PracticaAPIREST.services;
import com.tarea2.PracticaAPIREST.dto.TeacherDTO;
import java.util.List;

public interface ITeacherService {
    void save(TeacherDTO teacher);
    List<TeacherDTO> getAll();
    String update(TeacherDTO teacher);
    void delete(TeacherDTO teacher);
}
