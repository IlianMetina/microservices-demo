package com.myapp.school.service;

import com.myapp.school.client.StudentClient;
import com.myapp.school.dto.FullSchoolResponse;
import com.myapp.school.model.School;
import com.myapp.school.model.Student;
import com.myapp.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;
    private final StudentClient studentClient;

    public SchoolService(SchoolRepository repository, StudentClient client, StudentClient studentClient){
        this.repository = repository;
        this.client = client;
        this.studentClient = studentClient;
    }

    public void addSchool(School school){
        repository.save(school);
    }

    public List<School> findAllSchools(){
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolAndAllStudentsById(Long id){
        FullSchoolResponse dto = new FullSchoolResponse();
        dto.setSchoolName(dto.getSchoolName());
        School school = repository.findById(id).orElse(School.builder().schoolName("NOT_FOUND").email("NOT_FOUND").build());
        List<Student> students = studentClient.findAllStudentsBySchoolId(id);

        dto.setSchoolName(school.getSchoolName());
        dto.setSchoolEmail(school.getEmail());
        dto.setStudents(students);
        return dto;
    }
}
