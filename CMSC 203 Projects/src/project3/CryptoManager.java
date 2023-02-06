package project3;

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		for (int i = 0; i < plainText.length(); i++) {
			if (plainText.charAt(i) > UPPER_BOUND || plainText.charAt(i) < LOWER_BOUND)
				return false;
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String encryptedText = "";
		
		while (key > RANGE)
			key -= RANGE;
		
		for (int i = 0; i < plainText.length(); i++)	
			encryptedText += (char)(plainText.charAt(i) + key);
		
		return encryptedText;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encryptedText = "";
		
		int charIndex = 0;
		for (int i = bellasoStr.length(); i < plainText.length(); i++) {
			if (charIndex == bellasoStr.length())
				charIndex = 0;
			
			bellasoStr += bellasoStr.charAt(charIndex);
			
			charIndex++;
		}
		
		for (int i = 0; i < plainText.length(); i++) {
			int offset = plainText.charAt(i) + bellasoStr.charAt(i);
			while (offset > Integer.valueOf(UPPER_BOUND))
				offset -= RANGE;
			
			encryptedText += (char)(offset);
		}
		
		return encryptedText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decryptedText = "";
		
		while (key > RANGE)
			key -= RANGE;
		
		for (int i = 0; i < encryptedText.length(); i++)	
			decryptedText += (char)(encryptedText.charAt(i) - key);
		
		return decryptedText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decryptedText = "";
		
		int charIndex = 0;
		for (int i = bellasoStr.length(); i < encryptedText.length(); i++) {
			if (charIndex == bellasoStr.length())
				charIndex = 0;
			
			bellasoStr += bellasoStr.charAt(charIndex);
			
			charIndex++;
		}
		
		//bruh
		for (int i = 0; i < encryptedText.length(); i++) {
//			int offset = encryptedText.charAt(i) - bellasoStr.charAt(i);
			int offset = bellasoStr.charAt(i) + encryptedText.charAt(i);
			while (offset > Integer.valueOf(UPPER_BOUND))
				offset -= RANGE;
			System.out.println("offset is " + offset);
			
			System.out.println("current char is " + encryptedText.charAt(i) + " with value of " + (int)encryptedText.charAt(i));
			int bruh = encryptedText.charAt(i) - (offset - encryptedText.charAt(i));
			System.out.println("adding ASCII of value " + bruh + " which is " + (char)bruh);
			decryptedText += (char)(bruh);
//			decryptedText += (char)();
		}
		
		return decryptedText;
	}
	
	public static void main(String[] args) {
		String temp = encryptBellaso("THIS IS ANOTHER TEST", "CMSC203");
		System.out.println(temp);
		System.out.println(decryptBellaso(temp, "CMSC203"));
	
	}
}
