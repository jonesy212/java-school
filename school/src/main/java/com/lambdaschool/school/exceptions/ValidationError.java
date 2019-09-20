//BOILER PLATE CODE
//FOR EXCEPTION HANDLING


package com.lambdaschool.school.exceptions;
//connects back to model/errorDetail
public class ValidationError
{
    private String code;
    private String message;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
