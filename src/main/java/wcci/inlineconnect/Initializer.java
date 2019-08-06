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

		MedicalReport report1 = new MedicalReport("51", "CVA", "08-10-2019" ,"Female","60", "medic 51 dispatch to residence for 60 y/o F/ patient. Cheif Complaint CVA symptoms. Patient presents with R side weakness and paralysis.", "180/100", "112", "92%", "22", "15", "80",
				"Sinus Rhythm");
		medicalReportRepo.save(report1);
		MedicalReport report5 = new MedicalReport("21", "MI", "12-01-2018" ,"Male","89", "Medic 21 dispatch to residence for 89 y/o M/ patient. Patient CC Chest Pain. Patient presenting with pale skin.", "160/90", "99", "95%", "23","15","89",
				"NonStemi");
		MedicalReport report10 = new MedicalReport("56", "Cough", "08-04-19" ,"Male","4", "Medic 56 dispatch to residence for 4 y/o M/ presenting with a cough and runny nose. Patient skin PWD, A+Ox4, denied pain.", "100/55", "89", "99%", "22","15", "n/a",
				"n/a");
		TraumaReport report2 = new TraumaReport("59", "MVC", "Medic 59 dispatched County RD 53 Mile marker 5 for MVC, car slide off the rd.","Male","55", "08-23-19", "140/60", "89", "99%", "14", "15",
				"80");
		TraumaReport report7 = new TraumaReport("41", "GSW", "Medic 41 dispatched to residence for GSW.","Male","42", "7-23-2015", "89/45", "24", "85%", "6", "8",
				"n/a");
		TraumaReport report11 = new TraumaReport("56", "Fall", "Medic 56 dispatch to Walmart for fall.","Male","50", "08-28-2019", "129/99", "89", "97%", "19", "12",
				"n/a");
		CardiacReport report4 = new CardiacReport("89", "Witnessed","08-01-2019","F", "100", "Medic 89 dispatch to residence for cardiac arrest.", "Asystole");
		CardiacReport report8 = new CardiacReport("23", "Witnessed","09-01-2018","M", "96", "Medic 23 dispatch to residence for cardiac arrest", "PEA");
		CardiacReport report13 = new CardiacReport("1629", "Non Witnessed","09-03-2018","F", "65", "Medic 1629 dispatch to residence for cardiac arrest", "VFIB");
		traumaReportRepo.save(report2);
		cardiacReportRepo.save(report13);
		cardiacReportRepo.save(report8);
		medicalReportRepo.save(report10);
		traumaReportRepo.save(report11);
		cardiacReportRepo.save(report4);
		medicalReportRepo.save(report5);
		traumaReportRepo.save(report7);
		
		System.out.println("RUNNING INITIALIZER");

	}
}