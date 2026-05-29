package com.myapp.school.controller;

import com.myapp.school.dto.FullSchoolResponse;
import com.myapp.school.model.School;
import com.myapp.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/schools")
public class SchoolController {

    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addSchool(@RequestBody School school){
        service.addSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchool(){
        return ResponseEntity.ok(service.findAllSchools());
    }

    @GetMapping("/with-students/{schoolId}")
    public ResponseEntity<FullSchoolResponse> findSchoolAndAllStudentsById(@PathVariable Long schoolId){
        return ResponseEntity.ok(service.findSchoolAndAllStudentsById(schoolId));
    }


}
