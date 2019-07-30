package wcci.inlineconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		
}
