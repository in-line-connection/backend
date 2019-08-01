package wcci.inlineconnect.controllers;

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
@RequestMapping("/api")
public class TraumaReportController {
	@Autowired
	private TraumaReportRepository traumaRepo;
	
	@GetMapping("traumareports")
	public Iterable<TraumaReport> findAllReports() {
		return traumaRepo.findAll();
	}
	
	@GetMapping("traumareports/{id}")
	public Report findSingleReports(@PathVariable Long id) {
		return traumaRepo.findById(id).get();
	}
	@PostMapping("traumareports")
	public Iterable<TraumaReport> createReport(@RequestBody TraumaReport report){
		traumaRepo.save(report);
		return traumaRepo.findAll();
		
	}
}
