//Noah Cil, September 3, 2020. Unit 0, Lab 1 encoder/decoder.

package unit0;

import java.util.HashMap;

public class ReducedAlphabet {
	
	static HashMap<String, Character> codes = new HashMap<String, Character>();
	
	public static String encode(String message) {
		// Input: a String that is made of uppercase letters,
        //        lowercase letters, commas, spaces, periods,
        //        question marks, and exclamation marks
        
        // Output: a string that has only uppercase letters,
        //         spaces, and periods
		String encoded = "";
		
		for (int i = 0; i < message.length(); i++) {
			char current = message.charAt(i);
			
			if (Character.isLowerCase(current)) {
				if (!codes.containsValue(current))
					codes.put(" ." + Character.toUpperCase(current) + ". ", current);
				encoded += " ." + Character.toUpperCase(current) + ". ";
			}
			else {
				switch (current) {
					case '.':
						if (!codes.containsValue(current))
							codes.put(" . ", current);
						encoded += " . ";
						break;
					case ',':
						if (!codes.containsValue(current))
							codes.put(" .. ", current);
						encoded += " .. ";
						break;
					case '?':
						if (!codes.containsValue(current))
							codes.put(" ... ", current);
						encoded += " ... ";
						break;
					case '!':
						if (!codes.containsValue(current))
							codes.put(" .... ", current);
						encoded += " .... ";
						break;
					default:
						encoded += current;
				}
			}
		}
		
		return encoded;
	}
	
	public static String decode(String encodedMsg) {
		// Input: a string that has only uppercase letters,
        //        spaces, and periods
        
        // Output: a String that is made of uppercase letters,
        //         lowercase letters, commas, spaces, periods,
        //         question marks, and exclamation marks
		String decoded = encodedMsg;
		
		for (HashMap.Entry<String, Character> entry : codes.entrySet()) {
			String key = entry.getKey();
			for (int i = 0; i < decoded.length(); i++) {
				if (i + key.length() <= decoded.length() && decoded.substring(i, i+key.length()).equals(key)) {
					decoded = decoded.substring(0, i) + entry.getValue() + decoded.substring(i+key.length());
					i--;
				}	
			}
		}
		
		return decoded;
	}
	
	public static void main(String[] args) {
		String test = "Hello, this is fun!";
		String encoded = encode(test);
		String decoded = decode(encoded);
		
		System.out.println(encoded);
		System.out.println(decoded);
		
		if (decoded.equals(test))
			System.out.println("Success! At least for this example!");
		else
			System.out.println("Something went wrong!");
	}
}
