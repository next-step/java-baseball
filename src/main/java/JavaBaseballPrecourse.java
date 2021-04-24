import java.util.Scanner;

public class JavaBaseballPrecourse {

	public static void main(String[] args) {

		System.out.println("hello");
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("입력하신 내용은 : " + scan.nextLine());
			System.out.println("입력하신 내용2는 : " + scan.nextLine());
		}

	}
}
