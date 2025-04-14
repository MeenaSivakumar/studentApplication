package com.practice.studentApplication.services;

import com.practice.studentApplication.dto.StudentDTO;
import com.practice.studentApplication.entities.StudentEntity;
import com.practice.studentApplication.repository.StudentApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class StudentApplicationService {
    private static final Logger log = LoggerFactory.getLogger(StudentApplicationService.class);
    private final StudentApplicationRepository studentApplicationRepository;


    public void saveStudent(StudentDTO studentDTO) {
        StudentEntity entity = StudentEntity.builder().name(studentDTO.getName()).regNo(studentDTO.getRegNo()).email(studentDTO.getEmail()).build();
        System.out.println(entity);
        studentApplicationRepository.save(entity);

    }

    public StudentDTO getStudentById(String studentId) {
        return studentApplicationRepository.findById(studentId).map(entity -> StudentDTO.builder().name(entity.getName()).email(entity.getEmail()).regNo(entity.getRegNo()).build()).orElse(null);
    }

    public StudentDTO getStudentByRegNo(String regNo){
        return studentApplicationRepository.findByRegNo(regNo).map(entity -> StudentDTO.builder().name(entity.getName()).regNo(entity.getRegNo()).email(entity.getEmail()).build()).orElse(null);
    }

    public StudentDTO editStudent(String regNo,StudentDTO studentDTO){
       Optional<StudentEntity> studentEntity = studentApplicationRepository.findByRegNo(regNo);
       if(studentEntity.isPresent()) {
           StudentEntity student = studentEntity.get();
           student.setName(studentDTO.getName());
           student.setEmail(studentDTO.getEmail());
           student.setRegNo(studentDTO.getRegNo());

           StudentEntity updatedEntity = studentApplicationRepository.save(student);
           return StudentDTO.builder().name(updatedEntity.getName()).regNo(updatedEntity.getRegNo()).email(updatedEntity.getEmail()).build();
       }
       return null;
    }

    public String deleteStudent(String studentId){
        if(studentApplicationRepository.existsById(studentId)){
            studentApplicationRepository.deleteById(studentId);
            log.info("deleted:{}",studentId);
            return "deleted";
        }
       return null;
    }

    public String deleteStudentByRegNo(String regNo){
        if(studentApplicationRepository.existsByRegNo(regNo)){
            studentApplicationRepository.deleteByRegNo(regNo);
            log.info("deleted regNo:{}",regNo);
            return "deleted";
        }
        return null;
    }
}
