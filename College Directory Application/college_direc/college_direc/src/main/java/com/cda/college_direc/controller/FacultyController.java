package com.cda.college_direc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cda.college_direc.model.FacultyProfile;
import com.cda.college_direc.service.FacultyService;

@RestController
@RequestMapping("/api")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/faculty-profile")
    public ResponseEntity<FacultyProfileResponse> getFacultyProfile(@RequestParam String username) {
        FacultyProfile facultyProfile = facultyService.getFacultyProfileByUsername(username);
        if (facultyProfile != null) {
            return ResponseEntity.ok(new FacultyProfileResponse(facultyProfile));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

class FacultyProfileResponse {
    private int userId;
    private String photo;
    private String departmentName;
    private String officeHours;

    public FacultyProfileResponse(FacultyProfile facultyProfile) {
        this.userId = facultyProfile.getUserId();
        this.photo = facultyProfile.getPhoto();
        this.departmentName = facultyProfile.getDepartment().getName();
        this.officeHours = facultyProfile.getOfficeHours();
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

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
}