package ttl.beworking.awender;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	
	public static boolean shouldWork = true, shouldThroughwon = true;
	
	public static void main(String[] args) {
		
		int runs = 0;
		
		try (Scanner reader = new Scanner(System.in)) {
			while (shouldWork) {
	        	
				shouldThroughwon = false;
				boolean askAgain = false;
				
				System.out.println("How would you like to brook this software?");
				System.out.println("1. INPUT A STRING");
				System.out.println("2. AWEND GIVEN THREAD");
				System.out.println("3. AWEND THREADFOLDER");
				System.out.println("4. STOP");
				
				int choosing = 0;
				
				Pattern holdsRime = Pattern.compile("\\d");
				String nextLine = reader.nextLine(); //Helps keep the following dern from getting many more new lines.
				if (holdsRime.matcher(nextLine).matches()) choosing = Integer.parseInt(nextLine);
				else choosing = 0; shouldThroughwon = true;
				
				switch(choosing) {
				case 1: Kirelists.inputString(reader.nextLine()); askAgain = true; break; //HANDED INPUT
				case 2: System.out.println("NYI"); shouldThroughwon = true; break;
				case 3: System.out.println("NYI"); shouldThroughwon = true; break;
				case 4: shouldWork = false; break; //OUTGO
				default: System.out.println("Unright input. Mint again."); shouldThroughwon = true;
				}
				
				runs++;
				
				if (askAgain) {
					System.out.println("Would you like to run the software again? [Y/N]");

					String answer = reader.nextLine();

					if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
						shouldThroughwon = true;
					} else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
						shouldWork = false;
					} else {
						System.out.println("Answer unright. Would you like to go again?");
						askAgain = true;
					}
				}
				
				System.out.println("Times run: " + runs);
				
	        }
			
		}
		
    }
	
}
