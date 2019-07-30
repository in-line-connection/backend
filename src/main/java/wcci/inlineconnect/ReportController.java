package wcci.inlineconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReportController {
	@Autowired
	private ReportRepository reportRepo;
	
	@GetMapping("reports")
	public Iterable<Report> findAllReports() {
		return reportRepo.findAll();
	}
	
	@GetMapping("reports/{id}")
	public Report findSingleReports(@PathVariable Long id) {
		return reportRepo.findById(id).get();
	}
	@PostMapping("reports")
	public Iterable<Report> createReport(@RequestBody Report report){
		reportRepo.save(report);
		return reportRepo.findAll();
		
	}
}
