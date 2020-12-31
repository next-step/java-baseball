package validators;

public class EndNumberValidator implements Validator {
    @Override
    public void checkValid(String input) throws Exception {
        if ("1".equals(input) || "2".equals(input)) {
            return;
        }
        throw new Exception("유효하지 않은 인풋 입니다");
    }
};
