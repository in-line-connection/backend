package wcci.inlineconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.inlineconnect.models.CardiacReport;
import wcci.inlineconnect.models.MedicalReport;
import wcci.inlineconnect.models.TraumaReport;
import wcci.inlineconnect.repositories.CardiacReportRepository;
import wcci.inlineconnect.repositories.MedicalReportRepository;
import wcci.inlineconnect.repositories.TraumaReportRepository;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	MedicalReportRepository medicalReportRepo;
	@Autowired
	TraumaReportRepository traumaReportRepo;
	@Autowired
	CardiacReportRepository cardiacReportRepo;

	@Override
	public void run(String... args) throws Exception {

		MedicalReport report1 = new MedicalReport("51", "CVA", "12-01-1990" , "lmlmlmlmlmlml", "120/60", "60", "98%", "16", "15", "80",
				"Sinus Rhythm", "april");
		medicalReportRepo.save(report1);
		TraumaReport report2 = new TraumaReport("50", "MI", "lmlmlmlmlmlml", "128/60", "69", "90%", "8", "10", "90",
				"SVT");
		traumaReportRepo.save(report2);
		CardiacReport report4 = new CardiacReport("Witness", "lmlmlmlmlmlml", "SVT", "", "");
		cardiacReportRepo.save(report4);
		System.out.println("RUNNING INITIALIZER");

	}
}