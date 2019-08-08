package wcci.inlineconnect.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class MVC {
	@Id
	@GeneratedValue
	protected Long id;

	
	@OneToOne 
	private TraumaReport traumaReport;
	
	@OneToOne
	private CardiacReport cardiacReport;
	
	@OneToOne
	private MedicalReport medicalReport;
	
	private String seatPosition;
	private String speed;
	private boolean ambulatory;
	private boolean prolongedExtrication;
	private boolean immobilized;

	public MVC(String seatPosition, String speed, boolean ambulatory, boolean prolongedExtrication,
			boolean immobilized) {
		this.seatPosition = seatPosition;
		this.speed = speed;
		this.ambulatory = ambulatory;
		this.prolongedExtrication = prolongedExtrication;
		this.immobilized = immobilized;

	}
	
	public MVC() {
		
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
