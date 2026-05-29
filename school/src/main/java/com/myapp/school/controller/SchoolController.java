package com.myapp.school.controller;

import com.myapp.school.model.School;
import com.myapp.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("school")
public class SchoolController {

    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addSchool(School school){
        service.addSchool(school);
    }

    @GetMapping
    public List<School> findAllSchool(){
        return service.findAllSchools();
    }


}
