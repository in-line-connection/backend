package wcci.inlineconnect.models;

public class MotorVehicleCrashReport extends TraumaReport {

	private String seatPosition;
	private String speed;
	private boolean ambulatory;
	private boolean prolongedExtrication;
	private boolean immobilized;

	public MotorVehicleCrashReport(String medicNum, String seatPosition, String speed, boolean ambulatory,
			boolean prolongedExtrication, boolean immobilized, String narrative, String sex, String age, String date,
			String timeOfIncident, String bloodPressure, String heartRate, String spO2, String respiratoryRate,
			String gcs, String bloodSugar) {
		super(medicNum, narrative, sex, age, date, timeOfIncident, bloodPressure, heartRate, spO2, respiratoryRate, gcs,
				bloodSugar);

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
