package ttl.beworking.awender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
        try (Scanner reader = new Scanner(System.in)) {

            String input = reader.nextLine();

            ArrayList<String> words = BreakThwear.toStringTrum(input);
            
            System.out.println(Arrays.toString(words.toArray())); //Unbug to find what the software umbhies to be a word.
            
            for (int t = 0; t < words.size(); t++) {
            	
            	String anwardWord = words.get(t);
            	
            	//For the /two/ cases of a one-staff word coming after a word end marker (see Staff.isWordEndMark for more knowledge),
            	//and Awend.toPigLatin for rakes on why this is built like this.
            	boolean isOneStaffWord = anwardWord.length() == 1 && !Staff.isMarker(anwardWord.charAt(0)) && !Character.isWhitespace(anwardWord.charAt(0));
            	boolean isBoutingToWield = (!(t == 0) && Staff.isWordEndMark(words.get(t - 1).charAt(0)) && isOneStaffWord) || (t == 0 && isOneStaffWord);
				
            	if (isBoutingToWield) {
            		StringBuilder nw = new StringBuilder(anwardWord);
            		nw.append("ay");
            		words.set(t, nw.toString());
            	} else words.set(t, Awend.toPigLatin(anwardWord));
            }

            String output = BreakThwear.toLine(words);

            System.out.println(output);
        }

    }
}
