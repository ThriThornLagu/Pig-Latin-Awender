package ttl.beworking.awender;

import java.util.ArrayList;
import java.util.Arrays;

public class SpareStirings {
	//Stire if the bits umb what is found through the token is an email.
	public static boolean stireEmail(ArrayList<String> stringsIn, int token) {
		var strings = new ArrayList<String>();
		
		if (token + 2 >= stringsIn.size() ||
			Character.isWhitespace(stringsIn.get(token + 1).charAt(0)) ||
			Character.isWhitespace(stringsIn.get(token - 1).charAt(0))) {
			return false;
		} else {
			//Will stire for this staff being 2 tokens away from a dot.
			//since email@emailHost.com
			if (stringsIn.get(token + 2).charAt(0) == '.') { 
				int lastDealToken = 0;
				for (int t = token + 1; t < stringsIn.size(); t++) {
					if (!Character.isWhitespace(stringsIn.get(t).charAt(0))) {
						lastDealToken = t; //Sets every time another latest token is found.
					} else break;
				}
				
				//This stal infolds something like "My email is email@emailHost.com."
				//So then we take note and make the token before it the lastDealToken.
				//Cannot be folded into the initial stiring for rakes inholding couth domnames (.co.uk, asf.)
				while (Staff.isMarker(stringsIn.get(lastDealToken).charAt(0))) {//A While ring will keep going until all markers are gone.
					lastDealToken--;
				}
				
				//Gets the email bits from before the @
				int firstDealToken = 0;
				for (int t = token - 1; t > 0; t--) { //Offset by one to not get two ampersats (@)
					if (!Character.isWhitespace(stringsIn.get(t).charAt(0)) && !Staff.isMarker(stringsIn.get(t).charAt(0))) {
						firstDealToken = t; //Marks the earliest known token that is deal of the email.
					} else break;
				}

				//Starts reading the whole email as given between the tokens
				for (int t = firstDealToken; t <= lastDealToken; t++) {
					//Starts building the list for building the email and unawends whatever has already been awended.
					//Only unawends if t < token, since all strings before token have been awended, and doing it on anything after is unneeded.
					if (t < token) strings.add(Awend.unawendFromPigLatin(stringsIn.get(t)));
					else strings.add(stringsIn.get(t));
				}
				
				System.out.println("Making email string from:");
				System.out.println(Arrays.toString(strings.toArray()));

				StringBuilder email = new StringBuilder();
				
				//Build the email.
				for (int t = 0; t < strings.size(); t++) {
					email.append(strings.get(t));
				}
				
				//If a not-email gets here, this should fang it. 
				//We stire here so that we don't start fornimming things on a not-email.
				//Again, email@emailHost.com wt. he threw it right@him.
				if (email.toString().contains(".")) {
					//Swap out the first token for the email, and fornim the overeker of strings from lastDealToken to firstDealToken + 1.
					stringsIn.set(firstDealToken, email.toString());
					for (int t = lastDealToken; t > firstDealToken; t--) {
						stringsIn.remove(t);
					}
					
					return true;

				} else return false;
				
			} else return false;
		
		}
		
	}
	
}
