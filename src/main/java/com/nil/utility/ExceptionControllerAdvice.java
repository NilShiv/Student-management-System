package com.nil.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nil.exception.StudentMSException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);
	
	@Autowired
	private Environment environment;
	
	@ExceptionHandler(StudentMSException.class)
	public ResponseEntity<ErrorInfo> meetingSchedularExceptionHandler(StudentMSException exception){
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setMessage(environment.getProperty(exception.getMessage()));
		errorInfo.setTimeStamp(LocalDateTime.now().toString());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception exception){
		LOGGER.error(exception.getMessage(), exception);
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setMessage(environment.getProperty("General.Exception_Message"));
		errorInfo.setTimeStamp(LocalDateTime.now().toString());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
	public ResponseEntity<ErrorInfo> validatorExceptionHandler(Exception ex){
LOGGER.error(ex.getMessage(), ex);
		
		String errorMsg = null;
		
		if(ex instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException manve = (MethodArgumentNotValidException) ex;
			errorMsg = manve.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(", "));
		}
		ErrorInfo error = new ErrorInfo();
		error.setCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(errorMsg);
		error.setTimeStamp(LocalDateTime.now().toString());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.BAD_REQUEST);
		
	}
}
