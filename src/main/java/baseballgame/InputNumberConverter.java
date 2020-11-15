package baseballgame;

import java.util.List;

public class InputNumberConverter {
    public InputNumber convertToInputNumber(String input) {
        InputNumberValidator validator = new InputNumberValidator();
        List<String> errors = validator.validate(input);
        if(errors.size() > 0) throw new InputNumberValidException(errors);

        String[] inputArray = input.split("");
        return new InputNumber(
                Integer.parseInt(inputArray[0]),
                Integer.parseInt(inputArray[1]),
                Integer.parseInt(inputArray[2])
        );
    }
}
