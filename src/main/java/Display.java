import java.util.Scanner;

public class Display {
	private final Scanner scanner = new Scanner(System.in);

	public String input() {
		return scanner.nextLine().trim();
	}
}
