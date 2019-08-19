package wcci.inlineconnect.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

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
		public void createOtherReport(@RequestBody OtherComplaintReport reportToSave, HttpServletResponse response) throws IOException {
			otherComplaintRepo.save(reportToSave);
			response.sendRedirect("/api/other-reports");
		}
		
	}

