package numberBaseball;

import numberBaseball.controller.NumberBaseBallController;
import numberBaseball.service.NumberBaseBallService;

public class PlayNumberBaseball {
    public static void main(String[] args) {
        NumberBaseBallService numberBaseBallService = new NumberBaseBallService();
        new NumberBaseBallController(numberBaseBallService).run();
    }
}
