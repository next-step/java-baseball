package me.nimkoes.baseball.view;

public interface PlayerInterface {

    // 플레이어가 난수를 맞추기 위해 값을 입력할 때 사용
    String inputNumber();

    // 새 게임을 시작할지 종료할지 판단하기 위해 사용
    boolean checkContinue();

    // 게임을 진행하는 동안 필요한 메시지를 출력
    void printCountMessage(int strikeCount, int ballCount);

    // 게임 종료시 필요한 메시지 출력
    void printEndingMessage(int numberLength);

}
