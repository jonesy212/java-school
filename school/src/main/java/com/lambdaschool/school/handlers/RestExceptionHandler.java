package com.lambdaschool.school.handlers;

import com.lambdaschool.school.exceptions.ResourceNotFoundException;
import com.lambdaschool.school.model.ErrorDetail;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.net.URISyntaxException;
import java.util.Date;

@ControllerAdvice
//controller advice says
// when something happens in the controller
// looks to see how something
//is supposed to be handled
public class RestExceptionHandler extends ResponseEntityExceptionHandler
//been shared by controller
{

    @ExceptionHandler({ResourceNotFoundException.class, URISyntaxException.class})
        //must go in curly braces
        //because it may be a list of things
    //if certain exceptions happen
    //run this method
    public ResponseEntity<?>handleResourceNotFoundException(ResourceNotFoundException rnfe, HttpServletRequest request)
    {
        //create a standard error message/detail
        //to return
        ErrorDetail errorDetail = new ErrorDetail();

        errorDetail.setTimestamp(new Date().getTime());
        //send java day, but must convert to a long
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        //want not just that status, but the value
        errorDetail.setTitle("Resource Not Found");
        errorDetail.setDetail(rnfe.getMessage());
        errorDetail.setDeveloperMessage(rnfe.getClass().getName());
        return new ResponseEntity<>(errorDetail, null,HttpStatus.NOT_FOUND);
    }

    //throws
    //Exception
    //ResourceNotFoundException

//generate- override methods list all
// of the different ways you can create/handle
// messages for exceptions or errors
//a user/developer may come across
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
            //error if a person types in the wrong thing
            //create a standard error message/detail
            //to return
            ErrorDetail errorDetail = new ErrorDetail();
            errorDetail.setTimestamp(new Date().getTime());
            //send java day, but must convert to a long
            errorDetail.setStatus(HttpStatus.BAD_REQUEST.value());
            errorDetail.setTitle(ex.getPropertyName());
            //want not just that status, but the value
            errorDetail.setDetail(ex.getMessage());
            errorDetail.setDeveloperMessage(request.getDescription(true));

            return new ResponseEntity<>(errorDetail, null,HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        //REQUEST METHOD NOT SUPPORTED
        //EXECUTING ENDPOINT
        //IF WE WENT TO A POST INSTEAD OF A GET

        //error if a person types in the wrong thing
        //create a standard error message/detail
        //to return
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimestamp(new Date().getTime());
        //send java day, but must convert to a long
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        //want not just that status, but the value
        errorDetail.setTitle(ex.getMethod());
        errorDetail.setDetail(request.getDescription(true));
        errorDetail.setDeveloperMessage("HTTP Method Not Valid for Endpoint (check for valid URI and proper HTTP Method)");

        return new ResponseEntity<>(errorDetail, null,HttpStatus.NOT_FOUND);

    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        //create a standard error message/detail
        //to return
        //springboot handles this exception
        //SPECIAL WORKAROUND
        //through a dispatcher
        //so we need to make sure to take care of that
        //in
        ErrorDetail errorDetail = new ErrorDetail();
        errorDetail.setTimestamp(new Date().getTime());
        //send java day, but must convert to a long
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        //want not just that status, but the value
        errorDetail.setTitle(ex.getRequestURL());
        errorDetail.setDetail(request.getDescription(true));
        errorDetail.setDeveloperMessage("Rest Handler Not Found(check for valid URI");

        return new ResponseEntity<>(errorDetail, null,HttpStatus.NOT_FOUND);
    }
}
