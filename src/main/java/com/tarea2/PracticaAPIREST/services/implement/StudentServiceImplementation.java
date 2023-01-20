package com.tarea2.PracticaAPIREST.services.implement;
import com.tarea2.PracticaAPIREST.dto.StudentDTO;
import com.tarea2.PracticaAPIREST.repository.IStudentRepository;
import com.tarea2.PracticaAPIREST.repository.entity.Student;
import com.tarea2.PracticaAPIREST.services.IStudentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplementation implements IStudentService {

    private final IStudentRepository studentrepository;

    public StudentServiceImplementation(IStudentRepository studentrepository) {
        this.studentrepository = studentrepository;
    }
    @Override
    public void save(StudentDTO studentDTO) {
        studentrepository.save(new Student(studentDTO));
    }

    @Override
    public List<StudentDTO> getAll() {
        List<Student> list =(List<Student>) studentrepository.findAll();
        return list.stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void update(StudentDTO studentDTO) {
        Optional<Student> value = studentrepository.findById(studentDTO.getId());
        if(value.isPresent()){
            studentrepository.save(new Student(studentDTO));
        }
    }

    @Override
    public void delete(StudentDTO studentDTO) {
        Optional<Student> value = studentrepository.findById(studentDTO.getId());
        if(value.isPresent()){
            studentrepository.delete(new Student(studentDTO));
        }
    }
    }

