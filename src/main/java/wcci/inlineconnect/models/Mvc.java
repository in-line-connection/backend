package wcci.inlineconnect.models;

public class Mvc {
	
	private String seatPosition;
    private String speed;
    private boolean ambulatory;
    private boolean prolongedExtrication;
    private boolean immobilized;
    
    public Mvc(String seatPosition, String speed, boolean ambulatory, boolean prolongedExtrication, boolean immobilized) {
    	this.seatPosition = seatPosition;
    	this.speed = speed;
    	this.ambulatory = ambulatory;
    	this.prolongedExtrication = prolongedExtrication;
    	this.immobilized = immobilized;
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
