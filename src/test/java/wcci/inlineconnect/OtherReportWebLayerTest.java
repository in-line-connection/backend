
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

import wcci.inlineconnect.controllers.OtherComplaintReportController;
import wcci.inlineconnect.models.OtherComplaintReport;
import wcci.inlineconnect.repositories.OtherComplaintReportRepository;

	@WebMvcTest(OtherComplaintReportController.class)
	@RunWith(SpringRunner.class)
	public class OtherReportWebLayerTest {

		
		@Autowired
		private MockMvc mockMvc;

		@MockBean
		private OtherComplaintReportRepository otherComplaintRepo;

		private OtherComplaintReport otherReport1 = new OtherComplaintReport(false, false, "ran over", "101", "12/25", "high noon", "Grandma got ran over by a reindeer", "female", "4",  "120/80",
				"90", "12", "16", "5", "191");
		private ObjectMapper mapper = new ObjectMapper();

		@Before
		public void setup() {
			
			
		}
		
		@Test
		public void shouldReturnAllReports() throws Exception {
			
			when(otherComplaintRepo.findAll()).thenReturn(Collections.singletonList(otherReport1));
			mockMvc.perform(get("/api/other-reports"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().json("[{}]"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(otherReport1)), true));
		}
		
		@Test
		public void shouldReturnOneReport() throws Exception {
			when(otherComplaintRepo.findById(1l)).thenReturn(Optional.of(otherReport1));
			mockMvc.perform(get("/api/other-reports/1")).andExpect(status().isOk())
					.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("{}"))
					.andExpect(content().json(mapper.writeValueAsString(otherReport1), true));

		}
		
		@Test
		public void shouldAddReport() throws Exception {
			when(otherComplaintRepo.save(any(OtherComplaintReport.class))).thenReturn(otherReport1);
			when(otherComplaintRepo.findAll()).thenReturn(Collections.singletonList(otherReport1));
			mockMvc.perform(post("/api/other-reports").contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(mapper.writeValueAsString(otherReport1)))
					.andExpect(status().is3xxRedirection());
		}

	}



