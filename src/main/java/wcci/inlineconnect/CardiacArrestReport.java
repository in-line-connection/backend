package wcci.inlineconnect;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class CardiacArrestReport extends Report {
	
	@Id
	@GeneratedValue
	private Long id;
	private String date;
	private String medicNum;
	private String chiefComplaint;
		
		
		private String cardiacFuction;
		
		@Lob // may need to be BLOB for voice to text
		private String narrative;

		
		


		public CardiacArrestReport(String medicNum, String chiefComplaint, String narrative,String date, String cardiacFuction) {
			
			this.narrative = narrative;
			this.cardiacFuction = cardiacFuction;
		}
		
		public CardiacArrestReport() {
			
		}

	
		public String getCardiacFuction() {
			return cardiacFuction;
		
		
		}

		public Long getId() {
			return id;
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

		public String getNarrative() {
			return narrative;
		}

		

	
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CardiacArrestReport other = (CardiacArrestReport) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}
}

