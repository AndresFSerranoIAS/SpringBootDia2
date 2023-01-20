package com.tarea2.PracticaAPIREST.controllers;

import com.tarea2.PracticaAPIREST.dto.StudentDTO;
import com.tarea2.PracticaAPIREST.services.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final IStudentService iStudentService;

    public StudentController(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }

    @GetMapping()
    public ResponseEntity<?> getPersonAll(){
        return new ResponseEntity<>(iStudentService.getAll(), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> addPerson(@RequestBody StudentDTO studentDTO){
        iStudentService.save(studentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<?> changePerson(@RequestBody StudentDTO studentDTO){
        iStudentService.update(studentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<?> erasePerson(@RequestBody StudentDTO studentDTO){
        iStudentService.delete(studentDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
