package com.myapp.student.service;

import com.myapp.student.model.Student;
import com.myapp.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public List<Student> findAllStudentsBySchoolId(Long schoolId){
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
