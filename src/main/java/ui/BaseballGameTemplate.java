package ui;

import domain.exceptions.OutOfBoundBaseballNumberException;
import ui.exceptions.IllegalGameLatchFlagException;
import ui.exceptions.InvalidSizeException;

public class BaseballGameTemplate {
    public static void runBaseballGame(BaseballGameCallback callback) {
        try {
            callback.run();
        } catch (OutOfBoundBaseballNumberException e) {
            System.out.println("1 ~ 9 사이의 숫자를 입력해주세요.");
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력 가능합니다.");
        } catch (InvalidSizeException e) {
            System.out.println("중복 없는 세자리 숫자만 입력 가능합니다.");
        } catch (IllegalGameLatchFlagException e) {
            System.out.println("게임 추가 진행 여부는 1 또는 2로만 입력 가능합니다.");
        } catch (Exception e) {
            System.out.println("알 수 없는 오류로 인해 게임을 종료합니다.");
        }
    }
}
