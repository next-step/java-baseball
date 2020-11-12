import java.util.Scanner;

public class NumberBaseballGame {
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력해주세요 : ");
		
		String str = scanner.next();
		
		System.out.println(str);

		scanner.close();
		
	}
}
