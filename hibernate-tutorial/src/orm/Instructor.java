package orm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="INSTRUCTOR")
public class Instructor {

	@Id
	@SequenceGenerator(name = "INSTRUCTOR_SEQ", sequenceName = "INSTRUCTOR_SEQ", allocationSize = 1)  
	@GeneratedValue(generator = "INSTRUCTOR_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(mappedBy = "instructor" , 
				cascade= {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},
				fetch=FetchType.LAZY
			)
	private List<Course> courses;
	
	public Instructor(String name, String email) {
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public void addCourse(Course c) {
		if(courses == null)
			courses = new ArrayList<Course>();
		
		c.setInstructor(this);
		courses.add(c);
	}
}
