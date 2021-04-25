package domain.core;

public class InputCoin extends Input {
    private String input;
    private boolean isInput;

    private InputCoin() {
        super();
    }

    public static InputCoin newInstance(){
        return new InputCoin();
    }

    public String getInput() {
        init();
        while (isInput) {
            validInput();
        }
        return input;
    }

    private void init() {
        isInput = true;
    }

    private void validInput() {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = super.in();
            checkError(input);
            isInput = false;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("1 또는 2를 입력해주세요.");
        }
    }

    private void checkError(String input) {
        if (!input.equals("1") &&
                !input.equals("2")) {
            throw new IndexOutOfBoundsException();
        }
    }
}
