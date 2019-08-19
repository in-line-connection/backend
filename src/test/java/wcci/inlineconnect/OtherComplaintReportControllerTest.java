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

import wcci.inlineconnect.models.OtherComplaintReport;
import wcci.inlineconnect.repositories.OtherComplaintReportRepository;


public class OtherComplaintReportControllerTest {

	@Mock
	OtherComplaintReportRepository otherReportRepo;

	@Mock
	private OtherComplaintReport otherReport1;

	@Mock
	private OtherComplaintReport otherReport2;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldReturnReportsList() {
		when(otherReportRepo.findAll()).thenReturn(Collections.singletonList(otherReport1));
		assertThat(otherReportRepo.findAll(), contains(otherReport1));
}

	@Test
	public void shouldReturnSingleReport() {
				Long id = otherReport2.getId();
				String item = otherReport1.getGCS();
				System.out.println(id);
				System.out.println(item);
				when(otherReportRepo.findById(0L)).thenReturn(Optional.of(otherReport2));
				assertThat(otherReportRepo.findById(id), is(Optional.of(otherReport2)));
			}
}
