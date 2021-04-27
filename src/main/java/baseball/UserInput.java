package baseball;

import utils.ListUtil;

import java.util.List;
import java.util.Objects;

public class UserInput {

    private List<Character> value;

    private UserInput(String value) {
        setValue(ListUtil.convertStrToList(value));
    }

    public static UserInput of(String value) {
        return new UserInput(value);
    }

    private void setValue(List<Character> value) {
        if (ListUtil.hasUniqueNumber(value) == false) {
            throw new IllegalArgumentException("중복 숫자를 입력할 수 없습니다.");
        }

        if (value.size() != BaseballGameModel.NUMBER_SIZE || ListUtil.hasOnlyNumber(value) == false) {
            throw new IllegalArgumentException("3자리 숫자만 허용합니다.");
        }
        this.value = value;
    }

    public List<Character> getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInput)) return false;
        UserInput userInput = (UserInput) o;
        return Objects.equals(value, userInput.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
