public class Game {

    private static final String COMMAND_CONTINUE_GAME = "1";
    private static final String COMMAND_END_GAME = "2";

    public static void main(String[] args) {
        final Computer computer = new Computer();
        final Player player = new Player();
        boolean isPlayingGame = true;

        computer.initializeNewNumbers();
        while (isPlayingGame) {
            HintResult hintResult;
            System.out.print("숫자를 입력해주세요: ");

            try {
                hintResult = computer.generateResult(player.submitAnswer());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                break;
            }

            System.out.println(hintResult.getResultMessage());
            if (!hintResult.isAllStrike()) {
                continue;
            }

            System.out.println(String.format("%s개의 숫자를 모두 맞히셨습니다! 게임 종료", Computer.NUMBERS_LENGTH));
            System.out.println(String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", COMMAND_CONTINUE_GAME, COMMAND_END_GAME));

            if (COMMAND_CONTINUE_GAME.equals(player.submitAnswer())) {
                computer.initializeNewNumbers();
                continue;
            }
            isPlayingGame = false;
        }
    }
}
