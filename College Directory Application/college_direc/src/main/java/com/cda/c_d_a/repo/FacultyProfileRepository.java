package com.cda.college_direc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cda.college_direc.model.FacultyProfile;

@Repository
public interface FacultyProfileRepository extends JpaRepository<FacultyProfile, Integer> {

    @Query("SELECT fp FROM FacultyProfile fp JOIN fp.user u WHERE u.username = :username")
    FacultyProfile findByUsername(@Param("username") String username);
}