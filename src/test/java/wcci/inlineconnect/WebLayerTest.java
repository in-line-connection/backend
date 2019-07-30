package wcci.inlineconnect;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ReportController.class)
@RunWith(SpringRunner.class)
public class WebLayerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ReportRepository reportRepo;

	private Report report;
	private ObjectMapper mapper;

	@Before
	public void setup() {
		report = new Report("1", true, "report field", "blood pressure", "heart rate", "SPO2", "respiratory rate",
				"GCS", "blood sugar");
		mapper = new ObjectMapper();
	}

	@Test
	public void shouldReturnAllReports() throws Exception {
		when(reportRepo.findAll()).thenReturn(Collections.singletonList(report));
		mockMvc.perform(get("/api/reports"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json("[{}]"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(report)), true));

	}
	@Test
	public void shouldReturnOneReport() throws Exception {
		when(reportRepo.findById(1l)).thenReturn(Optional.of(report));
		mockMvc.perform(get("/api/report/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json("[{}]"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(report)), true));

	}
}
