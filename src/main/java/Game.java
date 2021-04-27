public class Game {

    public static void main(String[] args) {
        final Computer computer = new Computer();
        final Player player = new Player();
        computer.initializeNewNumbers();

        while (true) {
            System.out.print("숫자를 입력해주세요: ");

            try {
                HintResult hintResult = computer.generateResult(player.submitAnswer());
                System.out.println(hintResult.getResultMessage());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
