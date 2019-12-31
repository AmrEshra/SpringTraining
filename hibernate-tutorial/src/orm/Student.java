package orm;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="STUDENT")
public class Student {

	@Id
	@SequenceGenerator(name = "STUDENT_SEQ", sequenceName = "STUDENT_SEQ", allocationSize = 1)  
	@GeneratedValue(generator = "STUDENT_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="STUDENT_DETAIL_ID")
	private StudentDetails studentDetails;
	
	public Student(String name, String email) {
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", studentDetails=" + studentDetails.getFacebook() + "]";
	}

	
}
