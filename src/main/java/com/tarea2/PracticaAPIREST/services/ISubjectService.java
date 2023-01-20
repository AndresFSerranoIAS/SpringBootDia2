package com.tarea2.PracticaAPIREST.services;
import com.tarea2.PracticaAPIREST.dto.SubjectDTO;
import java.util.List;

public interface ISubjectService {
    String save(SubjectDTO subject);
    List<SubjectDTO> getAll();
    String update(SubjectDTO subjectDTO, Integer id);
    String delete(Integer id);
}
