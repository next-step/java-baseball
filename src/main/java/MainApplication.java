import java.security.SecureRandom;
import java.util.Random;

public class MainApplication {

  public static void main(String[] args) {
    MainApplication mainApplication = new MainApplication();

    String randomNumber = mainApplication.makeRandomNumber(3);
  }

  // 난수 생성
  private String makeRandomNumber(int length) {
    String NUMBERS = "123456789";

    Random random = new SecureRandom();

    StringBuilder randomNumber = new StringBuilder();

    for (int i = 0; i < length; i++) {
      randomNumber.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
    }

    return randomNumber.toString();
  }
}
