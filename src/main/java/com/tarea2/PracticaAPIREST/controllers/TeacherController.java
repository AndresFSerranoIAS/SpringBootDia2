package com.tarea2.PracticaAPIREST.controllers;

import com.tarea2.PracticaAPIREST.dto.StudentDTO;

import com.tarea2.PracticaAPIREST.dto.TeacherDTO;
import com.tarea2.PracticaAPIREST.repository.entity.Subject;
import com.tarea2.PracticaAPIREST.repository.entity.Teacher;
import com.tarea2.PracticaAPIREST.services.ITeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final ITeacherService iTeacherService;

    public TeacherController(ITeacherService iStudentService) {
        this.iTeacherService = iStudentService;
    }

    @GetMapping()
    public ResponseEntity<?> getPersonAll(){
        return new ResponseEntity<>(iTeacherService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> addTeacher(@RequestBody TeacherDTO teacherDTO){
        return new ResponseEntity<>(iTeacherService.save(teacherDTO),HttpStatus.CREATED);
    }
    @PutMapping("/modify/{id}")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody TeacherDTO teacherDTO, @PathVariable Integer id){
        return new ResponseEntity(iTeacherService.update(teacherDTO,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable Integer id){
        return new ResponseEntity(iTeacherService.delete(id),HttpStatus.OK);
    }
    @PostMapping("/modify/subjects/{id}")
    public ResponseEntity<Teacher> setSubjects( @PathVariable Integer id){
        return null;
    }

}
