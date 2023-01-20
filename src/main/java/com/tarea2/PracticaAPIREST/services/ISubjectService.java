package com.tarea2.PracticaAPIREST.services;
import com.tarea2.PracticaAPIREST.dto.SubjectDTO;
import java.util.List;

public interface ISubjectService {
    void save(SubjectDTO subject);
    List<SubjectDTO> getAll();
    String update(SubjectDTO subject);
    void delete(SubjectDTO subject);
}
