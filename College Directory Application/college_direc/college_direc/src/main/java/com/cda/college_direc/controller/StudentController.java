package com.cda.college_direc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cda.college_direc.model.StudentProfile;
import com.cda.college_direc.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student-profile")
    public ResponseEntity<StudentProfileResponse> getStudentProfile(@RequestParam String username) {
        StudentProfile studentProfile = studentService.getStudentProfileByUsername(username);
        if (studentProfile != null) {
            return ResponseEntity.ok(new StudentProfileResponse(studentProfile));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

class StudentProfileResponse {
    private int userId;
    private String photo;
    private String departmentName;
    private String year;

    public StudentProfileResponse(StudentProfile studentProfile) {
        this.userId = studentProfile.getUserId();
        this.photo = studentProfile.getPhoto();
        this.departmentName = studentProfile.getDepartment().getName();
        this.year = studentProfile.getYear();
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}