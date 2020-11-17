package bymin.game.play;

import static org.junit.jupiter.api.Assertions.*;

import bymin.game.play.MakeNumberBaseBall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MakeNumberBaseBallTest {

    private MakeNumberBaseBall makeNumberBaseBall;

    @BeforeEach
    void initBaseballService() {
        makeNumberBaseBall = new MakeNumberBaseBall();
        makeNumberBaseBall.make();
    }

    @DisplayName("사이즈 체크")
    @Test
    void isValidInputScore() {
//        assertEquals(makeNumberBaseBall.getNumList().size(), 2);
        assertEquals(makeNumberBaseBall.getNumList().size(), 3);
    }

	@DisplayName("사이즈 체크")
	@Test
	void isValidNumListCheck() {
//        assertEquals(makeNumberBaseBall.getNumList().size(), 2);
		assertEquals(makeNumberBaseBall.numListCheck(1), false);
		assertEquals(makeNumberBaseBall.numListCheck(2), false);
		assertEquals(makeNumberBaseBall.numListCheck(3), false);
		assertEquals(makeNumberBaseBall.numListCheck(4), false);
		assertEquals(makeNumberBaseBall.numListCheck(5), false);
		assertEquals(makeNumberBaseBall.numListCheck(6), false);
	}



}
