import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseBallGame {
	Computer computer = new Computer();
	User user = new User();
	List<Integer> computerNumbers = new ArrayList<>();

	/*
	 * 숫자야구게임 시작
	 * */
	public void start() {
		computer.generateNumbers();
		computerNumbers = computer.getComputerNumbers();

		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.print("세자리 수를 입력하세요 : ");
				String inputValue = sc.nextLine();

				user.validateNumber(inputValue);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
