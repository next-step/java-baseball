# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

- InputBehavior : 숫자 야구를 입력받는 인터페이스

``` java

public interface InputBehavior {
    String inputQuestion();
}

```

- JudgmentBehavior : 입력 받은 값을 판단하는 인터페이스


``` java

interface JudgmentBehavior {
    JudgmentResult getAnswer(String question);
}


``` 

- PrintBehavior : 숫자 야구에 대한 결과를 출력하는 인터페이스

``` java

interface PrintBehavior {
    void printStage();
    void printResult(JudgmentResult judgmentResult);
}

```

- GameHost : 숫자 야구를 플레이하는 인터페이스

``` Java

interface GameHost {
    void playGame();
}

```
