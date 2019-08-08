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

import wcci.inlineconnect.controllers.CardiacReportController;
import wcci.inlineconnect.models.CardiacReport;
import wcci.inlineconnect.models.MVC;
import wcci.inlineconnect.repositories.CardiacReportRepository;
import wcci.inlineconnect.repositories.MVCRepository;

@WebMvcTest(CardiacReportController.class)
@RunWith(SpringRunner.class)
public class CardiacArrestReportWebLayerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CardiacReportRepository cardiacReportRepo;
	
	@MockBean
	private MVCRepository mvcRepo;

	private CardiacReport cardiacReport;
	private MVC mvc;
	private ObjectMapper mapper;

	@Before
	public void setup() {
		mvc = new MVC("Driver", "45 mph", true, true, false);
		mvcRepo.save(mvc);
		cardiacReport = new CardiacReport("medicNum",mvc, "date","sex", "age", "narrative", "rhythm");
		mapper = new ObjectMapper();
	}

	@Test
	public void shouldReturnAllReports() throws Exception {
		when(cardiacReportRepo.findAll()).thenReturn(Collections.singletonList(cardiacReport));
		mockMvc.perform(get("/api/cardiac-reports")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("[{}]"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(cardiacReport)),
						true));
	}

	@Test
	public void shouldReturnOneReport() throws Exception {
		when(cardiacReportRepo.findById(1l)).thenReturn(Optional.of(cardiacReport));
		mockMvc.perform(get("/api/cardiac-reports/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("{}"))
				.andExpect(content().json(mapper.writeValueAsString(cardiacReport), true));

	}
	@Ignore
	@Test
	public void shouldAddReport() throws Exception {
		when(cardiacReportRepo.save(any(CardiacReport.class))).thenReturn(cardiacReport);
		when(cardiacReportRepo.findAll()).thenReturn(Collections.singletonList(cardiacReport));
		String cardiacReportJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(cardiacReport);
		System.out.println(cardiacReportJson);
		mockMvc.perform(post("/api/cardiac-reports")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(cardiacReportJson))
				.andExpect(status().is3xxRedirection());

	}

}
