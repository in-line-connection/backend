//package wcci.inlineconnect;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.contains;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.when;
//
//import java.util.Collections;
//import java.util.Optional;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import wcci.inlineconnect.controllers.TraumaReportController;
//import wcci.inlineconnect.models.TraumaReport;
//import wcci.inlineconnect.repositories.TraumaReportRepository;
//
//public class TraumaControllerTest {
//
//
//	@Mock
//	private TraumaReport testReport;
//	@Mock
//	private TraumaReport testReport2;
//	
//	@Before
//	public void setup() {
//		MockitoAnnotations.initMocks(this);
//	}
//	@Test
//	public void shouldReturnReportsList() {
//		when(traumaRepo.findAll()).thenReturn(Collections.singletonList(testReport));
//		assertThat(underTest.findAllReports(), contains(testReport));
//	}
//	@Test
//	public void shouldReturnSingleReport() {
//		Long id = testReport2.getId();
//		Long id2 = testReport2.getId();
//		String item = testReport.getGCS();
//		System.out.println(id);
//		System.out.println(item);
//		when(traumaRepo.findById(0L)).thenReturn(Optional.of(testReport2));
//		assertThat(underTest.findSingleReports(id), is(testReport2));
//	}
//	
//	
//}
//
//	