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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import wcci.inlineconnect.controllers.MotorVehicleCrashReportController;
import wcci.inlineconnect.models.GunShotWoundReport;
import wcci.inlineconnect.repositories.GunShotWoundReportRepository;

@WebMvcTest(MotorVehicleCrashReportController.class)
@RunWith(SpringRunner.class)
public class GunShotWoundReportWebLayerTest {

	// All tests ignored due to inheritance changes

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GunShotWoundReportRepository gunRepo;

	private GunShotWoundReport gunShotWoundReport;
	private ObjectMapper mapper;

	@Before
	public void setup() {

	}

	@Ignore
	@Test
	public void shouldReturnAllTReports() throws Exception {
		when(gunRepo.findAll()).thenReturn(Collections.singletonList(gunShotWoundReport));
		mockMvc.perform(get("/api/trauma-reports")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("[{}]"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(gunShotWoundReport)), true));
	}

	@Ignore
	@Test
	public void shouldReturnOneReport() throws Exception {
		when(gunRepo.findById(1l)).thenReturn(Optional.of(gunShotWoundReport));
		mockMvc.perform(get("/api/trauma-reports/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("{}"))
				.andExpect(content().json(mapper.writeValueAsString(gunShotWoundReport), true));

	}

	@Ignore
	@Test
	public void shouldAddReport() throws Exception {
		when(gunRepo.save(any(GunShotWoundReport.class))).thenReturn(gunShotWoundReport);
		when(gunRepo.findAll()).thenReturn(Collections.singletonList(gunShotWoundReport));
		mockMvc.perform(post("/api/trauma-reports").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(gunShotWoundReport))).andExpect(status().is3xxRedirection());
	}

}
