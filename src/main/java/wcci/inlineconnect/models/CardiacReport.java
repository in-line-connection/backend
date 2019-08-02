package wcci.inlineconnect.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CardiacReport extends Report {
	

	private String rhythm;

	public CardiacReport(String medicNum, String chiefComplaint, String date, String narrative, String rhythm) {
		super(medicNum, chiefComplaint, narrative, date);
		this.rhythm = rhythm;
	}

	public CardiacReport() {
	}

	public String getRhythm() {
		return rhythm;
	}

}
