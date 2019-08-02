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
	protected String chiefComplaint;
	protected String date;
	@Lob // may need to be BLOB for voice to text
	protected String narrative;

	public Report(String medicNum, String chiefComplaint, String date, String narrative) {
		this.medicNum = medicNum;
		this.chiefComplaint = chiefComplaint;
		this.date = date;
		this.narrative = narrative;

	}

	public Report() {

	}

	public Long getId() {
		return id;
	}

	public String getMedicNum() {
		return medicNum;
	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public String getDate() {
		return date;
	}

	public String getNarrative() {
		return narrative;
	}
	

}
