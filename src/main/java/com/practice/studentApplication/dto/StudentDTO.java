package com.practice.studentApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StudentDTO {
   private String name;
   private String regNo;
   private String email;
}
