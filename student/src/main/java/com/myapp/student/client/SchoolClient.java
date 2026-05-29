package com.myapp.student.client;

import com.myapp.student.model.School;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "school-service", url = "${application.config.school-url}")
public interface SchoolClient {

    @GetMapping("/school/{studentId}")
    public School getSchoolByStudent(@PathVariable Long studentId);

}
