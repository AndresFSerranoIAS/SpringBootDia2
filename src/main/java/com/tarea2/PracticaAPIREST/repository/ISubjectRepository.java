package com.tarea2.PracticaAPIREST.repository;

import com.tarea2.PracticaAPIREST.repository.entity.Subject;
import org.springframework.data.repository.CrudRepository;

public interface ISubjectRepository extends CrudRepository<Subject,Integer> {
}
