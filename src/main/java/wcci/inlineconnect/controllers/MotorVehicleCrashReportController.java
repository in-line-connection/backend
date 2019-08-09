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

import wcci.inlineconnect.models.MotorVehicleCrashReport;
import wcci.inlineconnect.models.Report;
import wcci.inlineconnect.models.TraumaReport;
import wcci.inlineconnect.repositories.MotorVehicleCrashReportRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/MotorVehicleCrash-Reports")
public class MotorVehicleCrashReportController {
	@Autowired
	private MotorVehicleCrashReportRepository motorVehicleCrashRepo;

	@GetMapping({ "/", "" })
	public Iterable<MotorVehicleCrashReport> findAllReports() {
		return motorVehicleCrashRepo.findAll();
	}

	@GetMapping({ "/{id}", "/{id}/" })
	public Report findSingleReports(@PathVariable Long id) {
		return motorVehicleCrashRepo.findById(id).get();
	}

	@PostMapping({ "", "/" })
	public void createTruamaReport(@RequestBody String body, HttpServletResponse response)
			throws JSONException, IOException {
		JSONObject json = (JSONObject) JSONParser.parseJSON(body);
		String medicNum = json.getString("medicNum");
		String timeOfIncident = json.getString("time");
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
		String speed = json.getString("speed");
		String seatPosition = json.getString("seatPosition");
		boolean ambulatory = json.getBoolean("ambulatory");
		boolean prolongedExtrication = json.getBoolean("prolongedExtrication");
		boolean immobilized = json.getBoolean("immobilized");

		System.out.println("test test test");
		MotorVehicleCrashReport reportToSave = new MotorVehicleCrashReport(medicNum, date, narrative, age, timeOfIncident,
				sex, BP, HR, SpO2, RespRate, gcs, bloodSugar, speed, seatPosition, ambulatory,
				prolongedExtrication, immobilized);
		MotorVehicleCrashReport savedReport = motorVehicleCrashRepo.save(reportToSave);
		response.sendRedirect("/api/MotorVehicleCrash-Reports");
	}
}
