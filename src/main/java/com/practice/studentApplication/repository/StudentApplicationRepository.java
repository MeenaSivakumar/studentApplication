package com.practice.studentApplication.repository;

import com.practice.studentApplication.entities.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentApplicationRepository extends MongoRepository<StudentEntity,String> {
    Optional<StudentEntity> findByRegNo(String regNo);
    boolean  existsByRegNo(String regNo);
    void deleteByRegNo(String regNo);
}
