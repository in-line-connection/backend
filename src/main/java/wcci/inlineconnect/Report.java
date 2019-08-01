package wcci.inlineconnect;


import javax.persistence.Lob;


public abstract class Report {

	

	private String medicNum;
	private String chiefComplaint;
	
	@Lob // may need to be BLOB for voice to text
	private String narrative;
	private String date;

	
	
	


	public Report(String medicNum, String chiefComplaint, String narrative,String date) {
		this.medicNum = medicNum;
		this.chiefComplaint = chiefComplaint;
		this.narrative = narrative;
		this.date = date;
		
	}
	
	public Report() {
		
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

	

	

	
	

}
