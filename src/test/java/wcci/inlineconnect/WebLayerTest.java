package wcci.inlineconnect;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.http.MediaType;
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
		report = new Report("1","ll0", "report field", "blood pressure", "heart rate", "SPO2", "respiratory rate",
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
		mockMvc.perform(get("/api/reports/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json("{}"))
				.andExpect(content().json(mapper.writeValueAsString(report), true));

	}
	@Test
	public void shouldAddReport() throws Exception {
		when(reportRepo.save(any(Report.class))).thenReturn(report);
		when(reportRepo.findAll()).thenReturn(Collections.singletonList(report));
		mockMvc.perform(post("/api/reports")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				 .content(mapper.writeValueAsString(report)))
        .andExpect(status().isOk())
         .andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(report)), true));
				
				
	}
	
	
}
