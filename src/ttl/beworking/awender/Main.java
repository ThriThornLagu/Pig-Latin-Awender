package ttl.beworking.awender;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	public static boolean shouldWork = false;
	
	public static void main(String[] args) {
		
		int runs = 0;
		
		try (Scanner reader = new Scanner(System.in)) {
			do { //Lóc hwæt
				boolean askAgain = false;
				
				System.out.println("How would you like to brook this software?");
				System.out.println("1. INPUT A STRING");
				System.out.println("2. AWEND YIVEN THREAD");
				System.out.println("3. AWEND THREADFOLDER");
				System.out.println("4. STOP");
				
				int choosing = 0;
				
				Pattern holdsRime = Pattern.compile("\\d");
				String nextLine = reader.nextLine(); //Helps keep the following dern from getting many more new lines.
				if (holdsRime.matcher(nextLine).matches()) choosing = Integer.parseInt(nextLine);
				else choosing = 0; shouldWork = true;
				
				switch(choosing) {
				case 1: Kirelists.inputString(reader.nextLine()); askAgain = true; runs++; break; //HANDED INPUT
				case 2: Kirelists.inputThread(reader.nextLine()); askAgain = true; runs++; break; //YIVEN THREAD IS INPUT
				case 3: System.out.println("NYI"); shouldWork = true; break; //Will read a whole thread folder yiven by end-brooker
				case 4: shouldWork = false; break; //OUTGO
				default: System.out.println("Unright input. Mint again."); shouldWork = true;
				}
				
				if (askAgain) {
					System.out.println("Would you like to run the software again? [Y/N]");

					String answer = reader.nextLine();
					
					if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
						shouldWork = true;
					} else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
						shouldWork = false;
					} else {
						System.out.println("Answer unright. Would you like to go again?");
						askAgain = true;
					}
				}
				
				System.out.println("Times run: " + runs);
				
	        } while (shouldWork);
			
		}
		
    }
	
}
