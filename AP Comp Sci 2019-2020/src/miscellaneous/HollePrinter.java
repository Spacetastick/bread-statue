//Noah Cil, 9/23/19, purpose is to switch the Os and the Es in "Hellow, World!" so that the console prints "Holle, Werld!"

package miscellaneous;

public class HollePrinter {

	public static void main(String[] args) {
		String str = "Hello, World!";
		System.out.println(str);
		str = str.replace('o', 'e');
		System.out.println(str);
		str = str.replaceFirst("e", "o");
		System.out.println(str);
	}

}





