package wcci.inlineconnect.models;

import javax.persistence.Entity;

@Entity

public class OtherComplaintReport extends TraumaReport {

	private boolean penetratingTrauma;
	private boolean bluntForceTrauma;
	private String incident;
	
	

	public OtherComplaintReport(boolean penetratingTrauma, boolean bluntForceTrauma, String incident, String medicNum, String date, String timeOfIncident, String narrative, String sex, String age,  String bloodPressure,
			String heartRate, String spO2, String respiratoryRate, String gcs, String bloodSugar) {
		super(medicNum, date, timeOfIncident, narrative, sex, age, bloodPressure,
				heartRate, spO2, respiratoryRate, gcs, bloodSugar);
		this.penetratingTrauma = penetratingTrauma;
		this.bluntForceTrauma = bluntForceTrauma;
		this.incident = incident;
	}

	public OtherComplaintReport() {
		super();
	}

	public boolean isPenetratingTrauma() {
		return penetratingTrauma;
	}

	public boolean isBluntForceTrauma() {
		return bluntForceTrauma;
	}

	public String getIncident() {
		return incident;
	}
	
	
	
	
}
