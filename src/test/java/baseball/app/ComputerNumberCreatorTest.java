package baseball.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.RepeatedTest;


/**
 * @author choijaeyong on 2020/11/15.
 * @project java-baseball
 * @description
 */
public class ComputerNumberCreatorTest {

  @RepeatedTest(20)
  public void createNumber() {
    assertThat(ComputerNumberCreator.create()).isGreaterThanOrEqualTo(100).isLessThanOrEqualTo(999);
  }

}
