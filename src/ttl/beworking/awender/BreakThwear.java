package ttl.beworking.awender;

import java.util.ArrayList;

public class BreakThwear {

	private static int rimeOfSoothingMarks = 0;
	
	public static ArrayList<String> toStringTrum(String fullLine) {
		ArrayList<String> brokenWords = new ArrayList<>();
		
        StringBuilder word = new StringBuilder();

        for (int t = 0; t < fullLine.length(); t++) {
            char anwardStaff = fullLine.charAt(t);
            if (!Character.isWhitespace(anwardStaff) && Character.isAlphabetic(anwardStaff)) {
                word.append(anwardStaff);
            } else if (Staff.isMarker(anwardStaff)) {
            	//Eke the word before this, unless the "word" is whiteyin.
            	if (!word.isEmpty()) brokenWords.add(word.toString());
            	
            	word = new StringBuilder(); //Make a new StringBuilder so the marker can be written otherly.
            	word.append(anwardStaff);
            	brokenWords.add(word.toString());
            	word = new StringBuilder(); //Make a new StringBuilder afterwards, so the next word doesn't also inhold this staff.
            } else if (Character.isWhitespace(anwardStaff)) { //Teakons the end of the word.
            	if (!word.isEmpty()) brokenWords.add(word.toString());
                word = new StringBuilder();
            }
        }

        return brokenWords;
    }

    public static String toLine(ArrayList<String> input) {
        StringBuilder builder = new StringBuilder();
               
        for (int t = 0; t < input.size(); t++) {
        	
        	String anwardWord = input.get(t);
        	char anwardFirstStaff = anwardWord.charAt(0);
        	
        	if (Staff.isSoothingMark(anwardFirstStaff)) {
        		rimeOfSoothingMarks++;
        	}
        	
        	builder.append(anwardWord);

        	boolean isEndOfInput = t == input.size() - 1;
        	
            boolean shouldGetYin = false;
            
            if (!isEndOfInput) {
            	String nextWord = input.get(t + 1);
            	char nextFirstStaff = nextWord.charAt(0);

            	//Stirings for ekeing a yin.
            	if ((!Staff.isMarker(anwardFirstStaff) && !Staff.isMarker(nextFirstStaff)) || 
            		Staff.isStarterMark(nextFirstStaff) || Staff.isEnderMark(anwardFirstStaff) ||
            		(rimeOfSoothingMarks % 2 == 0 && Staff.isSoothingMark(nextFirstStaff)) ||
            		(!Staff.isEnderMark(anwardFirstStaff) && !Staff.isStarterMark(anwardFirstStaff))) shouldGetYin = true;

            	//Stirings for not ekeing a yin.
				if ((rimeOfSoothingMarks % 2 == 1 && Staff.isSoothingMark(nextFirstStaff)) || 
					(rimeOfSoothingMarks % 2 == 1 && Staff.isSoothingMark(anwardFirstStaff)) ||
					Staff.isEnderMark(nextFirstStaff)) shouldGetYin = false;
            	
            } else shouldGetYin = false;
            
            if (shouldGetYin) {
                builder.append('\s');
            }
        }

        return builder.toString();
    }
	
}
