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

import wcci.inlineconnect.models.OtherComplaintReport;
import wcci.inlineconnect.models.Report;
import wcci.inlineconnect.repositories.OtherComplaintReportRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/other-reports")


public class OtherComplaintReportController {
		
	@Autowired
	private OtherComplaintReportRepository otherComplaintRepo;
	
	
		@GetMapping({"/",""})
		public Iterable<OtherComplaintReport> findAllReports() {
			return otherComplaintRepo.findAll();
		}
		
		@GetMapping({"/{id}","/{id}/"})
		public Report findSingleReports(@PathVariable Long id) {
			return otherComplaintRepo.findById(id).get();
		}
		@PostMapping({"","/"})
		public void createOtherReport(@RequestBody String body, HttpServletResponse response) throws JSONException, IOException {
			JSONObject json = (JSONObject) JSONParser.parseJSON(body);
			boolean penetratingTrauma = json.getBoolean("penetratingTrauma");
			boolean bluntForceTrauma = json.getBoolean("bluntForceTrauma");
			String incident = json.getString("incident");
			String medicNum = json.getString("medicNum");
			String narrative = json.getString("narrative");
			String sex = json.getString("sex");
			String age = json.getString("age");
			String date = json.getString("date");
			String timeOfIncident = json.getString("timeOfIncident");
			String BP = json.getString("bloodPressure");
			String HR = json.getString("heartRate");
			String SpO2 = json.getString("spO2");
			String RespRate = json.getString("respiratoryRate");
			String gcs = json.getString("gcs");
			String bloodSugar = json.getString("bloodSugar");
			System.out.println("test test test");
			OtherComplaintReport reportToSave = 
					new OtherComplaintReport(penetratingTrauma, bluntForceTrauma, 
							incident, medicNum, date, timeOfIncident, narrative, sex, age, BP, HR,
							SpO2, RespRate, gcs, bloodSugar);
			OtherComplaintReport savedReport = otherComplaintRepo.save(reportToSave);
			response.sendRedirect("/api/other-reports");
		}
		
	}

