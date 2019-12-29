package orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="Amr")
public class WorkingDay {

	@Id
	@SequenceGenerator(name = "PRL_ATTACHMENTS_SEQ", sequenceName = "PRL_ATTACHMENTS_SEQ", allocationSize = 1)  
	@GeneratedValue(generator = "PRL_ATTACHMENTS_SEQ", strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DATE_")
	private String date;
	
	@Column(name="TIME")
	private String time;

	public WorkingDay(String name, String date, String time) {
		this.name = name;
		this.date = date;
		this.time = time;
	}

	@Override
	public String toString() {
		return "WorkingDay [id=" + id + ", name=" + name + ", date=" + date + ", time=" + time + "]";
	}
	
}
