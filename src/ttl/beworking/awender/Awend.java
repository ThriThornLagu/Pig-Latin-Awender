package ttl.beworking.awender;

public class Awend {

	private static boolean allHigh = false, firstStaffOthwharving = false, lastStaffOthwharving = false;
	
	public static String toPigLatin(String word) {

		char firstStaff = word.charAt(0);
		//Break the wise if this word is a marker or whiteyin
        if ((Staff.isMarker(firstStaff) && firstStaff != '\'') || 
        		Character.isWhitespace(word.charAt(0)) || 
        		(firstStaff == '\'' && word.length() == 1)) return word;

        StringBuilder builder = new StringBuilder();
        
        char[] string = word.toCharArray();
        string = bareOthwharvings(string);
        firstStaff = string[0];
        
        if (string.length >= 2) {
	        if (Character.isUpperCase(string[0]) && Character.isUpperCase(string[1])) allHigh = true;
	        else allHigh = false;
        } else { //It's alright if something like 'iay' happens (but for the cases thate in Kirelists.haftString())
        	allHigh = false;
        }
        
        if (string.length >= 2) {
	        string = makeWordBeforeEkeing(string);
	        if (firstStaffOthwharving) builder.append('\'');
	        for (char s : string) builder.append(s);
	        
	        if (allHigh) builder.append("AY");
	        else builder.append("ay");

	        if (lastStaffOthwharving) builder.append('\'');
        } else {
        	if (firstStaffOthwharving) builder.append('\'');
        	builder.append(Character.toLowerCase(firstStaff));
        	builder.append("ay");
        	if (lastStaffOthwharving) builder.append('\'');
        }
        
        edsetStaffOthwharvingStirings();
        
        return builder.toString();
    }
	
	public static String unawendFromPigLatin(String word) {
		
		char firstStaff = word.charAt(0);

		if ((Staff.isMarker(firstStaff) && firstStaff != '\'') || 
        		Character.isWhitespace(word.charAt(0)) || 
        		(firstStaff == '\'' && word.length() == 1)) return word;

        StringBuilder builder = new StringBuilder();
        
        char[] string = word.toCharArray();
        string = bareOthwharvings(string);
        
	    if (Character.isUpperCase(string[0]) && Character.isUpperCase(string[1])) allHigh = true;
	    else allHigh = false;

//        System.out.println("Unawending: " + word);
//        System.out.println("With trum of staves: \n" + Arrays.toString(string));
        
	    if (firstStaffOthwharving) builder.append('\'');
	    
	    //Fares like the awend working, but in switched layout.
	    if (string.length > 3) {
		    for (int t = -1; t < string.length - 3; t++) {
		    	if (t == -1) {
		    		if (allHigh) builder.append(Character.toUpperCase(string[string.length - 3]));
		    		else builder.append(string[string.length - 3]);
		    	}
		    	else {
//		    		if (t == 0) System.out.println("Unawend is at t == 0 with staff: " + string[0]);
		    		builder.append(string[t]);
		    	}
		    }
	    } else {
	    	builder.append(string[0]); //This is a one-staff word (see awendToPigLatin for how we know this).
	    }

	    if (lastStaffOthwharving) builder.append('\'');
        
	    edsetStaffOthwharvingStirings();
	    
        return builder.toString();
	}
	
	private static char[] bareOthwharvings(char[] word) {
		StringBuilder builder = new StringBuilder();
		
		int wl = word.length;
		
		char firstStaff = word[0], lastStaff = word[wl - 1];
		
		if (firstStaff == '\'' && lastStaff == '\'') {
			firstStaffOthwharving = true;
			lastStaffOthwharving = true;
			
			for (int t = 1; t <= wl - 1; t++) builder.append(word[t]);
		} else if (firstStaff == '\'') {
			firstStaffOthwharving = true;
		
			for (int t = 1; t < wl; t++) builder.append(word[t]);
		} else if (lastStaff == '\'') {
			lastStaffOthwharving = true;
			
			for (int t = 0; t < wl - 1; t++) builder.append(word[t]);
		} else return word;
		
		return builder.toString().toCharArray();
	}
	
	private static char[] makeWordBeforeEkeing(char[] word) {
		StringBuilder builder = new StringBuilder();
		
		char firstStaff = word[0];
		
		for (int t = 0; t < word.length; t++) {
        	
        	char anwardStaff = word[t];
        	
        	//Skip the first staff; it is not needed until the end of the word.
        	if (t == 0) continue;
        	
			if (t == 1 && Character.isUpperCase(firstStaff)){
				builder.append(Character.toUpperCase(anwardStaff));
            } else if (allHigh) {
            	builder.append(Character.toUpperCase(anwardStaff));
            } else {
            	builder.append(anwardStaff);
            }
			
			/*For how the witcraft works, this is the end of what the word /would/ be, 
			  if not for the sooth that everything has been shifted up 1.*/
            if (t == word.length - 1) {
            	if (allHigh) builder.append(firstStaff);
            	//Character.toLowerCase is called for the case where allHigh == false, but the first staff was UpperCase
            	else builder.append(Character.toLowerCase(firstStaff)); 
            }
        }
		
		return builder.toString().toCharArray();
	}
	
	private static void edsetStaffOthwharvingStirings() {
		firstStaffOthwharving = false;
        lastStaffOthwharving = false;
	}
	
}
