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

import wcci.inlineconnect.models.FallReport;
import wcci.inlineconnect.repositories.FallReportRepository;


public class FallReportControllerTest {

	@Mock
	FallReportRepository fallReportRepo;

	@Mock
	private FallReport testFallReport;

	@Mock
	private FallReport testFallReport2;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnReportsList() {
		when(fallReportRepo.findAll()).thenReturn(Collections.singletonList(testFallReport));
		assertThat(fallReportRepo.findAll(), contains(testFallReport));
}

	@Test
	public void shouldReturnSingleReport() {
				Long id = testFallReport2.getId();
				String item = testFallReport.getGCS();
				System.out.println(id);
				System.out.println(item);
				when(fallReportRepo.findById(0L)).thenReturn(Optional.of(testFallReport2));
				assertThat(fallReportRepo.findById(id), is(Optional.of(testFallReport2)));
			}
}
