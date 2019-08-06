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

import wcci.inlineconnect.models.Report;
import wcci.inlineconnect.models.TraumaReport;
import wcci.inlineconnect.repositories.TraumaReportRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/trauma-reports")
public class TraumaReportController {
	@Autowired
	private TraumaReportRepository traumaRepo;
	
	@GetMapping({"/",""})
	public Iterable<TraumaReport> findAllReports() {
		return traumaRepo.findAll();
	}
	
	@GetMapping({"/{id}","/{id}/"})
	public Report findSingleReports(@PathVariable Long id) {
		return traumaRepo.findById(id).get();
	}
	@PostMapping({"","/"})
	public void createTruamaReport(@RequestBody String body, HttpServletResponse response) throws JSONException, IOException {
		JSONObject json = (JSONObject) JSONParser.parseJSON(body);
		String medicNum = json.getString("medicNum");
		String chiefComplaint = json.getString("chiefComplaint");
		String date = json.getString("date");
		String narrative = json.getString("narrative");
		String sex = json.getString("sex");
		String age = json.getString("age");
		String BP = json.getString("bloodPressure");
		String HR = json.getString("heartRate");
		String SpO2 = json.getString("spO2");
		String RespRate = json.getString("respiratoryRate");
		String gcs = json.getString("gcs");
		String bloodSugar = json.getString("bloodSugar");
		System.out.println("test test test");
		TraumaReport reportToSave = new TraumaReport(medicNum, chiefComplaint, date, sex, age, narrative, BP, HR, SpO2, RespRate, gcs, bloodSugar);
		TraumaReport savedReport = traumaRepo.save(reportToSave);
		response.sendRedirect("/api/trauma-reports");
	}
	
}
