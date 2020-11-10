import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ComputerTest {

  @Test
  public void newNumberTest() {
    Computer computer = new Computer();

    int actual = computer.newNumber();

    assertThat(actual).isGreaterThanOrEqualTo(123);
    assertThat(actual).isLessThanOrEqualTo(987);
    assertThat(computer.getHundredNumber()).isNotEqualTo(computer.getTenNumber());
    assertThat(computer.getTenNumber()).isNotEqualTo(computer.getOneNumber());
    assertThat(computer.getOneNumber()).isNotEqualTo(computer.getHundredNumber());
  }
}
