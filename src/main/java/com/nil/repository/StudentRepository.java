package com.nil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nil.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findByFirstNameContainingIgnoreCase(String firstName);

	Optional<Student> findByUniqueStudentCode(int uniqueStudentCode);

	@Query("SELECT s FROM Student s JOIN s.course c WHERE c.courseName = :courseName")
	List<Student> findByCourseName(@Param("courseName")String courseName);

}
