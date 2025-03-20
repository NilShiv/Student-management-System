package com.nil.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sId;
	@Column(unique = true, nullable = false)
	private int uniqueStudentCode;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String email;
	private String mobileNumber;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_aId")
	private List<Address> address;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "student_course", // New join table
	        joinColumns = @JoinColumn(name = "student_id"),
	        inverseJoinColumns = @JoinColumn(name = "course_id")
	    )
	private Set<Course> course;
	
	public Long getsId() {
		return sId;
	}
	public void setsId(Long sId) {
		this.sId = sId;
	}
	public int getUniqueStudentCode() {
		return uniqueStudentCode;
	}
	public void setUniqueStudentCode(int uniqueStudentCode) {
		this.uniqueStudentCode = uniqueStudentCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public Set<Course> getCourse() {
		return course;
	}
	public void setCourse(Set<Course> course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", uniqueStudentCode=" + uniqueStudentCode + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", gender="
				+ gender + ", email=" + email + ", mobileNumber=" + mobileNumber + ", address=" + address + ", course="
				+ course + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, course, dateOfBirth, email, firstName, gender, lastName, middleName, mobileNumber,
				sId, uniqueStudentCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && Objects.equals(course, other.course)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && gender == other.gender
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(mobileNumber, other.mobileNumber) && sId == other.sId
				&& uniqueStudentCode == other.uniqueStudentCode;
	}
	
	
	 
	
}
