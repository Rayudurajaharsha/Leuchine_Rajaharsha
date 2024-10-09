package com.cda.college_direc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cda.college_direc.model.StudentProfile;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer> {

    @Query("SELECT sp FROM StudentProfile sp JOIN sp.user u WHERE u.username = :username")
    StudentProfile findByUsername(@Param("username") String username);
}