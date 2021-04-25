package baseball;

public class BaseballService {

    public boolean validateInputValue(int inputValue) {

        int firstValue = readNumberByPosition(inputValue, 1);
        int secondValue = readNumberByPosition(inputValue, 2);
        int thirdValue = readNumberByPosition(inputValue, 3);

        if (inputValue < 111 || inputValue > 999) {
            System.out.println("잘못된 숫자가 입력되었습니다.");
            return false;
        }

        if (firstValue == secondValue || secondValue == thirdValue || thirdValue == firstValue) {
            System.out.println("중복된 숫자가 입력되었습니다.");
            return false;
        }

        return true;

    }

    public int readNumberByPosition(int number, int position) {

        if (position == 1) {
            return number / 100;
        }

        if (position == 2) {
            return (number % 100) / 10;
        }

        return number % 10;

    }

}
