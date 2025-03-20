package com.nil.service;

import java.util.List;

import com.nil.dto.CourseDTO;
import com.nil.dto.StudentDTO;
import com.nil.exception.StudentMSException;

public interface StudentService {

	public String admitStudent(StudentDTO studentDTO) throws StudentMSException;
	
	public String uploadCourseDetails(CourseDTO courseDTO) throws StudentMSException;
	
	public String assignCourseToStudent(Long sId, Long cId) throws StudentMSException;
	
	public List<StudentDTO> getStudentByName(String firstName) throws StudentMSException;
	
	public List<StudentDTO> getStudentByCourse(String courseName) throws StudentMSException;

	public CourseDTO getAllCourses(Long cId) throws StudentMSException;
}
	