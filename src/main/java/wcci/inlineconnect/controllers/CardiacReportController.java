package wcci.inlineconnect.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wcci.inlineconnect.models.CardiacReport;
import wcci.inlineconnect.repositories.CardiacReportRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/cardiac-reports")
public class CardiacReportController {
	
	@Autowired
	private CardiacReportRepository cardiacReportRepo;

	@GetMapping({"", "/"})
	public Iterable<CardiacReport> getAllCardiacReports() {
		return cardiacReportRepo.findAll();
	}
	
	@GetMapping({"{id}", "{id}/"})
	public CardiacReport getOneCardiacReport(@PathVariable Long id) {
		return cardiacReportRepo.findById(id).get();
	}
	
	@PostMapping({"", "/"})
	public void createCardiacReport(@RequestBody String body, HttpServletResponse response) throws JSONException, IOException {
		JSONObject json = (JSONObject) JSONParser.parseJSON(body);
		String medicNum = json.getString("medicNum");
		String chiefComplaint = json.getString("chiefComplaint");
		String date = json.getString("date");
		String narrative = json.getString("narrative");
		String rhythm = json.getString("rhythm");
		String sex = json.getString("sex");
		String age = json.getString("age");
		CardiacReport reportToSave = new CardiacReport(medicNum, chiefComplaint, date, sex, age, narrative, rhythm);
		CardiacReport savedReport = cardiacReportRepo.save(reportToSave);
		response.sendRedirect("/api/cardiac-reports");
	}


}
