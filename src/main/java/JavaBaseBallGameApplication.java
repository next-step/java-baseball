import application.BaseballGameUserService;
import interfaces.BaseballGameResource;

public class JavaBaseBallGameApplication {

  public static void main(String[] args) {

    BaseballGameResource baseballGameUserService = new BaseballGameResource();

    while(baseballGameUserService.isGameStatus()) {
      baseballGameUserService.play();
    }
  }
}
