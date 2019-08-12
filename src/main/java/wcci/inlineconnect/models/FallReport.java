package wcci.inlineconnect.models;

import javax.persistence.Entity;

@Entity
public class FallReport extends TraumaReport {
	
	private boolean withInjury;
	private boolean lossOfConsciousness;
	private String height;
	private boolean ambulatory;
	private boolean immobilized;
	
	public FallReport(boolean withInjury, boolean lossOfConciousness, String height, boolean ambulatory, boolean immobilized, String medicNum, String date, String timeOfIncident, String narrative, String sex, String age,  String bloodPressure,
			String heartRate, String spO2, String respiratoryRate, String gcs, String bloodSugar) {

		super(medicNum, date, timeOfIncident, narrative, sex, age, bloodPressure,
				heartRate, spO2, respiratoryRate, gcs, bloodSugar);
		this.withInjury = withInjury;
		this.lossOfConsciousness = lossOfConciousness;
		this.height= height;
		this.ambulatory = ambulatory;
		this.immobilized = immobilized;
		
	}

	private FallReport() {
		
	}
	
	public Boolean getWithInjury() {
		return withInjury;
	}

	public Boolean getLossOfConsciousness() {
		return lossOfConsciousness;
	}

	public String getHeight() {
		return height;
	}

	public Boolean getAmbulatory() {
		return ambulatory;
	}

	public Boolean getImmobilized() {
		return immobilized;
	}

	
	
	

}
