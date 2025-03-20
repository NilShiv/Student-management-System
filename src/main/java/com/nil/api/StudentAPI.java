package com.nil.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nil.dto.CourseDTO;
import com.nil.dto.StudentDTO;
import com.nil.exception.StudentMSException;
import com.nil.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentAPI {

	@Autowired
	private StudentService studentService;
	
//	@Autowired
//	private Environment environment;
	
	@PostMapping(value = "/admit")
	public ResponseEntity<String> admitStudent(@RequestBody StudentDTO studentDTO) throws StudentMSException{
		String message = studentService.admitStudent(studentDTO);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/addcourse")
	public ResponseEntity<String> uploadCourseDetails(@RequestBody CourseDTO courseDTO) throws StudentMSException{
		String message = studentService.uploadCourseDetails(courseDTO);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/{sId}/{cId}")
	public ResponseEntity<String> assignCourseToStudent(@PathVariable Long sId,@PathVariable Long cId) throws StudentMSException{
		String message = studentService.assignCourseToStudent(sId, cId);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping(value = "/find/{firstName}")
	public ResponseEntity<List<StudentDTO>> getStudentByName(@PathVariable String firstName) throws StudentMSException{
		List<StudentDTO> studentDTOs = studentService.getStudentByName(firstName);
		return new ResponseEntity<List<StudentDTO>>(studentDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/find/{courseName}")
	public ResponseEntity<List<StudentDTO>> getStudentByCourse(@PathVariable String courseName) throws StudentMSException{
		List<StudentDTO> studentDTOs = studentService.getStudentByName(courseName);
		return new ResponseEntity<List<StudentDTO>>(studentDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/findcourse/{cId}")
	public ResponseEntity<CourseDTO> getAllCourses(@PathVariable Long cId) throws StudentMSException{
		CourseDTO courseDTOs = studentService.getAllCourses(cId);
		return new ResponseEntity<CourseDTO>(courseDTOs, HttpStatus.OK);
	}
}
