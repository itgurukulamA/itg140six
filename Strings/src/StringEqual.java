
import java.util.Scanner;

public class StringEqual {
	public static void main(String args[]) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter string1:");
		String str1 = sc.nextLine();
		System.out.println("enter string2:");
		String str2 = sc.nextLine();
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				count = count + 1;
			}
		}
		if (count > 0) {
			System.out.println("not equal");
		} else {
			System.out.println("equal");
		}
	}
}