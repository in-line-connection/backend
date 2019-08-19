package wcci.inlineconnect.models;

import javax.persistence.Entity;

@Entity
public class GunShotWoundReport extends TraumaReport {
	private String location;
	private String numberOfShots;
	private boolean exitWoundLocated;
	private String typeOfWeapon;
	private boolean lossOfConsciousness;
	
	
	
	public GunShotWoundReport() {
		super();
		
	}
	public GunShotWoundReport(String medicNum, String date, String timeOfIncident, String narrative, String sex,
			String age, String bloodPressure, String heartRate, String spO2, String respiratoryRate, String gcs,
			String bloodSugar, String location, String numberOfShots, boolean exitWoundLocated, String typeOfWeapon, boolean lossOfConsciousness) {
		super(medicNum, date, timeOfIncident, narrative, sex, age, bloodPressure, heartRate, spO2, respiratoryRate, gcs,
				bloodSugar);
		this.location = location;
		this.numberOfShots = numberOfShots;
		this.exitWoundLocated = exitWoundLocated;
		this.typeOfWeapon = typeOfWeapon;
		this.lossOfConsciousness = lossOfConsciousness;
	}
	public String getLocation() {
		return location;
	}
	public String getNumberOfShots() {
		return numberOfShots;
	}
	public boolean isExitWoundLocated() {
		return exitWoundLocated;
	}
	public String getTypeOfWeapon() {
		return typeOfWeapon;
	}
	public boolean isConsciousness() {
		return lossOfConsciousness;
	}
	

}
