package orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Amr")
public class WorkingDay {

	@Id
	@Column(name="ID")
	private long id;
	
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
	
}
