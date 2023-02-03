//heading placeholder

package project1;

import java.util.Scanner;

public class WiFiDiagnosis {
	
	private static String response = "";
	private static Scanner console = new Scanner(System.in);
	
	//i am lazy
	private static void print(String str) {
		System.out.println(str);
	}
	
	//i am lazier 
	private static boolean checkResponse() {
		print("Are you able to connect to the internet? (yes or no)");
		response = console.next();
		if (response.equals("no"))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		print("If you have a problem with internet connectivity, this WiFi Diagnosis might work.\n");
		print("First Step: reboot your computer");
		if (!checkResponse()) {
			print("Second step: reboot your router");
			if (!checkResponse()) {
				print("Third step: make sure the cables to your router are plugged in firmly and your router is getting power");
				if (!checkResponse()) {
					print("Fourth step: move your computer closer to your router");
					if (!checkResponse()) {
						print("Fifth step: contact your ISP");
						print("Make sure your ISP is hooked up to your router.");
					}
					else
						print("moving your computer seemed to work");
				}
				else
					print("Checking the router's cables seemed to work");
			}
			else
				print("rebooting your router seemed to work");
		}
		else
			print("rebooting your computer seemed to work");
		
		console.close();
	}
	
}
