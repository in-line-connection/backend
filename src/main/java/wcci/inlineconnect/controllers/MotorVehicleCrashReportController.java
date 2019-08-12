package wcci.inlineconnect.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
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
import wcci.inlineconnect.repositories.MotorVehicleCrashReportRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/motor-vehicle-crash-reports")
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
	public void createTruamaReport(@RequestBody MotorVehicleCrashReport reportToSave, HttpServletResponse response)
			throws JSONException, IOException {
		motorVehicleCrashRepo.save(reportToSave);
		response.sendRedirect("/api/MotorVehicleCrash-Reports");
	}
}
