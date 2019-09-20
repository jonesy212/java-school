//BOILERPLATE FOR RESOURCE NOT FOUND
package com.lambdaschool.school.exceptions;

//we are creating ResourceNotFound in place of EntityNotFound
//to take control and do it ourselves for more control of errors

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
//specifically used when there is a response status of
{
    //create two constructors
    public ResourceNotFoundException(String message)
        {
            //calls the constructor of the parent class
            super(message);
        }
        //also to send the cause
    public ResourceNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
