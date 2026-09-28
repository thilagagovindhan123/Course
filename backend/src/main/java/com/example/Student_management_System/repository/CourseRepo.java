package com.example.Student_management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Student_management_System.model.Course;

@Repository
public interface CourseRepo extends JpaRepository <Course,String> {

}
