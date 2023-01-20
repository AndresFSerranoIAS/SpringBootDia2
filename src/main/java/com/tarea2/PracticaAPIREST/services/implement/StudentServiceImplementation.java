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
    public String save(StudentDTO studentDTO) {
        studentrepository.save(new Student(studentDTO));
        return String.format("Se ha creado correctamente el estudiante %s %s a la base de datos", studentDTO.getFirstName(),studentDTO.getLastName());
    }

    @Override
    public List<StudentDTO> getAll() {
        List<Student> list =(List<Student>) studentrepository.findAll();
        return list.stream()
                .map(StudentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public String update(StudentDTO studentDTO,Integer id) {
        Optional<Student> student = studentrepository.findById(id);
        if(student.isPresent()){
            student.get().setStudentBirthDate(studentDTO.getBirthDate());
            student.get().setStudentAge(studentDTO.getAge());
            student.get().setStudentIdDocument(studentDTO.getIdDocument());
            student.get().setStudentFirstName(studentDTO.getFirstName());
            student.get().setStudentLastName(studentDTO.getLastName());
            student.get().setSubject(studentDTO.getSubject());
            studentrepository.save(student.get());
            return String.format("El estudiante con nombre %s asociado al ID %d fue actualizado correctamente", student.get().getStudentFirstName(), id);
        }else{
            return String.format("No hay ningún estudiante asociado al ID %d", id);
        }
    }

    @Override
    public String delete(Integer id) {
        Optional<Student> student = studentrepository.findById(id);
        if(student.isPresent()){
            String fullName = String.format("%s %s",student.get().getStudentFirstName(),student.get().getStudentLastName());
            studentrepository.delete(student.get());
            return String.format("El estudiante %s asociado al ID %d fue eliminado correctamente", fullName, id);
        }else{
            return String.format("No existe ningún estudiante asociado al ID %d",id);
        }

    }
    }

