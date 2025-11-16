package ttl.beworking.awender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Setup {

	public String keyForBreak = "";
	
	public Setup() {}
	
	public void readSetupThread() {
		
		Path setup = Path.of("setup.txt");
		
		try (var reader = new BufferedReader(new FileReader(setup.toFile()))) {
			
			String string;
			String[] kires;
			
			if ((string = reader.readLine()).startsWith("KEY")) {
				kires = string.split("\t");
				keyForBreak = kires[1];
//				System.out.println("Key: " + keyForBreak);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("There was a hitch in reading the setup thread.");
		}
		
	}
	
}
