package service;

import domain.Com;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseServiceTest {
    BaseService baseService = new BaseServiceImpl();

    @Test
    @DisplayName(value = "UI단 서비스 스트라이크 3개 체크")
    void resultCheckTest() {
        boolean check = baseService.resultCheck(3,0);
        boolean result = false;

        assertEquals(result, check);
    }

    @Test
    @DisplayName(value = "계속 진행하는 지 여부 체크")
    void playChoiceTest() {
        boolean check = baseService.playChoice("2");
        boolean result = true;

        assertEquals(result, check);
    }

    @Test
    @DisplayName(value = "난수 생성 체크")
    void comNantest() {
        Com check = baseService.comNan();
        Com result = new Com();

        assertEquals(result.getClass(), check.getClass());
    }
}
