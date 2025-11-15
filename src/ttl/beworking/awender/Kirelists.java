package ttl.beworking.awender;

import java.util.ArrayList;
import java.util.Arrays;

public class Kirelists {

	public static void inputString(String line) {
		String output = haftString(line);
		
		System.out.println(output);
	}
	
	public static void inputThread(String threadPath) {
		String thread = Thread.loadThreadAsString(threadPath);
		String[] threadLines = Thread.BreakThreadToStringList(thread);
		
		ArrayList<String> linesHoldend = new ArrayList<>();
		
		for (String line : threadLines) {
			String string = haftString(line);
			
			linesHoldend.add(string);
		}
		
		Thread.writeThreadToNewStead(linesHoldend, threadPath);
	}
	
	//Innings of above wises were stirred to here for dealt dern anyets.
	private static String haftString(String input) {
	
		ArrayList<String> words = BreakThwear.toStringTrum(input);

		System.out.println(Arrays.toString(words.toArray())); //Unbug to find what the software umbhies to be a word.
	        
		for (int t = 0; t < words.size(); t++) {
	        	
			String anwardWord = words.get(t);
	        	
			//For the /two/ cases of a one-staff word coming after a word end marker (see Staff.isWordEndMark for more knowledge),
			//and Awend.toPigLatin for rakes on why this is built like this.
			boolean isOneStaffWord = anwardWord.length() == 1 && !Staff.isMarker(anwardWord.charAt(0)) && !Character.isWhitespace(anwardWord.charAt(0));
			boolean isBoutingToWield = (!(t == 0) && Staff.isWordEndMark(words.get(t - 1).charAt(0)) && isOneStaffWord) || (t == 0 && isOneStaffWord);
			
			if (words.get(t).charAt(0) == '@') {
				boolean isEmail = SpareStirings.stireEmail(words, t);
				if (isEmail) {
					continue;
				} else {
//					System.out.println("Token " + t + " has an @, ack no fayed email.");
					words.set(t, "taay");
					if (!Character.isWhitespace(words.get(t - 1).charAt(0))) {
						words.add(t, " ");
					
						if (!Character.isWhitespace(words.get(t + 1).charAt(0))) {
							words.add(t + 2, " ");
						}
					} else if (!Character.isWhitespace(words.get(t + 1).charAt(0))) {
						words.add(t + 1, " ");
					}
//					System.out.println("Word at token " + t + " is " + words.get(t) + ".");
					continue; //This is the only way I found to make this work as wanted.
				}
			}
			
			if (isBoutingToWield) {
				StringBuilder nw = new StringBuilder(anwardWord);
				nw.append("ay");
				words.set(t, nw.toString());
			} else words.set(t, Awend.toPigLatin(anwardWord));
		}
	
		String output = BreakThwear.toLine(words);
		
		return output;
	}
	
}
