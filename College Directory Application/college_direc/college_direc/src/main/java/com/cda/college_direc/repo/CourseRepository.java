package com.cda.college_direc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cda.college_direc.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByTitle(String title);
}