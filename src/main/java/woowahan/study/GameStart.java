package woowahan.study;

public class GameStart {
  public static void main(String[] args) {
    try {
      BaseBall baseBall = new BaseBall();
      baseBall.play();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
