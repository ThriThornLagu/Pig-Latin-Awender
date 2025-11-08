package ttl.beworking.awender;

import java.util.ArrayList;

public class BreakThwear {

	public static ArrayList<String> toStringTrum(String fullLine) {
		ArrayList<String> brokenWords = new ArrayList<>();
		
        StringBuilder word = new StringBuilder();

        for (int t = 0; t < fullLine.length(); t++) {
            char anwardStaff = fullLine.charAt(t);
            if (!Character.isWhitespace(anwardStaff) && Character.isAlphabetic(anwardStaff)) {
                word.append(anwardStaff);
            } else if (Staff.isMarker(anwardStaff)) {
            	if (anwardStaff == '\'') {
            		word.append(anwardStaff);
            		continue;
            	}
            	
            	//Eke the word before this, unless the "word" is whiteyin.
            	if (!word.isEmpty()) brokenWords.add(word.toString());
            	
            	word = new StringBuilder(); //Make a new StringBuilder so the marker can be written otherly.
            	word.append(anwardStaff);
            	brokenWords.add(word.toString());
            	word = new StringBuilder(); //Make a new StringBuilder afterwards, so the next word doesn't also inhold this staff.
            } else if (Character.isWhitespace(anwardStaff)) { //Teakons the end of the word.
            	if (!word.isEmpty()) brokenWords.add(word.toString());
                
            	word = new StringBuilder();
                //We want to write down every whiteyin for when edbuilding the string.
                word.append(anwardStaff);
                brokenWords.add(word.toString());
                
                word = new StringBuilder();
            }
        }

        return brokenWords;
    }

    public static String toLine(ArrayList<String> input) {
        StringBuilder builder = new StringBuilder();
               
        for (int t = 0; t < input.size(); t++) {
        	
        	String anwardWord = input.get(t);
        	
        	builder.append(anwardWord);
        }

        return builder.toString();
    }
	
}
