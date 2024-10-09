package com.cda.college_direc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cda.college_direc.model.AdministratorProfile;
import com.cda.college_direc.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdministratorController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin-profile")
    public ResponseEntity<AdminProfileResponse> getAdminProfile(@RequestParam int UserId) {
        AdministratorProfile adminProfile = adminService.getAdminProfileByUserId(UserId);
        if (adminProfile != null) {
            return ResponseEntity.ok(new AdminProfileResponse(adminProfile));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

class AdminProfileResponse {
    private int userId;
    private String photo;
    private String departmentName;

    public AdminProfileResponse(AdministratorProfile adminProfile) {
        this.userId = adminProfile.getUserId();
        this.photo = adminProfile.getPhoto();
        this.departmentName = adminProfile.getDepartment().getName();
    }

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}