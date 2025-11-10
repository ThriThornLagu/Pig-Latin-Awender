package ttl.beworking.awender;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Thread {
	public static String loadThreadAsString(String threadPath) {
		var builder = new StringBuilder();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(threadPath)))) {
			
			String raw;
			
			while ((raw = reader.readLine()) != null) {
				builder.append(raw + "\n");
			}
			
			reader.close();
			
		} catch (IOException b) {
			b.printStackTrace();
			System.out.println("Evil thread: " + threadPath);
		} 
		
		return builder.toString();
	}

	public static String[] BreakThreadToStringList(String wharvedThread) {
		return wharvedThread.split("\n");
	}
	
	public static void writeThreadToNewStead(ArrayList<String> lines, String forelyThread) {
		
		//thoroughsame lode findend
		String TLFLastBit = forelyThread.split("/")[forelyThread.split("/").length - 1];
		/*Get the TLF of this thread; 
		 *edpath it to go into the outputs folder; and
		 *edname it so it doesn't fight with the forely thread.*/
		String newTLF = "outputs/sl_"+  TLFLastBit; 
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(newTLF)))){

			for (String line : lines) {
				writer.write(line + "\n");
			}

			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			
			System.out.println("Could not write new thread: " + newTLF);
		}
		
		System.out.println("Out is found at: " + newTLF);
	}
	
}
