import jdk.nashorn.internal.AssertsEnabled;
import jdk.nashorn.internal.AssertsEnabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DealerTest {
    @Test
    public void createDealer() {
        Dealer dealer = new Dealer();

        assertEquals(3, dealer.getList().length);
        assertThat(dealer.getList()[0]).isBetween(1, 9);
        assertThat(dealer.getList()[1]).isBetween(1, 9);
        assertThat(dealer.getList()[2]).isBetween(1, 9);
    }
}