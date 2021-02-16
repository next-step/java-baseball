import domain.BallCount;
import domain.Computer;
import domain.Judge;
import domain.Numbers;
import input.InputView;

public class BaseballApplication {

    public static void main(String[] args) {
        Numbers computerNumbers = Computer.generateNumbers();
        Judge judge = new Judge();
        while (true) {
            String inputNumber = InputView.getNumberInput();
            Numbers numbers = Numbers.of(inputNumber);
            BallCount result = judge.makeDecision(numbers, computerNumbers);
            System.out.println(result);
            if (result.threeStrikes()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
