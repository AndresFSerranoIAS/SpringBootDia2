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
    @PostMapping("/create")
    public ResponseEntity<?> addPerson(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(iStudentService.save(studentDTO),HttpStatus.OK);
    }
    @PutMapping("/modify/{id}")
    public ResponseEntity<?> changePerson(@RequestBody StudentDTO studentDTO, @PathVariable Integer id){
        return new ResponseEntity<>(iStudentService.update(studentDTO, id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> erasePerson(@PathVariable Integer id){
        return new ResponseEntity<>(iStudentService.delete(id),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> addPerson(@PathVariable Integer id){
        if(iStudentService.getOneStudent(id)==null){
            return new ResponseEntity<>("No se obtuvo ningún usuario con el id "+ id ,HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(iStudentService.getOneStudent(id),HttpStatus.OK);
        }

    }
}
