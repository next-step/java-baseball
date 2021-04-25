import java.util.Scanner;

public class JavaBaseballPrecourse {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			new Game().start(scan);
		}

	}
}
