package wcci.inlineconnect;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import wcci.inlineconnect.models.MotorVehicleCrashReport;
import wcci.inlineconnect.repositories.MotorVehicleCrashReportRepository;


public class MotorVehicleCrashReportControllerTest {

	@Mock
	private MotorVehicleCrashReportRepository testRepo;
	@Mock
	private MotorVehicleCrashReport testReport;
	@Mock
	private MotorVehicleCrashReport testReport2;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void shouldReturnReportsList() {
		when(testRepo.findAll()).thenReturn(Collections.singletonList(testReport));
		assertThat(testRepo.findAll(), contains(testReport));
	}
	@Test
	public void shouldReturnSingleReport() {
		Long id = testReport2.getId();
		Long id2 = testReport2.getId();
		String item = testReport.getGCS();
		System.out.println(id);
		System.out.println(item);
		when(testRepo.findById(0L)).thenReturn(Optional.of(testReport2));
		assertThat(testRepo.findById(id2), is(Optional.of(testReport2)));
	}
	
	
}

	