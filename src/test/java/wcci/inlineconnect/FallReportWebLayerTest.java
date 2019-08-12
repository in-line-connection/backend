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

import wcci.inlineconnect.controllers.FallReportController;
import wcci.inlineconnect.models.FallReport;
import wcci.inlineconnect.models.TraumaReport;
import wcci.inlineconnect.repositories.FallReportRepository;

@WebMvcTest(FallReportController.class)
@RunWith(SpringRunner.class)
public class FallReportWebLayerTest {

	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FallReportRepository fallRepo;

	private FallReport fallReport1;
	private ObjectMapper mapper;

	@Before
	public void setup() {
		
	}
	
	@Test
	public void shouldReturnAllReports() throws Exception {
		when(fallRepo.findAll()).thenReturn(Collections.singletonList(fallReport1));
		mockMvc.perform(get("/api/fall-reports")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("[{}]"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(fallReport1)), true));
	}
	
	@Test
	public void shouldReturnOneReport() throws Exception {
		when(fallRepo.findById(1l)).thenReturn(Optional.of(fallReport1));
		mockMvc.perform(get("/api/fall-reports/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("{}"))
				.andExpect(content().json(mapper.writeValueAsString(fallReport1), true));

	}
	
	@Test
	public void shouldAddReport() throws Exception {
		when(fallRepo.save(any(FallReport.class))).thenReturn(fallReport1);
		when(fallRepo.findAll()).thenReturn(Collections.singletonList(fallReport1));
		mockMvc.perform(post("/api/fall-reports").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(fallReport1))).andExpect(status().is3xxRedirection());
	}

}
