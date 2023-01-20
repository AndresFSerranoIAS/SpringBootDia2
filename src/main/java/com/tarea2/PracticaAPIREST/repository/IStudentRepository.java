package com.tarea2.PracticaAPIREST.repository;

import com.tarea2.PracticaAPIREST.repository.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepository extends CrudRepository<Student, Integer> {
}
