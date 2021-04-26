package baseball;

public class BaseBall {

    public String getRandomValue() {
        String randomValue;
        boolean validateValue;

        do {
            randomValue = String.valueOf((int) (Math.random() * 999 + 100));
            validateValue = validateNumber(randomValue);
        } while (!validateValue);

        return randomValue;
    }

    public boolean validateNumber(String validateToData) {
        boolean isDuplicate = true;
        int i = 0, size = validateToData.length();

        while (isDuplicate && i < size - 1) {
            isDuplicate = validateInLoop(i++, validateToData);
        }

        return isDuplicate;
    }

    private boolean validateInLoop(int i, String validateToData) {
        boolean checkDuplicateData = true;
        int j = i + 1, size = validateToData.length();

        while (checkDuplicateData && j < size) {
            checkDuplicateData = validateToData.charAt(i) != validateToData.charAt(j++);
        }

        return checkDuplicateData;
    }

}
