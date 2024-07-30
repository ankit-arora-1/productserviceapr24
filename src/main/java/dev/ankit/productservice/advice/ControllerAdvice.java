package dev.ankit.productservice.advice;

import dev.ankit.productservice.dtos.ErrorDto;
import dev.ankit.productservice.exceptions.InvalidTokenException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


// This is global. This will be called when any exception
// is thrown by any controller
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNullPointerException() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Something went wrong. Please try again");

        return new ResponseEntity<>(errorDto,
                HttpStatusCode.valueOf(404));

        // reflections in java
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ErrorDto> handleInvalidTokenException() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Invalid token");

        return new ResponseEntity<>(errorDto,
                HttpStatusCode.valueOf(401));
    }
}
