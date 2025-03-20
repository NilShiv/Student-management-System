package com.nil.dto;

import java.util.List;
import java.util.Objects;

public class CourseDTO {

	private long cId;
	private String courseName;
	private String description;
	private String courseType;
	private int duration;
	private List<String> topics;
	public long getcId() {
		return cId;
	}
	public void setcId(long cId) {
		this.cId = cId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public List<String> getTopics() {
		return topics;
	}
	public void setTopics(List<String> topics) {
		this.topics = topics;
	}
	@Override
	public String toString() {
		return "CourseDTO [cId=" + cId + ", courseName=" + courseName + ", description=" + description + ", courseType="
				+ courseType + ", duration=" + duration + ", topics=" + topics + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cId, courseName, courseType, description, duration, topics);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseDTO other = (CourseDTO) obj;
		return cId == other.cId && Objects.equals(courseName, other.courseName)
				&& Objects.equals(courseType, other.courseType) && Objects.equals(description, other.description)
				&& duration == other.duration && Objects.equals(topics, other.topics);
	}
	
}
