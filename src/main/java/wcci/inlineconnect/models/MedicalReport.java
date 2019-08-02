package wcci.inlineconnect.models;

import javax.persistence.Entity;

@Entity
public class MedicalReport extends Report {

	

		private String medicNum;
		private String chiefComplaint;
		
		@Lob // may need to be BLOB for voice to text
		private String narrative;

		private String bloodPressure;
		private String heartRate;
		private String spO2;
		private String respiratoryRate;
		private String GCS;
		private String bloodSugar;
		private String cardiacFuction;
		

		public MedicalReport(String medicNum, String chiefComplaint, String narrative, String bloodPressure, String heartRate,
				String spO2, String respiratoryRate, String GCS, String bloodSugar, String cardiacFuction) {
			this.medicNum = medicNum;
			this.chiefComplaint = chiefComplaint;
			this.narrative = narrative;
			this.bloodPressure = bloodPressure;
			this.heartRate = heartRate;
			this.spO2 = spO2;
			this.respiratoryRate = respiratoryRate;
			this.GCS = GCS;
			this.bloodSugar = bloodSugar;
			this.cardiacFuction = cardiacFuction;
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
