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

import wcci.inlineconnect.models.FallReport;
import wcci.inlineconnect.models.Report;
import wcci.inlineconnect.repositories.FallReportRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/fall-reports")

public class FallReportController {
	
	@Autowired
	private FallReportRepository fallReportRepo;
	
	@GetMapping({"/",""})
	public Iterable<FallReport> findAllReports() {
		return fallReportRepo.findAll();
		
	}
	
	@GetMapping({"/{id}","/{id}/"})
	public Report findSingleReport(@PathVariable Long id) {
		return fallReportRepo.findById(id).get();
	}

	@PostMapping({ "", "/" }) 
	public void createTruamaReport(@RequestBody FallReport reportToSave, HttpServletResponse response)
			throws JSONException, IOException {
		fallReportRepo.save(reportToSave);
		response.sendRedirect("/api/fall-reports");
	}
}
