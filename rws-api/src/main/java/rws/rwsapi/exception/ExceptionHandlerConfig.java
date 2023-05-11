package rws.rwsapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import rws.rwsapi.api.LocationController;

import java.time.LocalDateTime;

@RestControllerAdvice(assignableTypes = LocationController.class)
public class ExceptionHandlerConfig {

    @ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<DefaultError> handleLocationNotFoundError(LocationNotFoundException e, ServletWebRequest request) {
        return handleError(e, null, HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<DefaultError> handleBadRequestException(BadRequestException e, ServletWebRequest request) {
        return handleError(e, null, HttpStatus.BAD_REQUEST, request);
    }

    private ResponseEntity<DefaultError> handleError(Exception exception,
                                                     HttpHeaders httpHeaders,
                                                     HttpStatus httpStatus,
                                                     ServletWebRequest request) {
        return new ResponseEntity<>(new DefaultError(
                LocalDateTime.now().toString(),
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                exception.getMessage(),
                request.getContextPath()
        ), httpHeaders, httpStatus);
    }
}
