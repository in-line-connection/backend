package wcci.inlineconnect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.inlineconnect.repositories.TraumaReportRepository;

@Component
public class Initializer implements CommandLineRunner {

	@Autowired
	TraumaReportRepository traumaReportRepo;


	@Override
	public void run(String... args) throws Exception {

		
		System.out.println("RUNNING INITIALIZER");

	}
}