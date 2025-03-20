package com.nil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nil.entity.Course;

@Repository
public interface AddressRepository extends JpaRepository<Course, Long> {

}
