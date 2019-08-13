package wcci.inlineconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.inlineconnect.models.FallReport;

import wcci.inlineconnect.models.GunShotWoundReport;
import wcci.inlineconnect.models.MotorVehicleCrashReport;
import wcci.inlineconnect.models.OtherComplaintReport;
import wcci.inlineconnect.repositories.FallReportRepository;
import wcci.inlineconnect.repositories.GunShotWoundReportRepository;
import wcci.inlineconnect.repositories.MotorVehicleCrashReportRepository;
import wcci.inlineconnect.repositories.OtherComplaintReportRepository;


@Component
public class Initializer implements CommandLineRunner {
	@Autowired
	private FallReportRepository fallRepo;
	@Autowired
	private GunShotWoundReportRepository gswRepo;
	@Autowired
	private MotorVehicleCrashReportRepository mvcRepo;
	@Autowired
	private OtherComplaintReportRepository otherRepo;
	
	@Override
	public void run(String... args) throws Exception {
		

		FallReport report1 = new FallReport(false, false, "standing to ground", true, false, "medic 51 LCEMS","08-15-2019" , "1520","Medic 51 LCEMS disptached to walmart of Ironton for 79 y/o M/ patient.Patient was standing at checkout and tripped over his cane. Patient fell to ground stricking his arm on the counter. Upon arrival patient was alertx4 and denied LOC. Patients vitals obtained, within normal limites. Pupils pearrl and equal. GSC normal, range of motion present, PMS presentx4. Patients arm without injury. No pertent medical hx. Patient denied treatment/ transport on scene. Patient stable and alert to all standing. Refusel signed and call released at 1549. Medic 51 back in service", "Male", "79", "145/65", "75", "98%", "18", "15", "75");
		fallRepo.save(report1);
		
		MotorVehicleCrashReport report2 = new MotorVehicleCrashReport("medic 21 LCEMS", "07-11-2018", "1610", "MVC on county rd 1 mile marker 3. Car slide off the road", "F",
				"20", "110/64", "69", "100%", "16", "15",
				"n/a", "driver", "65", true, false, false);
		mvcRepo.save(report2);
		GunShotWoundReport report3 = new GunShotWoundReport("medic 21 LCEMS", "08-01-2019", "1006", "Medic 21 dispatched to residence for GSW victim. 21 year old female patient. GSW to upper right forearm", "F",
			"21", "120/60", "70", "99", "19", "15",
			"n/a", "right forearm", "1", true, "glock", false);
		gswRepo.save(report3);
		OtherComplaintReport report4 = new OtherComplaintReport(false, true, "blunt force trauma to face", "medic 12 LCEMS", "11-12-2018", "1150", "medic 21 dispatched to residence for 45 y/o m patient. patient feel and struck his face on the floor", "male","45", "140/80",
				"80", "99%","20", "12", "30");
		otherRepo.save(report4);
		System.out.println("RUNNING INITIALIZER");


	 
	}
}