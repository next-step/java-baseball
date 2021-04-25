package domain.core;

import java.util.ArrayList;
import java.util.List;

public class InputNumber extends Input {
    private final List<Integer> input;
    private boolean isInput;

    private InputNumber() {
        super();
        input = new ArrayList<>();
    }

    public static InputNumber newInstance(){
        return new InputNumber();
    }

    public List<Integer> getInput() {
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
            System.out.print("숫자를 입력해주세요 : ");
            String next = super.in();
            checkError(next);
            extractInt(next);
            isInput = false;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("세자리 숫자만 입력이 가능합니다.");
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력이 가능합니다.");
        }
    }

    private void checkError(String next) {
        if (next.length() != 3) {
            throw new IndexOutOfBoundsException();
        }
        Integer.parseInt(next);
    }

    private void extractInt(String next) {
        input.clear();
        for (int i = 0; i < 3; i++) {
            input.add((int) next.charAt(i) - '0');
        }
    }
}
