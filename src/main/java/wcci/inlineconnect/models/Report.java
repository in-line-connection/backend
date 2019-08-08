package wcci.inlineconnect.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class Report {
	@Id
	@GeneratedValue
	protected Long id;

	protected String medicNum;
	protected String date;
	@Lob // may need to be BLOB for voice to text
	protected String narrative;
	protected String sex;
	protected String age;
//	protected MVC chiefComplaint;
	
	public Report(String medicNum,  String date, String narrative, String sex, String age) {
		this.medicNum = medicNum;
//		this.chiefComplaint = chiefComplaint;
		this.date = date;
		this.narrative = narrative;
		this.sex = sex;
		this.age = age;

	}

	public Report() {

	}

	public String getSex() {
		return sex;
	}

	public String getAge() {
		return age;
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
