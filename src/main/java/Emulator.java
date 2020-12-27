public class Emulator {
    public static void main(String[] args){
        boolean willPlay = true;

        while(willPlay){
            BaseballGame game = new BaseballGame();
            game.start();
            willPlay = askWillPlay(false);
        }
    }

    private static boolean askWillPlay(boolean withWrongCommand){
        if(withWrongCommand) {
            System.out.println("잘못된 명령어입니다.");
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int input = InputReader.getNumberInput();
        if(input == 1) return true;
        if(input == 2) return false;

        return askWillPlay(true);
    }
}
