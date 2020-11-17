package application;

public class GenerateRandomNumber {

  public static String generateRandomNumber() {
    String randomNumbers = "";
    while (randomNumbers.length() < 3) {
      randomNumbers = isExistNumberCheck(randomNumbers);
    }
    return randomNumbers;
  }

  public static String isExistNumberCheck(String numbers) {

    String target = String.valueOf((int) (Math.random() * 9 + 1));
    if (numbers.contains(target)) {
      return numbers;
    }

    return numbers + target;
  }
}
