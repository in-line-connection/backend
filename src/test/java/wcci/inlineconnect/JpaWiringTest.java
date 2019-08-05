package wcci.inlineconnect;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import wcci.inlineconnect.models.CardiacReport;
import wcci.inlineconnect.models.MedicalReport;
import wcci.inlineconnect.models.TraumaReport;
import wcci.inlineconnect.repositories.CardiacReportRepository;
import wcci.inlineconnect.repositories.MedicalReportRepository;
import wcci.inlineconnect.repositories.TraumaReportRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaWiringTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CardiacReportRepository cardiacRepo;

	@Autowired
	private MedicalReportRepository medicalRepo;

	@Autowired
	private TraumaReportRepository traumaRepo;

	private CardiacReport cardiacReport;
	private MedicalReport medicalReport;
	private TraumaReport traumaReport;

	@Before
	public void setup() {
		cardiacReport = new CardiacReport("medicNum", "chief Complaint", "date","sex","age", "narrative", "rhythm");
		medicalReport = new MedicalReport("51", "CVA", "12-01-1990","sex","age", "lmlmlmlmlmlml", "120/60", "60", "98%", "16", 
				"80", "Sinus Rhythm", "april");
		traumaReport = new TraumaReport("1", "MVC", "Report", "07-07-17","sex","age", "bp", "HR", "spO2", "respRate", "motor skill",
				"sugar");
		cardiacRepo.save(cardiacReport);
		medicalRepo.save(medicalReport);
		traumaRepo.save(traumaReport);
		entityManager.flush();
		entityManager.clear();
	}

	@Test
	public void shouldStartJPAFramework() {

	}

	@Test
	public void shouldSaveAndLoadCardiacReport() {
		CardiacReport testReport = cardiacRepo.findById(cardiacReport.getId()).get();
		assertThat(testReport.getChiefComplaint(), is(cardiacReport.getChiefComplaint()));
	}

	@Test
	public void shouldGenerateIdForCardiacReport() {
		long id = cardiacReport.getId();
		assertThat(id, is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadMedicalReport() {
		MedicalReport testReport = medicalRepo.findById(medicalReport.getId()).get();
		assertThat(testReport.getChiefComplaint(), is(medicalReport.getChiefComplaint()));
	}

	@Test
	public void shouldGenerateIdForMedicalReport() {
		long id = medicalReport.getId();
		assertThat(id, is(greaterThan(0L)));
	}

	@Test
	public void shouldSaveAndLoadTraumaReport() {
		TraumaReport testReport = traumaRepo.findById(traumaReport.getId()).get();
		assertThat(testReport.getChiefComplaint(), is(traumaReport.getChiefComplaint()));
	}

	@Test
	public void shouldGenerateIdForTraumaReport() {
		long id = traumaReport.getId();
		String item = traumaReport.getGCS();
		System.out.println(item + "Hello");
		assertThat(id, is(greaterThan(0L)));
	}

}
