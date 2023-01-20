package com.tarea2.PracticaAPIREST.repository;

import com.tarea2.PracticaAPIREST.repository.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface ITeacherRepository extends CrudRepository<Teacher,Integer> {
}
