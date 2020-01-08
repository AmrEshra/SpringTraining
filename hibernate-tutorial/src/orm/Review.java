package orm;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="REVIEW")
public class Review {

	@Id
	@SequenceGenerator(name = "REVIEW_SEQ", sequenceName = "REVIEW_SEQ", allocationSize = 1)  
	@GeneratedValue(generator = "REVIEW_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;
	
	@Column(name="COMMENTS")
	private String comments;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="COURSE_ID")
	private Course course;

	public Review(String comments, Course course) {
		this.comments = comments;
		this.course = course;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comments=" + comments + ", course=" + course.getTitle() + "]";
	}
	
}
