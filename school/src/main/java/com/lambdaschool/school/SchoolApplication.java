package com.lambdaschool.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
//we shouldn't not use
//enableWebMvc
//WITH spring boot
//UNLESS you are handling
//your own error handling for
// invalid endpoints
@EnableJpaAuditing
@SpringBootApplication
public class SchoolApplication
{

    public static void main(String[] args)
    {
        //added ApplicationContext ctx = ORIGINALLY APART OF APP
        ApplicationContext ctx = SpringApplication.run(SchoolApplication.class, args);
//(dispatcherServlet) must be spelled exactly how it
//is shown Spring will not
// give an error so WATCH for that
        //make sure to typecast(DispatcherServlet
        DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx.getBean("dispatcherServlet");
        //since we are doing our own exceptions
        //we must set this to true because it
        //defaults to false
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    }

}
