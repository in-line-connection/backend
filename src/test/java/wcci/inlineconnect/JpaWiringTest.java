package wcci.inlineconnect;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaWiringTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ReportRepository reportRepo;
	
	private Report report;
	
	@Before
	public void setup() {
		report = new Report("1", true, "report field", "blood pressure", "heart rate", "SPO2", "respiratory rate", "GCS", "blood sugar");
//				Report(String medicNum, boolean hasChiefComplaint, String report, String bloodPressure, String heartRate,
//						String spO2, String respiratoryRate, String gCS, String bloodSugar) {
		reportRepo.save(report);
		entityManager.flush();
		entityManager.clear();
	}
	
	@Test
	public void shouldStartJPAFramework() {
		
	}
	
	@Test
	public void shouldSaveAndLoadReport() {
		Report testReport = reportRepo.findById(report.getId()).get();
		assertThat(testReport, is(report));
	}

}
