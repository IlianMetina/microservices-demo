package com.myapp.school.dto;

import com.myapp.school.model.Student;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {

    private String schoolName;
    private String schoolEmail;
    List<Student> students;

}
