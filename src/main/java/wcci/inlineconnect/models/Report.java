package wcci.inlineconnect.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Report {
	@Id
	@GeneratedValue
	protected Long id;

	protected String medicNum;
	protected String date;
	protected String timeOfIncident;
	@Lob // may need to be BLOB for voice to text
	protected String narrative;
	protected String sex;
	protected String age;

	public Report(String medicNum, String date, String timeOfIncident, String narrative, String sex, String age) {
		this.medicNum = medicNum;
		this.date = date;
		this.timeOfIncident = timeOfIncident;
		this.narrative = narrative;
		this.sex = sex;
		this.age = age;

	}

	public String getTimeOfIncident() {
		return timeOfIncident;
	}

	public String getSex() {
		return sex;
	}

	public String getAge() {
		return age;
	}

	public Report() {

	}

	public Long getId() {
		return id;
	}

	public String getMedicNum() {
		return medicNum;
	}


	public String getDate() {
		return date;
	}

	public String getNarrative() {
		return narrative;
	}

}
