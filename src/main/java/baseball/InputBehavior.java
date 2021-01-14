package baseball;

public interface InputBehavior {
    String inputOneInnings();  //야구의 1이닝의 3개 카운트를 입력하는 함수입니다.
    boolean inputIsContinueGame(InningsResult inningsResult); //야구 게임을 끝낼 지, 물어보는 입력 함수입니다.
}