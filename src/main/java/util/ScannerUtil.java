package util;

import java.util.Scanner;

public class ScannerUtil {

	public static int[] getUserInputAsArray() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요 : ");
		int input = sc.nextInt();
		int[] result = new int[3];
		for (int i=2; i>=0; i--) {
			result[i] = input % 10;
			input /= 10;
		}

		return result;
	}
}
