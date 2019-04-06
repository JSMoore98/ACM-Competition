import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int z = scan.nextInt();
		final int SIZE;
		if (z > 10000)
			SIZE = z * 2;
		else
			SIZE = 10000;

		int[] arr = new int[SIZE];
		arr[0] = a;
		int[] as = new int[SIZE];
		as[0] = a;
		int small;
		boolean dup = false;
		boolean foundZ = false;
		int track = 1;
		int tr = 1;
		for (int i = 1; i <= tr; i++) {
			small = smallest(arr, track);
			arr[track] = small;
			track++;
			as[i] = as[i - 1] + small;
			arr[track] = as[i];
			track++;
			tr++;

			int dif;
			if (as[i] == z)
				foundZ = true;

			for (int p = 0; p < tr; p++) {
				dup = false;
				dif = as[i] - as[p];

				if (dif == z) {
					foundZ = true;
				} else {
					for (int n = 0; n < track && !dup; n++) {
						if (dif == arr[n]) {
							dup = true;
						}

						if (!dup) {
							arr[track] = dif;
							track++;
						}
					}
				}
			}

			if (foundZ) {
				System.out.println(i + 1);
				break;
			}
			scan.close();
		}
	}

	public static int smallest(int[] arr, int track) {
		int value = 1;
		boolean found = false;
		boolean f = false;

		while (!found) {
			f = false;
			for (int i = 0; i < track && !f; i++) {
				if (arr[i] == value) {
					f = true;
				}
			}
			if (f == false) {
				found = true;
			}
			value++;
		}
		return value - 1;
	}
}
