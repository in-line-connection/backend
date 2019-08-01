package wcci.inlineconnect;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

public abstract class Report {

	@Id
	@GeneratedValue
	private Long id;
	private String medicNum;
	private String chiefComplaint;
	private String date;
	@Lob // may need to be BLOB for voice to text
	private String narrative;

	public Report(String medicNum, String chiefComplaint, String date, String narrative) {
		this.medicNum = medicNum;
		this.chiefComplaint = chiefComplaint;
		this.narrative = narrative;
		this.date = date;

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
