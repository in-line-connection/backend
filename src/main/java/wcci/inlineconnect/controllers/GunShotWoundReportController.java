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

import wcci.inlineconnect.models.GunShotWoundReport;
import wcci.inlineconnect.models.Report;
import wcci.inlineconnect.repositories.GunShotWoundReportRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/gun-shot-wound-reports")
public class GunShotWoundReportController {
	@Autowired
	private GunShotWoundReportRepository gunShotWoundRepo;

	@GetMapping({ "/", "" })
	public Iterable<GunShotWoundReport> findAllReports() {
		return gunShotWoundRepo.findAll();
	}

	@GetMapping({ "/{id}", "/{id}/" })
	public Report findSingleReports(@PathVariable Long id) {
		return gunShotWoundRepo.findById(id).get();
	}

	@PostMapping({ "", "/" })
	public void createTruamaReport(@RequestBody GunShotWoundReport reportToSave, HttpServletResponse response)
			throws JSONException, IOException {
		gunShotWoundRepo.save(reportToSave);
		response.sendRedirect("/api/gun-shot-wound-reports");
	}
}
