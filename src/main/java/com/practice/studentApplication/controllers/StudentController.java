package com.practice.studentApplication.controllers;

import com.practice.studentApplication.dto.StudentDTO;
import com.practice.studentApplication.services.StudentApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentApplicationService studentApplicationService;

    @GetMapping("/students/{studentId}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable String studentId ){
     StudentDTO studentDTO = studentApplicationService.getStudentById(studentId);
     if(studentDTO == null){
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
     return new ResponseEntity<>(studentDTO,HttpStatus.OK);
    }
    @GetMapping("/students/regNo/{regNo}")
    public ResponseEntity<StudentDTO> getStudentByRegNo(@PathVariable String regNo){
        StudentDTO studentDTO = studentApplicationService.getStudentByRegNo(regNo);
        if(studentDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentDTO,HttpStatus.OK);
    }

    @PostMapping("/add")
    public void saveStudent(@RequestBody StudentDTO studentDTO) {
        studentApplicationService.saveStudent(studentDTO);
    }

    @PutMapping("students/regNo/{regNo}/edit")
    public ResponseEntity<StudentDTO> editStudent(@PathVariable String regNo, @RequestBody StudentDTO studentDTO){
        StudentDTO student = studentApplicationService.editStudent(regNo,studentDTO);
        if(student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentDTO,HttpStatus.OK);
    }

    @DeleteMapping("students/{studentId}/delete")
    public String deleteStudent(@PathVariable String studentId){
     return studentApplicationService.deleteStudent(studentId);

    }
    @DeleteMapping("students/regNo/{regNo}/delete")
    public String deleteStudentByRegNo(@PathVariable String regNo){
        return studentApplicationService.deleteStudentByRegNo(regNo);

    }
}
