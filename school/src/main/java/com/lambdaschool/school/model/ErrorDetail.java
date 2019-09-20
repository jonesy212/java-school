package com.lambdaschool.school.model;

import com.lambdaschool.school.exceptions.ValidationError;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorDetail
{
    //title of the error messages
    private String title;
    //http error status ex 404-500
    private int status;
    //detailed description of the error
    private String detail;
    //helps to create a date and time format
    private String timestamp;
    //to help developer understand what
    //might be going on
    private String developerMessage;
    //create a HashMap with a string and a list a ways
    //that variable was invalid
    private Map<String, List<ValidationError>> errors = new HashMap<>();


    //create getters and setters
    //work on the time stamp
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    //grab date and time from the system
    //then send it to this detail
    //then print it out in a certain format
    //take the long value and convert
    // it to the string we want

    public void setTimestamp(Long timestamp)
    {
        //create a new simple date format
        this.timestamp = new SimpleDateFormat("dd MMM yyy HH:mm:ss:SSS Z").format(new Date(timestamp));
        //first convert to a java date (new Date...)
        //format it dd MMM yyy HH:mm:ss:SSS Z- date month year
        //hour seconds: milliseconds
    }

    public String getDeveloperMessage()
    {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage)
    {
        this.developerMessage = developerMessage;
    }

    public Map<String, List<ValidationError>> getErrors()
    {
        return errors;
    }

    public void setErrors(Map<String, List<ValidationError>> errors)
    {
        this.errors = errors;
    }
}
