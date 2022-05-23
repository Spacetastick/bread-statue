package chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise12_13 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner reader = new Scanner(file);
		
		int numChars = 0;
		int numWords = 0;
		int numLines = 0;
		while (reader.hasNextLine()) {
			numLines++;
			String currentLine = reader.nextLine();
			
			Scanner temp = new Scanner(currentLine);
			while (temp.hasNext()) {
				numWords++;
				numChars += temp.next().length();
			}
			temp.close();
		}
		reader.close();
		
		System.out.println("File " + file.getName() + " has");
		System.out.println(numChars + " characters");
		System.out.println(numWords + " words");
		System.out.println(numLines + " lines");
	}
	
}
