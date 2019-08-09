package wcci.inlineconnect.models;

import javax.persistence.Entity;

@Entity
public class MotorVehicleCrashReport extends TraumaReport {

	private String seatPosition;
	private String speed;
	private boolean ambulatory;
	private boolean prolongedExtrication;
	private boolean immobilized;

	public MotorVehicleCrashReport(String medicNum, String date, String timeOfIncident, String narrative, String sex,
			String age, String bloodPressure, String heartRate, String spO2, String respiratoryRate, String gcs,
			String bloodSugar, String seatPosition, String speed, boolean ambulatory, boolean prolongedExtrication,
			boolean immobilized) {
		super(medicNum, narrative, sex, age, date, timeOfIncident, bloodPressure, heartRate, spO2, respiratoryRate, gcs,
				bloodSugar);
		this.seatPosition = seatPosition;
		this.speed = speed;
		this.ambulatory = ambulatory;
		this.prolongedExtrication = prolongedExtrication;
		this.immobilized = immobilized;

	}

	public MotorVehicleCrashReport() {
		super();

	}

	public String getSeatPosition() {
		return seatPosition;
	}

	public String getSpeed() {
		return speed;
	}

	public boolean isAmbulatory() {
		return ambulatory;
	}

	public boolean isProlongedExtrication() {
		return prolongedExtrication;
	}

	public boolean isImmobilized() {
		return immobilized;
	}

}
