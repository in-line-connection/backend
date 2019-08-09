package wcci.inlineconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.inlineconnect.models.TraumaReport;
import wcci.inlineconnect.repositories.TraumaReportRepository;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	TraumaReportRepository traumaReportRepo;


	@Override
	public void run(String... args) throws Exception {

		
		TraumaReport report2 = new TraumaReport("59", "MVC", "Medic 59 dispatched County RD 53 Mile marker 5 for MVC, car slide off the rd.","Male","55", "08-23-19", "140/60", "89", "99%", "14", "15",
				"80");
		TraumaReport report7 = new TraumaReport("41", "GSW", "Medic 41 dispatched to residence for GSW.","Male","42", "7-23-2015", "89/45", "24", "85%", "6", "8",
				"n/a");
		TraumaReport report11 = new TraumaReport("56", "Fall", "Medic 56 dispatch to Walmart for fall.","Male","50", "08-28-2019", "129/99", "89", "97%", "19", "12",
				"n/a");
		traumaReportRepo.save(report2);
		traumaReportRepo.save(report11);
		traumaReportRepo.save(report7);
		
		System.out.println("RUNNING INITIALIZER");

	}
}