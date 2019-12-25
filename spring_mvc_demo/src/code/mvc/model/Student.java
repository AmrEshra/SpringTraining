package code.mvc.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import code.mvc.validation.CourseCode;

public class Student {

	private String firstName;
	
	@NotNull
	@Size(min=1 , message="is Required")
	private String lastName;
	
	@NotNull(message="is Required")
	@Max(value=50, message="must be less than 50")
	@Min(value=18, message="must be grater than 18")
	private Integer age;
	
	private String country;
	private String gender;
	private List<String> skills;
	
	@CourseCode
	private String course;
	
	public Student() {
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}	
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
}
