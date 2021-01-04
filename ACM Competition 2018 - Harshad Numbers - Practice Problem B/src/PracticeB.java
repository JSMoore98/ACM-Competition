import java.util.Scanner;

public class PracticeB {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int input = s.nextInt();
		int sum = conv(input);
		boolean check;
		check = test(input, sum);
		while (!check) {
			input++;
			sum = conv(input);
			check = test(input, sum);
		}
		System.out.println(input);
		s.close();
	}

	public static int conv(int t) {
		String str = Integer.toString(t);
		int len = str.length();
		int total = 0;
		for (int i = 0; i < len; i++) {
			total = total + ((int) str.charAt(i) - 48);
		}
		return total;
	}

	public static boolean test(int old, int conv) {
		if (old % conv == 0) {
			return true;
		} else {
			return false;
		}
	}
}
