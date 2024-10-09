package com.cda.college_direc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cda.college_direc.model.AdministratorProfile;

@Repository
public interface AdministratorProfileRepository extends JpaRepository<AdministratorProfile, Integer> {
    AdministratorProfile findByUserId(int userId);
}