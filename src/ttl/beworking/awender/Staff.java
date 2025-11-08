package ttl.beworking.awender;

public class Staff {

	public static boolean isMarker(char in) {
		return (Character.isBmpCodePoint(in) && 
				!Character.isAlphabetic(in) && 
				!Character.isWhitespace(in) && 
				!Character.isDigit(in)) ? true : false;
	}
	
	public static boolean isWordEndMark(char in) {
		return (in == '.' || in == '!' || in == '?') ? true : false;
	}
	
}
