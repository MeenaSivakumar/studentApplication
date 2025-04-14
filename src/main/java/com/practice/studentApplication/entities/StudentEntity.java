package com.practice.studentApplication.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document(value = "Student")
public class StudentEntity {
    @Id
    private String id;
   private String name;
   private String regNo;
   private String email;
}
