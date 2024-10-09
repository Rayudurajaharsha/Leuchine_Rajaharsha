package com.cda.college_direc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.college_direc.model.StudentProfile;
import com.cda.college_direc.repo.StudentProfileRepository;

@Service
public class StudentService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    public StudentProfile getStudentProfileByUsername(String username) {
        return studentProfileRepository.findByUsername(username);
    }
}