package wcci.inlineconnect;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import wcci.inlineconnect.models.FallReport;

@Component
public class Initializer implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		FallReport report1 = new FallReport(false, false, "", false, false, null, null, null, null, null, null, null, null, null, null, null, null);

		System.out.println("RUNNING INITIALIZER");

	}
}