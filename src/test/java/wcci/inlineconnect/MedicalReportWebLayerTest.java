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

import wcci.inlineconnect.controllers.MedicalReportController;
import wcci.inlineconnect.models.MedicalReport;
import wcci.inlineconnect.repositories.MedicalReportRepository;

@WebMvcTest(MedicalReportController.class)
@RunWith(SpringRunner.class)
public class MedicalReportWebLayerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MedicalReportRepository medicalReportRepo;

	private MedicalReport medicalReport;
	private ObjectMapper mapper;

	@Before
	public void setup() {
		medicalReport = new MedicalReport("51", "CVA", "12-01-1990" , "lmlmlmlmlmlml", "120/60", "60", "98%", "16", "15", "80",
				"Sinus Rhythm", "april");
		mapper = new ObjectMapper();
		// (String medicNum, String chiefComplaint, String narrative,String date, String bloodPressure, String heartRate,
		// String spO2, String respiratoryRate, String GCS, String bloodSugar) 
		
	}
	
	@Test
	public void shouldReturnAllMedicalReports() throws Exception {
		when(medicalReportRepo.findAll()).thenReturn(Collections.singletonList(medicalReport));
		mockMvc.perform(get("/api/medical-reports")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("[{}]"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(medicalReport)),
						true));
		
	}
	
	@Test
	public void shouldReturnOneMedicalReport() throws Exception {
		when(medicalReportRepo.findById(1l)).thenReturn(Optional.of(medicalReport));
		mockMvc.perform(get("/api/medical-reports/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("{}"))
				.andExpect(content().json(mapper.writeValueAsString(medicalReport), true));
	

}
}
