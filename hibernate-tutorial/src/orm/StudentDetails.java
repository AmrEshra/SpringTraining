package orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="STUDENT_DETAILS")
public class StudentDetails {

	@Id
	@SequenceGenerator(name = "STUDENT_DETAILS_SEQ", sequenceName = "STUDENT_DETAILS_SEQ", allocationSize = 1)  
	@GeneratedValue(generator = "STUDENT_DETAILS_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;
	
	@Column(name="YOUTUBE")
	private String youTube;
	
	@Column(name="FACEBOOK")
	private String facebook;
	
//	@OneToOne(mappedBy="studentDetails")
//	private Student student;
	
	public StudentDetails(String youTube, String facebook) {
		this.youTube = youTube;
		this.facebook = facebook;
	}

	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", youTube=" + youTube + ", facebook=" + facebook  + "]";
	}
	
}
