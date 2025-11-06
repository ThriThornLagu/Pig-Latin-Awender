package ttl.beworking.awender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
        try (Scanner reader = new Scanner(System.in)) {

            String input = reader.nextLine() + " ";

            ArrayList<String> words = BreakThwear.toStringTrum(input);
            
            System.out.println(Arrays.toString(words.toArray())); //Unbug to find what the software umbhies to be a word.
            
            for (int t = 0; t < words.size(); t++) {
            	
            	String anwardWord = words.get(t);
            	
            	//For the /two/ cases of a one-staff word coming after a word end marker (see Staff.isWordEndMark for more knowledge)
            	if (Staff.isWordEndMark(anwardWord.charAt(anwardWord.length() - 1)) && anwardWord.length() == 1) {
            		StringBuilder nw = new StringBuilder(anwardWord);
            		nw.append("ay");
            	} else words.set(t, Awend.toPigLatin(anwardWord));
            }

            String output = BreakThwear.toLine(words);

            System.out.println(output);
        }

    }
}
