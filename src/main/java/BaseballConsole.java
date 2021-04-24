import java.util.Scanner;

public class BaseballConsole {

	private Scanner scan = new Scanner(System.in); // Scanner 객체

	public String getMessage() {
		return scan.nextLine();
	}

	public String getMessage(String comment) {
		System.out.print(comment);
		return scan.nextLine();
	}

	public void setMessage(String message) {
		System.out.println(message);
	}
}
