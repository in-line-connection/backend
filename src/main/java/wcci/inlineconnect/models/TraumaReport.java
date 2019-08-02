package wcci.inlineconnect.models;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class TraumaReport extends Report {

//	@Id
//	@GeneratedValue
//	private Long id;

	private String medicNum;
	private String chiefComplaint;

	@Lob // may need to be BLOB for voice to text
	private String narrative;
	private String date;
	private String bloodPressure;
	private String heartRate;
	private String spO2;
	private String respiratoryRate;
	private String GCS;
	private String bloodSugar;

	public TraumaReport(String medicNum, String chiefComplaint, String narrative, String date, String bloodPressure,
			String heartRate, String spO2, String respiratoryRate, String GCS, String bloodSugar) {
		super(medicNum, chiefComplaint, narrative, date);
		// TODO Auto-generated constructor stub
		this.bloodPressure = bloodPressure;
		this.heartRate = heartRate;
		this.spO2 = spO2;
		this.respiratoryRate = respiratoryRate;
		this.GCS = GCS;
		this.bloodSugar = bloodSugar;

	}

	public TraumaReport() {
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

	public String getNarrative() {
		return narrative;
	}

	public String getDate() {
		return date;
	}

	public String getMedicNum() {
		return medicNum;
	}

	public String getChiefComplaint() {
		return chiefComplaint;
	}
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + ((id == null) ? 0 : id.hashCode());
//			return result;
//		}
//		@Override
//		public boolean equals(Object obj) {
//			if (this == obj)
//				return true;
//			if (obj == null)
//				return false;
//			if (getClass() != obj.getClass())
//				return false;
//			TraumaReport other = (TraumaReport) obj;
//			if (id == null) {
//				if (other.id != null)
//					return false;
//			} else if (!id.equals(other.id))
//				return false;
//			return true;
//		}

}
