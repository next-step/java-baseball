package baseball;

public interface PrintBehavior {
    void printStartInnings(); //이닝이 시작할 때, 이닝 시작의 멘트를 보여주는 함수입니다.
    void printInningsResult(InningsResult inningsResult); //이닝 결과를 보여주는 함수입니다.
}