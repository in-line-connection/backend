package wcci.inlineconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	

}
