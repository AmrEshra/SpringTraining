package orm;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="COURSE")
public class Course {

	@Id
	@SequenceGenerator(name = "COURSE_SEQ", sequenceName = "COURSE_SEQ", allocationSize = 1)  
	@GeneratedValue(generator = "COURSE_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;
	
	@Column(name="TITLE")
	private String title;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="INSTRUCTOR_ID")
	private Instructor instructor;
	
	@OneToMany(mappedBy = "course", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Review> reviews;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name ="STUDENT_COURSES",
				joinColumns = @JoinColumn(name="COURSE_ID"),
				inverseJoinColumns=@JoinColumn(name="STUDENT_ID"))
	private List<Student> students; 
	
	public Course(String title, Instructor instructor) {
		this.title = title;
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
}
