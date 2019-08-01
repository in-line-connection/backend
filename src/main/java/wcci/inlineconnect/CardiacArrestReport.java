package wcci.inlineconnect;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Lob;


@Entity

public class CardiacArrestReport extends Report {
	

		
		
		private String cardiacFuction;
		
		@Lob // may need to be BLOB for voice to text
		private String report;

		
		

		public CardiacArrestReport( String report, String cardiacFuction) {
			
			this.report = report;
			this.cardiacFuction = cardiacFuction;
		}
		
		public CardiacArrestReport() {
			
		}

		

		public String getReport() {
			return report;
		}
		public String getCardiacFuction() {
			return cardiacFuction;
		
		
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
			Report other = (Report) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

	}


