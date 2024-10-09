package com.cda.college_direc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.college_direc.model.AdministratorProfile;
import com.cda.college_direc.repo.AdministratorProfileRepository;

@Service
public class AdminService {

    @Autowired
    private AdministratorProfileRepository adminProfileRepository;

    public AdministratorProfile getAdminProfileByUserId(int userId) {
        return adminProfileRepository.findByUserId(userId);
    }
}