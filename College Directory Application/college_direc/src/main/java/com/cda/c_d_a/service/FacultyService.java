package com.cda.college_direc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.college_direc.model.FacultyProfile;
import com.cda.college_direc.repo.FacultyProfileRepository;

@Service
public class FacultyService {

    @Autowired
    private FacultyProfileRepository facultyProfileRepository;

    public FacultyProfile getFacultyProfileByUsername(String username) {
        return facultyProfileRepository.findByUsername(username);
    }
}