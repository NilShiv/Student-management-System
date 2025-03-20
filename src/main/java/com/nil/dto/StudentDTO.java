package com.nil.dto;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.nil.entity.Gender;

public class StudentDTO {

	private long sId;
	private int uniqueStudentCode;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private Gender gender;
	private String email;
	private String mobileNumber;
	private List<AddressDTO> address;
	private Set<CourseDTO> course;
	public long getsId() {
		return sId;
	}
	public void setsId(long sId) {
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
	public List<AddressDTO> getAddress() {
		return address;
	}
	public void setAddress(List<AddressDTO> address) {
		this.address = address;
	}
	
	public Set<CourseDTO> getCourse() {
		return course;
	}
	public void setCourse(Set<CourseDTO> course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "StudentDTO [sId=" + sId + ", uniqueStudentCode=" + uniqueStudentCode + ", firstName=" + firstName
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
		StudentDTO other = (StudentDTO) obj;
		return Objects.equals(address, other.address) && Objects.equals(course, other.course)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && gender == other.gender
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(mobileNumber, other.mobileNumber) && sId == other.sId
				&& uniqueStudentCode == other.uniqueStudentCode;
	}
	
}
