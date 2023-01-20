package com.tarea2.PracticaAPIREST.services.implement;

import com.tarea2.PracticaAPIREST.dto.SubjectDTO;
import com.tarea2.PracticaAPIREST.dto.TeacherDTO;
import com.tarea2.PracticaAPIREST.repository.ISubjectRepository;
import com.tarea2.PracticaAPIREST.repository.ITeacherRepository;
import com.tarea2.PracticaAPIREST.repository.entity.Teacher;
import com.tarea2.PracticaAPIREST.services.ITeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImplementation implements ITeacherService {

    private final ITeacherRepository teacherRepository;
    private final ISubjectRepository subjectRepository;

    public TeacherServiceImplementation(ITeacherRepository teacherRepository, ISubjectRepository subjectRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }


    @Override
    public String save(TeacherDTO teacherDTO) {
        teacherRepository.save(new Teacher(teacherDTO));
        return "Se guardó el profesor con éxito en la base de datos";
    }

    @Override
    public List<TeacherDTO> getAll() {
        List<Teacher> list = (List<Teacher>) teacherRepository.findAll();
        return list.stream()
                .map(TeacherDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public String update(TeacherDTO teacherDTO, Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            teacher.get().setTeacherAge(teacherDTO.getAge());
            teacher.get().setTeacherIdDocument(teacherDTO.getIdDocument());
            teacher.get().setTeacherFirstName(teacherDTO.getFirstName());
            teacher.get().setTeacherLastName(teacherDTO.getLastName());
            teacherRepository.save(teacher.get());
            return String.format("El profesor %s asociado al ID %d fue actualizado correctamente", teacherDTO.getFirstName(), id);
        } else {
            return String.format("El profesor asociado al ID %d no fue encontrado a la base de datos", id);
        }
    }

    @Override
    public String delete(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            String nameTeacher = teacher.get().getTeacherFirstName();
            teacherRepository.deleteById(id);
            return "Se eliminó el profesor " + nameTeacher + " correctamente asociado al ID  " + id + "";
        } else {
            return "No se tiene ningún profesor asociado al ID " + id + "";
        }
    }

    @Override
    public String setSubject(SubjectDTO subjectDTO, Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {

        }
        return null;
    }

}
