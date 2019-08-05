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
import wcci.inlineconnect.models.MedicalReport;
import wcci.inlineconnect.repositories.MedicalReportRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class MedicalReportController {
	
	@Autowired
	private MedicalReportRepository medicalReportRepo;
	
	@GetMapping("/medical-reports")
	public Iterable<MedicalReport> getAllMedicalReports() {
		return medicalReportRepo.findAll();
		 
	}
	
	@GetMapping("/medical-reports/{id}")
	public MedicalReport getSingleMedicalReport(@PathVariable Long id) {
		return medicalReportRepo.findById(id).get();
	}
	@PostMapping("/medical-reports")
	public void createMedicalReport(@RequestBody String body, HttpServletResponse response) throws JSONException, IOException {
		JSONObject json = (JSONObject) JSONParser.parseJSON(body);
		String medicNum = json.getString("medicNum");
		String chiefComplaint = json.getString("chiefComplaint");
		String date = json.getString("date");
		String narrative = json.getString("narrative");
		String rhythm = json.getString("rhythm");
		String sex = json.getString("sex");
		String age = json.getString("age");
		String BP = json.getString("bloodPressure");
		String HR = json.getString("heartRate");
		String SpO2 = json.getString("spO2");
		String RespRate = json.getString("respiratoryRate");
		String gcs = json.getString("gcs");
		String bloodSugar = json.getString("bloodSugar");
		MedicalReport reportToSave = new MedicalReport(medicNum, chiefComplaint, date, sex, age, narrative, rhythm, BP, HR, SpO2, RespRate, gcs, bloodSugar);
		MedicalReport savedReport = medicalReportRepo.save(reportToSave);
		response.sendRedirect("/api/medical-reports");
	}
	

}
