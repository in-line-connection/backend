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

@WebMvcTest(TraumaReportController.class)
@RunWith(SpringRunner.class)
public class TraumaWebLayerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TraumaReportRepository traumaRepo;
	
	private TraumaReport TruamaReport;
	private ObjectMapper mapper;
	
	
	@Before
	public void setup() {
		TruamaReport = new TraumaReport("1", "MVC", "Report", "07-07-17", "bp", "HR", "spO2", "respRate", "motor skill", "sugar");
		mapper = new ObjectMapper();
	}
	
	@Test
	public void shouldReturnAllTReports() throws Exception {when(traumaRepo.findAll()).thenReturn(Collections.singletonList(TruamaReport));
	mockMvc.perform(get("/api/traumareports"))
	.andExpect(status().isOk())
	.andExpect(content().contentType("application/json;charset=UTF-8"))
	.andExpect(content().json("[{}]"))
	.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(TruamaReport)), true));
}
	@Test
	public void shouldReturnOneReport() throws Exception {
		when(traumaRepo.findById(1l)).thenReturn(Optional.of(TruamaReport));
		mockMvc.perform(get("/api/traumareports/1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json("{}"))
				.andExpect(content().json(mapper.writeValueAsString(TruamaReport), true));

	}
	@Test
	public void shouldAddReport() throws Exception {
		when(traumaRepo.save(any(TraumaReport.class))).thenReturn(TruamaReport);
		when(traumaRepo.findAll()).thenReturn(Collections.singletonList(TruamaReport));
		mockMvc.perform(post("/api/traumareports")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				 .content(mapper.writeValueAsString(TruamaReport)))
        .andExpect(status().isOk())
         .andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(TruamaReport)), true));
				
				
	}
	
	
}
