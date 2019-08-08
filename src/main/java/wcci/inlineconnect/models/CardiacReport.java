package wcci.inlineconnect.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CardiacReport extends Report {

	@OneToOne
	protected MVC chiefComplaint;

	private String rhythm;

	public CardiacReport(String medicNum, String date, String sex, String age, String narrative,
			String rhythm) {
		super(medicNum, date, narrative, sex, age);
		this.rhythm = rhythm;
	}

	public CardiacReport() {
	}

	public String getRhythm() {
		return rhythm;
	}

	public Object getChiefComplaint() {
		// TODO Auto-generated method stub
		return null;
	}

}
