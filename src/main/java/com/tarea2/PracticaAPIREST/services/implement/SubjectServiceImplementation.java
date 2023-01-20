package com.tarea2.PracticaAPIREST.services.implement;

import com.tarea2.PracticaAPIREST.dto.SubjectDTO;
import com.tarea2.PracticaAPIREST.repository.ISubjectRepository;
import com.tarea2.PracticaAPIREST.repository.entity.Subject;
import com.tarea2.PracticaAPIREST.services.ISubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImplementation implements ISubjectService {

    private final ISubjectRepository subjectRepository;

    public SubjectServiceImplementation(ISubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    @Override
    public String save(SubjectDTO subjectDTO) {
        subjectRepository.save(new Subject(subjectDTO));
        return String.format("Se ha creado la materia %s a la base de datos", subjectDTO.getSubjectName());
    }

    @Override
    public List<SubjectDTO> getAll() {
        List<Subject> list =(List<Subject>) subjectRepository.findAll();
        return list.stream()
                .map(SubjectDTO::new)
                .collect(Collectors.toList());
    }
    @Override
    public String update(SubjectDTO subjectDTO, Integer id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        if(subject.isPresent()){
            subject.get().setSubjectName(subjectDTO.getSubjectName());
            subject.get().setSchedule(subjectDTO.getSchedule());
            subject.get().setStudents(subjectDTO.getStudents());
            subject.get().setTopic(subjectDTO.getTopic());
            subject.get().setTeacher(subjectDTO.getTeacher());
            subjectRepository.save(subject.get());
            return String.format("El curso con nombre %s asociado al ID %d fue actualizada correctamente", subject.get().getSubjectName(), id);
        }else{
            return String.format("No hay ninguna materia asociada al ID %d", id);
        }
    }

    @Override
    public String delete(Integer id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        if (subject.isPresent()) {
            String nameSubject = subject.get().getSubjectName();
            subjectRepository.deleteById(id);
            return "Se eliminó la materia " + nameSubject + " correctamente asociado al ID  " + id + "";
        } else {
            return "No se tiene ninguna materia asociada al ID " + id + "";
        }
    }
}
