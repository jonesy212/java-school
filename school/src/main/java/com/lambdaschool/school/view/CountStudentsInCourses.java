package com.lambdaschool.school.view;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


public interface CountStudentsInCourses
{
    long getCourseid();

    String getCoursename();

    int getCountstudents();


}
