public final class NumberBaseball {
    private static final int[] NEED_EXIT = null;

    private static boolean playInteractively(int[] theNumber) {
        final int[] enterNumber = UI.enterNumber();
        if (enterNumber == NEED_EXIT) {
            return true;
        }
        final int[] result = Judge.judge(theNumber, enterNumber);
        UI.println(Judge.speak(result));
        if (result[0] == 3) {
            return false;
        }
        return playInteractively(theNumber);
    }

    private static boolean play() {
        final int[] theNumber = NumberGenerator.generate();
        return playInteractively(theNumber);
    }

    public static void main(String[] args) {
        boolean needExit;
        do {
            needExit = play();
        } while (UI.again(needExit));
    }
}
