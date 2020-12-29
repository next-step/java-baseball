public class BullsAndCowsApplication {

    private static final String START_MSG = "게임을 시작합니다.";

    public static void main(String[] args) {
        System.out.print(START_MSG);

        UserInterface userInterface = new UserInterface();
        userInterface.run();
    }
}
