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

		MedicalReport report1 = new MedicalReport("51", "CVA", "12-01-1990" ,"Female","14", "lmlmlmlmlmlml", "120/60", "60", "98%", "16", "80",
				"Sinus Rhythm", "april");
		medicalReportRepo.save(report1);
		TraumaReport report2 = new TraumaReport("50", "MI", "lmlmlmlmlmlml","Male","55", "128/60", "69", "90%", "8", "10", "90",
				"SVT");
		traumaReportRepo.save(report2);
		CardiacReport report4 = new CardiacReport("Witness", "lmlmlmlmlmlml","Female","33", "SVT", "", "");
		cardiacReportRepo.save(report4);
		MedicalReport report5 = new MedicalReport("53", "CVA", "12-01-1990" ,"Male","28", "lmlmlmlmlmlml", "120/60", "60", "98%", "16", "80",
				"Sinus Rhythm", "april");
		medicalReportRepo.save(report5);
		TraumaReport report7 = new TraumaReport("53", "MI", "lmlmlmlmlmlml","Male","99", "128/60", "69", "90%", "8", "10", "90",
				"SVT");
		traumaReportRepo.save(report7);
		CardiacReport report8 = new CardiacReport("Witness", "lmlmlmlmlmlml","Female","62", "SVT", "", "");
		cardiacReportRepo.save(report8);
		MedicalReport report10 = new MedicalReport("56", "CVA", "12-01-1990" ,"Male","13", "lmlmlmlmlmlml", "120/60", "60", "98%", "16", "80",
				"Sinus Rhythm", "april");
		medicalReportRepo.save(report10);
		TraumaReport report11 = new TraumaReport("56", "MI", "lmlmlmlmlmlml","Female","60", "128/60", "69", "90%", "8", "10", "90",
				"SVT");
		traumaReportRepo.save(report11);
		CardiacReport report13 = new CardiacReport("No Witness", "lmlmlmlmlmlml","Male","42", "SVT", "", "");
		cardiacReportRepo.save(report13);
		
		System.out.println("RUNNING INITIALIZER");

	}
}