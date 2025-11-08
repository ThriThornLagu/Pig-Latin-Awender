package ttl.beworking.awender;

public class Awend {

	public static String toPigLatin(String word) {

		//Break the wise if this word is a marker or whiteyin
        if (Staff.isMarker(word.charAt(0)) || Character.isWhitespace(word.charAt(0))) return word;

        StringBuilder builder = new StringBuilder();
        
        char[] string = word.toCharArray();
        char firstStaff = string[0];
        
        boolean allHigh;
        
        if (string.length >= 2) {
	        if (Character.isUpperCase(string[0]) && Character.isUpperCase(string[1])) allHigh = true;
	        else allHigh = false;
        } else { //It's alright if something like 'iay' happens (but for the cases thate in Main)
        	allHigh = false;
        }
        
        if (string.length >= 2) {
	        for (int t = 0; t < string.length; t++) {
	        	
	        	char anwardStaff = string[t];
	        	
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
	            if (t == string.length - 1) {
	            	if (allHigh) builder.append(firstStaff);
	            	//Character.toLowerCase is called for the case where allHigh == false, but the first staff was UpperCase
	            	else builder.append(Character.toLowerCase(firstStaff)); 
	            }
	        }
	
	        if (allHigh) builder.append("AY");
	        else builder.append("ay");
        } else {
        	builder.append(Character.toLowerCase(firstStaff));
        	builder.append("ay");
        }
        
        return builder.toString();
    }
	
}
