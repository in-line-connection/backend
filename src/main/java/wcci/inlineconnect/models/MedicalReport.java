package wcci.inlineconnect.models;

import javax.persistence.Entity;

@Entity
public class MedicalReport extends Report {

	private String bloodPressure;
	private String heartRate;
	private String spO2;
	private String respiratoryRate;
	private String GCS;
	private String bloodSugar;
	private String rhythm;

	public MedicalReport(String medicNum, String chiefComplaint, String narrative, String bloodPressure,
			String heartRate, String spO2, String respiratoryRate, String GCS, String bloodSugar, String rhythm, String date) {
		super(medicNum, chiefComplaint, date,narrative);
		this.bloodPressure = bloodPressure;
		this.heartRate = heartRate;
		this.spO2 = spO2;
		this.respiratoryRate = respiratoryRate;
		this.GCS = GCS;
		this.bloodSugar = bloodSugar;
		this.rhythm = rhythm;
	}

	public MedicalReport() {

	}

	

	public String getBloodPressure() {
		return bloodPressure;
	}

	public String getHeartRate() {
		return heartRate;
	}

	public String getSpO2() {
		return spO2;
	}

	public String getRespiratoryRate() {
		return respiratoryRate;
	}

	public String getGCS() {
		return GCS;
	}

	public String getBloodSugar() {
		return bloodSugar;
	}

	public String getRhythm() {
		return rhythm;
	}

}
