package com.tarea2.PracticaAPIREST.controllers;
import com.tarea2.PracticaAPIREST.dto.SubjectDTO;
import com.tarea2.PracticaAPIREST.services.ISubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final ISubjectService iSubjectService;
    public SubjectController(ISubjectService iSubjectService) {
        this.iSubjectService = iSubjectService;
    }
    @GetMapping()
    public ResponseEntity<?> getPersonAll(){
        return new ResponseEntity<>(iSubjectService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> addPerson(@RequestBody SubjectDTO subjectDTO){
        return new ResponseEntity<>(iSubjectService.save(subjectDTO),HttpStatus.OK);
    }
    @PutMapping("/modify/{id}")
    public ResponseEntity<?> changePerson(@RequestBody SubjectDTO subjectDTO, @PathVariable Integer id){
        return new ResponseEntity<>(iSubjectService.update(subjectDTO, id),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> erasePerson(@PathVariable Integer id){
        return new ResponseEntity<>(iSubjectService.delete(id),HttpStatus.OK);
    }
    @PostMapping("/createSubject")
    public ResponseEntity<?> addSubject(@RequestBody SubjectDTO subjectDTO){
        return new ResponseEntity<>(iSubjectService.saveSubject(subjectDTO),HttpStatus.OK);
    }
}
