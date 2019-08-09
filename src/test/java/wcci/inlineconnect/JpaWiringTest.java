
//package wcci.inlineconnect;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.greaterThan;
//import static org.hamcrest.Matchers.is;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import wcci.inlineconnect.models.TraumaReport;
//import wcci.inlineconnect.repositories.TraumaReportRepository;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class JpaWiringTest {
//
//	@Autowired
//	private TestEntityManager entityManager;
//
//	@Autowired
//	private TraumaReportRepository traumaRepo;
//
//	private TraumaReport traumaReport;
//
//	@Before
//	public void setup() {
//		traumaReport = new TraumaReport("1", "MVC", "Report", "07-07-17", "sex", "age", "bp", "HR", "spO2", "respRate",
//				"motor skill");
//		traumaRepo.save(traumaReport);
//		entityManager.flush();
//		entityManager.clear();
//	}
//
//	@Test
//	public void shouldStartJPAFramework() {
//
//	}
//
//	@Test
//	public void shouldSaveAndLoadTraumaReport() {
//		TraumaReport testReport = traumaRepo.findById(traumaReport.getId()).get();
//		assertThat(testReport.getChiefComplaint(), is(traumaReport.getChiefComplaint()));
//	}
//
//	@Test
//	public void shouldGenerateIdForTraumaReport() {
//		long id = traumaReport.getId();
//		String item = traumaReport.getGCS();
//		System.out.println(item + "Hello");
//		assertThat(id, is(greaterThan(0L)));
//	}
//
//}
