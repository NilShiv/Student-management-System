package com.nil.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nil.dto.AddressDTO;
import com.nil.dto.CourseDTO;
import com.nil.dto.StudentDTO;
import com.nil.entity.Address;
import com.nil.entity.Course;
import com.nil.entity.Student;
import com.nil.exception.StudentMSException;
import com.nil.repository.CourseRepository;
import com.nil.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	  
	
	@Override
	public String admitStudent(StudentDTO studentDTO) throws StudentMSException {
		if(studentRepository.findByUniqueStudentCode(studentDTO.getUniqueStudentCode()).isPresent()) {
			throw new StudentMSException("Student Unique Code Already Present");
		}
		Student student = new Student();
		student.setsId(studentDTO.getsId());
		student.setUniqueStudentCode(studentDTO.getUniqueStudentCode());
		student.setFirstName(studentDTO.getFirstName());
		student.setMiddleName(studentDTO.getMiddleName());
		student.setLastName(studentDTO.getLastName());
		student.setDateOfBirth(studentDTO.getDateOfBirth());
		student.setGender(studentDTO.getGender());
		student.setEmail(studentDTO.getEmail());
		student.setMobileNumber(studentDTO.getMobileNumber());
		List<Address> addresses = new ArrayList<Address>();
		for(AddressDTO addressDTO : studentDTO.getAddress()) {
			Address address = new Address();
			address.setAid(addressDTO.getAid());
			address.setArea(addressDTO.getArea());
			address.setDistrict(addressDTO.getDistrict());
			address.setPincode(addressDTO.getPincode());
			address.setState(addressDTO.getState());
			addresses.add(address);
		}
		studentRepository.save(student);
		return "Student Admitted Successfully";		
	}

	@Override
	public String uploadCourseDetails(CourseDTO courseDTO) throws StudentMSException {
		if(courseRepository.findById(courseDTO.getcId()).isPresent()) {
			throw new StudentMSException("Course ID Already Exist");
		}
		Course course = new Course();
		course.setcId(courseDTO.getcId());
		course.setCourseName(courseDTO.getCourseName());
		course.setCourseType(courseDTO.getCourseType());
		course.setDescription(courseDTO.getDescription());
		course.setDuration(courseDTO.getDuration());
		course.setTopics(courseDTO.getTopics());
		courseRepository.save(course);
		return "Course Details Saved Successfully";
	}

	@Override
	public String assignCourseToStudent(Long sId, Long cId) throws StudentMSException {
		Student student = studentRepository.findById(sId).orElseThrow(() -> new StudentMSException("Student Not Found"));
		Course course = courseRepository.findById(cId).orElseThrow(() -> new StudentMSException("Course Not Found"));
		student.getCourse().add(course);
		studentRepository.save(student);
		return "Course Assigned to Student";
	}

	@Override
	public List<StudentDTO> getStudentByName(String firstName) throws StudentMSException{	
		List<Student> list = studentRepository.findByFirstNameContainingIgnoreCase(firstName);
		List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();
		for(Student student : list) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setsId(student.getsId());
			studentDTO.setUniqueStudentCode(student.getUniqueStudentCode());
			studentDTO.setFirstName(student.getFirstName());
			studentDTO.setMiddleName(student.getMiddleName());
			studentDTO.setLastName(student.getLastName());
			studentDTO.setDateOfBirth(student.getDateOfBirth());
			studentDTO.setGender(student.getGender());
			studentDTO.setEmail(student.getEmail());
			studentDTO.setMobileNumber(student.getMobileNumber());
			List<AddressDTO> addressDTOs = new ArrayList<AddressDTO>();
			for(Address address : student.getAddress()) {
				AddressDTO addressDTO = new AddressDTO();
				addressDTO.setAid(address.getAid());
				addressDTO.setArea(address.getArea());
				addressDTO.setDistrict(address.getDistrict());
				addressDTO.setPincode(address.getPincode());
				addressDTO.setState(address.getState());
				addressDTOs.add(addressDTO);
			}
			studentDTO.setAddress(addressDTOs);
			Set<CourseDTO> courseDTOs = new HashSet<CourseDTO>();
			for(Course course : student.getCourse()) {
				CourseDTO courseDTO = new CourseDTO();
				courseDTO.setcId(course.getcId());
				courseDTO.setCourseName(course.getCourseName());
				courseDTO.setCourseType(course.getCourseType());
				courseDTO.setDescription(course.getDescription());
				courseDTO.setDuration(course.getDuration());
				courseDTO.setTopics(course.getTopics());
				courseDTOs.add(courseDTO);
			}
			studentDTO.setCourse(courseDTOs);
		}
		return studentDTOs;
	}

	@Override
	public List<StudentDTO> getStudentByCourse(String courseName) throws StudentMSException{
		List<Student> list = studentRepository.findByCourseName(courseName);
		List<StudentDTO> studentDTOs = new ArrayList<StudentDTO>();
		for(Student student : list) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setsId(student.getsId());
			studentDTO.setUniqueStudentCode(student.getUniqueStudentCode());
			studentDTO.setFirstName(student.getFirstName());
			studentDTO.setMiddleName(student.getMiddleName());
			studentDTO.setLastName(student.getLastName());
			studentDTO.setDateOfBirth(student.getDateOfBirth());
			studentDTO.setGender(student.getGender());
			studentDTO.setEmail(student.getEmail());
			studentDTO.setMobileNumber(student.getMobileNumber());
			List<AddressDTO> addressDTOs = new ArrayList<AddressDTO>();
			for(Address address : student.getAddress()) {
				AddressDTO addressDTO = new AddressDTO();
				addressDTO.setAid(address.getAid());
				addressDTO.setArea(address.getArea());
				addressDTO.setDistrict(address.getDistrict());
				addressDTO.setPincode(address.getPincode());
				addressDTO.setState(address.getState());
				addressDTOs.add(addressDTO);
			}
			studentDTO.setAddress(addressDTOs);
			Set<CourseDTO> courseDTOs = new HashSet<CourseDTO>();
			for(Course course : student.getCourse()) {
				CourseDTO courseDTO = new CourseDTO();
				courseDTO.setcId(course.getcId());
				courseDTO.setCourseName(course.getCourseName());
				courseDTO.setCourseType(course.getCourseType());
				courseDTO.setDescription(course.getDescription());
				courseDTO.setDuration(course.getDuration());
				courseDTO.setTopics(course.getTopics());
				courseDTOs.add(courseDTO);
			}
			studentDTO.setCourse(courseDTOs);
		}
		return studentDTOs;
	}

	@Override
	public CourseDTO getAllCourses(Long cId) throws StudentMSException {
		Optional<Course> c = courseRepository.findById(cId);
		Course course = c.orElseThrow(() -> new StudentMSException("Course Id Not Present"));
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setcId(course.getcId());
		courseDTO.setCourseName(course.getCourseName());
		courseDTO.setCourseType(course.getCourseType());
		courseDTO.setDescription(course.getDescription());
		courseDTO.setDuration(course.getDuration());
		courseDTO.setTopics(course.getTopics());
		return courseDTO;
	}

}
 