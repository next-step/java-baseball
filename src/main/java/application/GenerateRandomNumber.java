package application;

public class GenerateRandomNumber {

  public static String generateRandomNumber() {
    String randomNumbers = "";
    while (randomNumbers.length() < 3) {
      String target = String.valueOf((int) (Math.random() * 9 + 1));
      if (randomNumbers.contains(target)) {
        continue;
      }
      randomNumbers += target;
    }
    return randomNumbers;
  }
}
